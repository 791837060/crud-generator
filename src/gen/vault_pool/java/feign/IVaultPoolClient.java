package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultPoolVO;
import com.coinflex.api.vault.vo.VaultPoolQueryVO;
import com.coinflex.api.vault.feign.VaultPoolClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * vault_pool-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "vault-pool-service", fallback = VaultPoolClientFallback.class)
public interface IVaultPoolClient {

    /**
     * 分页查询vault_pool数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getVaultPoolList", method = RequestMethod.GET)
    PageInfo<VaultPoolVO> getRecordList(@SpringQueryMap VaultPoolQueryVO query);

    /**
     * 根据主键查询vault_pool数据
     *
     * @param id  待查询的vault_pool记录id
     * @return vault_pool数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    VaultPoolVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入vault_pool记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(VaultPoolVO vo);

    /**
     * 更新vault_pool记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(VaultPoolVO vo);

    /**
     * 删除vault_pool记录
     *
     * @param id  待删除的vault_pool记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}