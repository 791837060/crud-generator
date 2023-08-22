package com.coinflex.api.accountvalue.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.accountvalue.vo.CollateralRecordVO;
import com.coinflex.api.accountvalue.vo.CollateralRecordQueryVO;
import com.coinflex.api.accountvalue.feign.CollateralRecordClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * collateral_record-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "collateral-record-service", fallback = CollateralRecordClientFallback.class)
public interface ICollateralRecordClient {

    /**
     * 分页查询collateral_record数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getCollateralRecordList", method = RequestMethod.GET)
    PageInfo<CollateralRecordVO> getRecordList(@SpringQueryMap CollateralRecordQueryVO query);

    /**
     * 根据主键查询collateral_record数据
     *
     * @param id  待查询的collateral_record记录id
     * @return collateral_record数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    CollateralRecordVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入collateral_record记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(CollateralRecordVO vo);

    /**
     * 更新collateral_record记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(CollateralRecordVO vo);

    /**
     * 删除collateral_record记录
     *
     * @param id  待删除的collateral_record记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}