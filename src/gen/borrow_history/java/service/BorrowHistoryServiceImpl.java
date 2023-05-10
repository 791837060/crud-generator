package com.coinflex.api.mortgage.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Preconditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.coinflex.api.mortgage.domain.BorrowHistoryDO;
import com.coinflex.api.mortgage.dto.BorrowHistoryDTO;
import com.coinflex.api.mortgage.dto.BorrowHistoryQueryDTO;
import com.coinflex.api.mortgage.util.BorrowHistoryConverter;
import com.coinflex.api.mortgage.service.IBorrowHistoryService;
import com.coinflex.api.mortgage.dao.BorrowHistoryMapper;


/**
 * borrow_history服务接口实现
 *
 * @author 
 */
@Service
public class BorrowHistoryServiceImpl implements IBorrowHistoryService {
    private static final Logger logger = LoggerFactory.getLogger(BorrowHistoryServiceImpl.class);

    @Autowired
    private BorrowHistoryMapper borrowHistoryMapper;

    /**
     * 分页查询
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<BorrowHistoryDTO> getRecordList(BorrowHistoryQueryDTO query) {
        Preconditions.checkArgument(query != null, "查询条件为空");
        Preconditions.checkArgument(query.getPageNo() != null && query.getPageNo() > 0, "页码必须大于0");
        Preconditions.checkArgument(query.getPageSize() != null && query.getPageSize() > 0, "分页大小必须大于0");

        Map<String, Object> queryMap = new HashMap<>();
        if (!BorrowHistoryConverter.isFieldExists(query.getOrderBy())) {
            //默认使用主键(唯一索引字段)排序
            query.setOrderBy("id");
        } else {
            query.setOrderBy(BorrowHistoryConverter.getOrderColumn(query.getOrderBy()));
        }
        query.setOrderDirection(BorrowHistoryConverter.getOrderDirection(query.getOrderDirection()));
        BorrowHistoryConverter.valuesToMap(query, queryMap, Sets.newHashSet("pageNo", "pageSize"));

        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageInfo<BorrowHistoryDO> pageInfo = new PageInfo<>(borrowHistoryMapper.getRecordList(queryMap));
        return BorrowHistoryConverter.toDTOPageInfo(pageInfo);
    }

    /**
     * 根据主键查询
     *
     * @param id    主键值
     * @return 查询结果
     */
    @Override
    public BorrowHistoryDTO getRecord(String id) {
        Preconditions.checkArgument(StringUtils.isNotBlank(id), "id为空!");
        BorrowHistoryDO record = borrowHistoryMapper.getRecordById(id);
        return record != null ? BorrowHistoryConverter.domainToDTO(record) : null;
    }

    /**
     * 插入记录
     *
     * @param record    待插入的数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(BorrowHistoryDTO record) {
        BorrowHistoryDO domain = BorrowHistoryConverter.dtoToDomain(record);
        checkInsertObject(domain);
        int inserted = borrowHistoryMapper.insert(domain);
        if (inserted != 0) {
            logger.info("borrow_history数据插入成功!");
            return true;
        } else {
            logger.error("borrow_history数据插入失败!");
            return false;
        }
    }

    /**
     * 批量插入记录
     *
     * @param recordList    待插入的数据列表
     * @return 是否成功
     */
     @Override
     @Transactional(rollbackFor = Exception.class)
     public Boolean insertAll(List<BorrowHistoryDTO> recordList) {
         Preconditions.checkArgument(!CollectionUtils.isEmpty(recordList), "待插入的数据为空");
         int success = 0;
         //说明: 因为Oracle不允许超过1000个参数，所以此处逐条插入
         for (BorrowHistoryDTO record : recordList) {
             if (record == null) {
                 continue;
             }
             BorrowHistoryDO domain = BorrowHistoryConverter.dtoToDomain(record);
             checkInsertObject(domain);
             if (borrowHistoryMapper.insert(domain) == 0) {
                 throw new RuntimeException("插入borrow_history数据失败!");
             }
             success++;
         }
         logger.info("本次总共插入{}条borrow_history数据", success);
         return success > 0;
     }

    /**
     * 更新记录
     *
     * @param record    待更新的数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(BorrowHistoryDTO record) {
        Preconditions.checkArgument(record != null, "待更新的数据为空");
        Preconditions.checkArgument(record.getId() != null, "待更新的数据id为空");
        int updated = borrowHistoryMapper.update(BorrowHistoryConverter.dtoToDomain(record));
        if (updated != 0) {
            logger.info("borrow_history数据更新成功! id={}", record.getId());
            return true;
        } else {
            logger.error("borrow_history数据更新失败! id={}", record.getId());
            return false;
        }
    }

    /**
     * 删除记录
     *
     * @param id    待删除的数据主键值
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(String id) {
        Preconditions.checkArgument(StringUtils.isNotBlank(id), "id为空!");
        int rowCount = borrowHistoryMapper.delete(id);
        if (rowCount != 0) {
            logger.info("borrow_history数据删除成功! id={}", id);
            return true;
        } else {
            logger.error("borrow_history数据删除失败! id={}", id);
            return false;
        }
    }

    /**
     * 批量删除记录
     *
     * @param idList    待删除的数据主键值列表
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteAll(List<String> idList) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(idList), "待删除的borrow_history数据id列表为空");
        int success = 0;
        BorrowHistoryDO cond = new BorrowHistoryDO();
        for (String id : idList) {
            if (StringUtils.isBlank(id)) {
                continue;
            }
            int rowCount = borrowHistoryMapper.delete(id);
            if (rowCount == 0) {
                logger.error("删除borrow_history数据失败! id={}", id);
                throw new RuntimeException("删除borrow_history数据失败!");
            }
            success++;
        }
        logger.info("本次总共删除{}条borrow_history表数据! idList={}", success, idList);
        return success > 0;
    }


    /**
     * 检查待插入的数据各个非空字段值
     *
     * @param obj 待插入数据
     */
    private void checkInsertObject(BorrowHistoryDO obj) {
        Preconditions.checkArgument(obj != null, "待插入的数据为空");
        Preconditions.checkArgument(obj.getId() != null && StringUtils.isNotBlank(obj.getId()), "待插入的数据id为空");
        Preconditions.checkArgument(obj.getAccountId() != null, "待插入的数据account_id为空");
        Preconditions.checkArgument(obj.getCollateral() != null && StringUtils.isNotBlank(obj.getCollateral()), "待插入的数据collateral为空");
        Preconditions.checkArgument(obj.getCreatedAt() != null, "待插入的数据created_at为空");
        Preconditions.checkArgument(obj.getBusinessType() != null && StringUtils.isNotBlank(obj.getBusinessType()), "待插入的数据business_type为空");
        Preconditions.checkArgument(obj.getActionType() != null && StringUtils.isNotBlank(obj.getActionType()), "待插入的数据action_type为空");
        Preconditions.checkArgument(obj.getLastUpdatedAt() != null, "待插入的数据last_updated_at为空");
    }
}