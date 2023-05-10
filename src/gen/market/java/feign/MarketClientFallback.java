package com.coinflex.api.mortgage.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.mortgage.vo.MarketVO;
import com.coinflex.api.mortgage.vo.MarketQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * market-FeignClientFallback
 *
 * @author 
 */
@Component
public class MarketClientFallback implements IMarketClient {
    private static final Logger logger = LoggerFactory.getLogger(MarketClientFallback.class);

    /**
     * 分页查询market数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<MarketVO> getRecordList(MarketQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询market数据
     *
     * @param id  待查询的market记录id
     * @return market数据
     */
    @Override
    public MarketVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入market记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(MarketVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新market记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(MarketVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除market记录
     *
     * @param id  待删除的market记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}