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

import com.coinflex.api.mortgage.domain.MarketDO;
import com.coinflex.api.mortgage.dto.MarketDTO;
import com.coinflex.api.mortgage.dto.MarketQueryDTO;
import com.coinflex.api.mortgage.util.MarketConverter;
import com.coinflex.api.mortgage.service.IMarketService;
import com.coinflex.api.mortgage.dao.MarketMapper;


/**
 * market服务接口实现
 *
 * @author 
 */
@Service
public class MarketServiceImpl implements IMarketService {
    private static final Logger logger = LoggerFactory.getLogger(MarketServiceImpl.class);

    @Autowired
    private MarketMapper marketMapper;

    /**
     * 分页查询
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<MarketDTO> getRecordList(MarketQueryDTO query) {
        Preconditions.checkArgument(query != null, "查询条件为空");
        Preconditions.checkArgument(query.getPageNo() != null && query.getPageNo() > 0, "页码必须大于0");
        Preconditions.checkArgument(query.getPageSize() != null && query.getPageSize() > 0, "分页大小必须大于0");

        Map<String, Object> queryMap = new HashMap<>();
        if (!MarketConverter.isFieldExists(query.getOrderBy())) {
            //默认使用主键(唯一索引字段)排序
            query.setOrderBy("id");
        } else {
            query.setOrderBy(MarketConverter.getOrderColumn(query.getOrderBy()));
        }
        query.setOrderDirection(MarketConverter.getOrderDirection(query.getOrderDirection()));
        MarketConverter.valuesToMap(query, queryMap, Sets.newHashSet("pageNo", "pageSize"));

        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageInfo<MarketDO> pageInfo = new PageInfo<>(marketMapper.getRecordList(queryMap));
        return MarketConverter.toDTOPageInfo(pageInfo);
    }

    /**
     * 根据主键查询
     *
     * @param id    主键值
     * @return 查询结果
     */
    @Override
    public MarketDTO getRecord(Long id) {
        Preconditions.checkArgument(id != null, "id为空!");
        MarketDO record = marketMapper.getRecordById(id);
        return record != null ? MarketConverter.domainToDTO(record) : null;
    }

    /**
     * 插入记录
     *
     * @param record    待插入的数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(MarketDTO record) {
        MarketDO domain = MarketConverter.dtoToDomain(record);
        checkInsertObject(domain);
        int inserted = marketMapper.insert(domain);
        if (inserted != 0) {
            logger.info("market数据插入成功!");
            return true;
        } else {
            logger.error("market数据插入失败!");
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
     public Boolean insertAll(List<MarketDTO> recordList) {
         Preconditions.checkArgument(!CollectionUtils.isEmpty(recordList), "待插入的数据为空");
         int success = 0;
         //说明: 因为Oracle不允许超过1000个参数，所以此处逐条插入
         for (MarketDTO record : recordList) {
             if (record == null) {
                 continue;
             }
             MarketDO domain = MarketConverter.dtoToDomain(record);
             checkInsertObject(domain);
             if (marketMapper.insert(domain) == 0) {
                 throw new RuntimeException("插入market数据失败!");
             }
             success++;
         }
         logger.info("本次总共插入{}条market数据", success);
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
    public Boolean update(MarketDTO record) {
        Preconditions.checkArgument(record != null, "待更新的数据为空");
        Preconditions.checkArgument(record.getId() != null, "待更新的数据id为空");
        int updated = marketMapper.update(MarketConverter.dtoToDomain(record));
        if (updated != 0) {
            logger.info("market数据更新成功! id={}", record.getId());
            return true;
        } else {
            logger.error("market数据更新失败! id={}", record.getId());
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
    public Boolean delete(Long id) {
        Preconditions.checkArgument(id != null, "id为空!");
        int rowCount = marketMapper.delete(id);
        if (rowCount != 0) {
            logger.info("market数据删除成功! id={}", id);
            return true;
        } else {
            logger.error("market数据删除失败! id={}", id);
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
    public Boolean deleteAll(List<Long> idList) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(idList), "待删除的market数据id列表为空");
        int success = 0;
        MarketDO cond = new MarketDO();
        for (Long id : idList) {
            if (id == null) {
                continue;
            }
            int rowCount = marketMapper.delete(id);
            if (rowCount == 0) {
                logger.error("删除market数据失败! id={}", id);
                throw new RuntimeException("删除market数据失败!");
            }
            success++;
        }
        logger.info("本次总共删除{}条market表数据! idList={}", success, idList);
        return success > 0;
    }


    /**
     * 检查待插入的数据各个非空字段值
     *
     * @param obj 待插入数据
     */
    private void checkInsertObject(MarketDO obj) {
        Preconditions.checkArgument(obj != null, "待插入的数据为空");
        Preconditions.checkArgument(obj.getId() != null, "待插入的数据id为空");
        Preconditions.checkArgument(obj.getMarketId() != null, "待插入的数据market_id为空");
        Preconditions.checkArgument(obj.getMarketCode() != null && StringUtils.isNotBlank(obj.getMarketCode()), "待插入的数据market_code为空");
        Preconditions.checkArgument(obj.getName() != null && StringUtils.isNotBlank(obj.getName()), "待插入的数据name为空");
        Preconditions.checkArgument(obj.getMarketType() != null && StringUtils.isNotBlank(obj.getMarketType()), "待插入的数据market_type为空");
        Preconditions.checkArgument(obj.getBaseInst() != null && StringUtils.isNotBlank(obj.getBaseInst()), "待插入的数据base_inst为空");
        Preconditions.checkArgument(obj.getCounterInst() != null && StringUtils.isNotBlank(obj.getCounterInst()), "待插入的数据counter_inst为空");
        Preconditions.checkArgument(obj.getZone() != null, "待插入的数据zone为空");
        Preconditions.checkArgument(obj.getExclusive() != null, "待插入的数据exclusive为空");
    }
}