package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.PositionSnapshotsVO;
import com.coinflex.api.vault.vo.PositionSnapshotsQueryVO;
import com.coinflex.api.vault.feign.PositionSnapshotsClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * position_snapshots-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "position-snapshots-service", fallback = PositionSnapshotsClientFallback.class)
public interface IPositionSnapshotsClient {

    /**
     * 分页查询position_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getPositionSnapshotsList", method = RequestMethod.GET)
    PageInfo<PositionSnapshotsVO> getRecordList(@SpringQueryMap PositionSnapshotsQueryVO query);

    /**
     * 根据主键查询position_snapshots数据
     *
     * @param id  待查询的position_snapshots记录id
     * @return position_snapshots数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    PositionSnapshotsVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入position_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(PositionSnapshotsVO vo);

    /**
     * 更新position_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(PositionSnapshotsVO vo);

    /**
     * 删除position_snapshots记录
     *
     * @param id  待删除的position_snapshots记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}