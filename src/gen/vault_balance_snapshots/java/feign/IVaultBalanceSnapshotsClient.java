package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultBalanceSnapshotsVO;
import com.coinflex.api.vault.vo.VaultBalanceSnapshotsQueryVO;
import com.coinflex.api.vault.feign.VaultBalanceSnapshotsClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * vault_balance_snapshots-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "vault-balance-snapshots-service", fallback = VaultBalanceSnapshotsClientFallback.class)
public interface IVaultBalanceSnapshotsClient {

    /**
     * 分页查询vault_balance_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getVaultBalanceSnapshotsList", method = RequestMethod.GET)
    PageInfo<VaultBalanceSnapshotsVO> getRecordList(@SpringQueryMap VaultBalanceSnapshotsQueryVO query);

    /**
     * 根据主键查询vault_balance_snapshots数据
     *
     * @param id  待查询的vault_balance_snapshots记录id
     * @return vault_balance_snapshots数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    VaultBalanceSnapshotsVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入vault_balance_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(VaultBalanceSnapshotsVO vo);

    /**
     * 更新vault_balance_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(VaultBalanceSnapshotsVO vo);

    /**
     * 删除vault_balance_snapshots记录
     *
     * @param id  待删除的vault_balance_snapshots记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}