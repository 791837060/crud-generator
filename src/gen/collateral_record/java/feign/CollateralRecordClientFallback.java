package com.coinflex.api.accountvalue.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.accountvalue.vo.CollateralRecordVO;
import com.coinflex.api.accountvalue.vo.CollateralRecordQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * collateral_record-FeignClientFallback
 *
 * @author jack
 */
@Component
public class CollateralRecordClientFallback implements ICollateralRecordClient {
    private static final Logger logger = LoggerFactory.getLogger(CollateralRecordClientFallback.class);

    /**
     * 分页查询collateral_record数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<CollateralRecordVO> getRecordList(CollateralRecordQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询collateral_record数据
     *
     * @param id  待查询的collateral_record记录id
     * @return collateral_record数据
     */
    @Override
    public CollateralRecordVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入collateral_record记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(CollateralRecordVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新collateral_record记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(CollateralRecordVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除collateral_record记录
     *
     * @param id  待删除的collateral_record记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}