package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.InterestSummaryVO;
import com.coinflex.api.vault.vo.InterestSummaryQueryVO;
import com.coinflex.api.vault.feign.InterestSummaryClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * interest_summary-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "interest-summary-service", fallback = InterestSummaryClientFallback.class)
public interface IInterestSummaryClient {

    /**
     * 分页查询interest_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getInterestSummaryList", method = RequestMethod.GET)
    PageInfo<InterestSummaryVO> getRecordList(@SpringQueryMap InterestSummaryQueryVO query);

    /**
     * 根据主键查询interest_summary数据
     *
     * @param id  待查询的interest_summary记录id
     * @return interest_summary数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    InterestSummaryVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入interest_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(InterestSummaryVO vo);

    /**
     * 更新interest_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(InterestSummaryVO vo);

    /**
     * 删除interest_summary记录
     *
     * @param id  待删除的interest_summary记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}