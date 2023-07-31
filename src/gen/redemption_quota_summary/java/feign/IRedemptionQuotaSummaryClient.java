package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.RedemptionQuotaSummaryVO;
import com.coinflex.api.vault.vo.RedemptionQuotaSummaryQueryVO;
import com.coinflex.api.vault.feign.RedemptionQuotaSummaryClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * redemption_quota_summary-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "redemption-quota-summary-service", fallback = RedemptionQuotaSummaryClientFallback.class)
public interface IRedemptionQuotaSummaryClient {

    /**
     * 分页查询redemption_quota_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getRedemptionQuotaSummaryList", method = RequestMethod.GET)
    PageInfo<RedemptionQuotaSummaryVO> getRecordList(@SpringQueryMap RedemptionQuotaSummaryQueryVO query);

    /**
     * 根据主键查询redemption_quota_summary数据
     *
     * @param id  待查询的redemption_quota_summary记录id
     * @return redemption_quota_summary数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    RedemptionQuotaSummaryVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入redemption_quota_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(RedemptionQuotaSummaryVO vo);

    /**
     * 更新redemption_quota_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(RedemptionQuotaSummaryVO vo);

    /**
     * 删除redemption_quota_summary记录
     *
     * @param id  待删除的redemption_quota_summary记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}