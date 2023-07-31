package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.InterestSummaryVO;
import com.coinflex.api.vault.vo.InterestSummaryQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * interest_summary-FeignClientFallback
 *
 * @author jack
 */
@Component
public class InterestSummaryClientFallback implements IInterestSummaryClient {
    private static final Logger logger = LoggerFactory.getLogger(InterestSummaryClientFallback.class);

    /**
     * 分页查询interest_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<InterestSummaryVO> getRecordList(InterestSummaryQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询interest_summary数据
     *
     * @param id  待查询的interest_summary记录id
     * @return interest_summary数据
     */
    @Override
    public InterestSummaryVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入interest_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(InterestSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新interest_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(InterestSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除interest_summary记录
     *
     * @param id  待删除的interest_summary记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}