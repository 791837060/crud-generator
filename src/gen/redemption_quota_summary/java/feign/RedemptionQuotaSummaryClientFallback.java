package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.RedemptionQuotaSummaryVO;
import com.coinflex.api.vault.vo.RedemptionQuotaSummaryQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * redemption_quota_summary-FeignClientFallback
 *
 * @author jack
 */
@Component
public class RedemptionQuotaSummaryClientFallback implements IRedemptionQuotaSummaryClient {
    private static final Logger logger = LoggerFactory.getLogger(RedemptionQuotaSummaryClientFallback.class);

    /**
     * 分页查询redemption_quota_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<RedemptionQuotaSummaryVO> getRecordList(RedemptionQuotaSummaryQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询redemption_quota_summary数据
     *
     * @param id  待查询的redemption_quota_summary记录id
     * @return redemption_quota_summary数据
     */
    @Override
    public RedemptionQuotaSummaryVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入redemption_quota_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(RedemptionQuotaSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新redemption_quota_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(RedemptionQuotaSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除redemption_quota_summary记录
     *
     * @param id  待删除的redemption_quota_summary记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}