package com.coinflex.api.mortgage.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.mortgage.vo.MarketVO;
import com.coinflex.api.mortgage.vo.MarketQueryVO;
import com.coinflex.api.mortgage.feign.MarketClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * market-FeignClient
 *
 * @author 
 */
@FeignClient(value = "market-service", fallback = MarketClientFallback.class)
public interface IMarketClient {

    /**
     * 分页查询market数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getMarketList", method = RequestMethod.GET)
    PageInfo<MarketVO> getRecordList(@SpringQueryMap MarketQueryVO query);

    /**
     * 根据主键查询market数据
     *
     * @param id  待查询的market记录id
     * @return market数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    MarketVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入market记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(MarketVO vo);

    /**
     * 更新market记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(MarketVO vo);

    /**
     * 删除market记录
     *
     * @param id  待删除的market记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}