package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultSnapshotsVO;
import com.coinflex.api.vault.vo.VaultSnapshotsQueryVO;
import com.coinflex.api.vault.feign.VaultSnapshotsClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * vault_snapshots-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "vault-snapshots-service", fallback = VaultSnapshotsClientFallback.class)
public interface IVaultSnapshotsClient {

    /**
     * 分页查询vault_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getVaultSnapshotsList", method = RequestMethod.GET)
    PageInfo<VaultSnapshotsVO> getRecordList(@SpringQueryMap VaultSnapshotsQueryVO query);

    /**
     * 根据主键查询vault_snapshots数据
     *
     * @param id  待查询的vault_snapshots记录id
     * @return vault_snapshots数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    VaultSnapshotsVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入vault_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(VaultSnapshotsVO vo);

    /**
     * 更新vault_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(VaultSnapshotsVO vo);

    /**
     * 删除vault_snapshots记录
     *
     * @param id  待删除的vault_snapshots记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}