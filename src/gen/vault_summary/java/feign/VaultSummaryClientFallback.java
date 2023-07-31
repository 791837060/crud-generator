package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultSummaryVO;
import com.coinflex.api.vault.vo.VaultSummaryQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * vault_summary-FeignClientFallback
 *
 * @author jack
 */
@Component
public class VaultSummaryClientFallback implements IVaultSummaryClient {
    private static final Logger logger = LoggerFactory.getLogger(VaultSummaryClientFallback.class);

    /**
     * 分页查询vault_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<VaultSummaryVO> getRecordList(VaultSummaryQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询vault_summary数据
     *
     * @param id  待查询的vault_summary记录id
     * @return vault_summary数据
     */
    @Override
    public VaultSummaryVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入vault_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(VaultSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新vault_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(VaultSummaryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除vault_summary记录
     *
     * @param id  待删除的vault_summary记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}