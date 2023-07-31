package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.CoinConvertRecordVO;
import com.coinflex.api.vault.vo.CoinConvertRecordQueryVO;
import com.coinflex.api.vault.feign.CoinConvertRecordClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * coin_convert_record-FeignClient
 *
 * @author jack
 */
@FeignClient(value = "coin-convert-record-service", fallback = CoinConvertRecordClientFallback.class)
public interface ICoinConvertRecordClient {

    /**
     * 分页查询coin_convert_record数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getCoinConvertRecordList", method = RequestMethod.GET)
    PageInfo<CoinConvertRecordVO> getRecordList(@SpringQueryMap CoinConvertRecordQueryVO query);

    /**
     * 根据主键查询coin_convert_record数据
     *
     * @param id  待查询的coin_convert_record记录id
     * @return coin_convert_record数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    CoinConvertRecordVO getRecord(@RequestParam("id") Long id);

    /**
     * 插入coin_convert_record记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(CoinConvertRecordVO vo);

    /**
     * 更新coin_convert_record记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(CoinConvertRecordVO vo);

    /**
     * 删除coin_convert_record记录
     *
     * @param id  待删除的coin_convert_record记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") Long id);
}