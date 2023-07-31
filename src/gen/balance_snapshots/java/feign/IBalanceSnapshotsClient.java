package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.BalanceSnapshotsVO;
import com.coinflex.api.vault.vo.BalanceSnapshotsQueryVO;
import com.coinflex.api.vault.feign.BalanceSnapshotsClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * balance_snapshots-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "balance-snapshots-service", fallback = BalanceSnapshotsClientFallback.class)
public interface IBalanceSnapshotsClient {

    /**
     * 分页查询balance_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getBalanceSnapshotsList", method = RequestMethod.GET)
    PageInfo<BalanceSnapshotsVO> getRecordList(@SpringQueryMap BalanceSnapshotsQueryVO query);

    /**
     * 根据主键查询balance_snapshots数据
     *
     * @param id  待查询的balance_snapshots记录id
     * @return balance_snapshots数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    BalanceSnapshotsVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入balance_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(BalanceSnapshotsVO vo);

    /**
     * 更新balance_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(BalanceSnapshotsVO vo);

    /**
     * 删除balance_snapshots记录
     *
     * @param id  待删除的balance_snapshots记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}