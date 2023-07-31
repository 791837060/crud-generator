package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultSummaryVO;
import com.coinflex.api.vault.vo.VaultSummaryQueryVO;
import com.coinflex.api.vault.feign.VaultSummaryClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * vault_summary-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "vault-summary-service", fallback = VaultSummaryClientFallback.class)
public interface IVaultSummaryClient {

    /**
     * 分页查询vault_summary数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getVaultSummaryList", method = RequestMethod.GET)
    PageInfo<VaultSummaryVO> getRecordList(@SpringQueryMap VaultSummaryQueryVO query);

    /**
     * 根据主键查询vault_summary数据
     *
     * @param id  待查询的vault_summary记录id
     * @return vault_summary数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    VaultSummaryVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入vault_summary记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(VaultSummaryVO vo);

    /**
     * 更新vault_summary记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(VaultSummaryVO vo);

    /**
     * 删除vault_summary记录
     *
     * @param id  待删除的vault_summary记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}