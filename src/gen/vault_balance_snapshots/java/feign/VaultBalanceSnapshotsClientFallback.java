package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultBalanceSnapshotsVO;
import com.coinflex.api.vault.vo.VaultBalanceSnapshotsQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * vault_balance_snapshots-FeignClientFallback
 *
 * @author jack
 */
@Component
public class VaultBalanceSnapshotsClientFallback implements IVaultBalanceSnapshotsClient {
    private static final Logger logger = LoggerFactory.getLogger(VaultBalanceSnapshotsClientFallback.class);

    /**
     * 分页查询vault_balance_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<VaultBalanceSnapshotsVO> getRecordList(VaultBalanceSnapshotsQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询vault_balance_snapshots数据
     *
     * @param id  待查询的vault_balance_snapshots记录id
     * @return vault_balance_snapshots数据
     */
    @Override
    public VaultBalanceSnapshotsVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入vault_balance_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(VaultBalanceSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新vault_balance_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(VaultBalanceSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除vault_balance_snapshots记录
     *
     * @param id  待删除的vault_balance_snapshots记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}