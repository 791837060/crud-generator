package com.coinflex.api.mortgage.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.mortgage.vo.BorrowHistoryVO;
import com.coinflex.api.mortgage.vo.BorrowHistoryQueryVO;
import com.coinflex.api.mortgage.feign.BorrowHistoryClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * borrow_history-FeignClient
 *
 * @author 
 */
@FeignClient(value = "borrow-history-service", fallback = BorrowHistoryClientFallback.class)
public interface IBorrowHistoryClient {

    /**
     * 分页查询borrow_history数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/getBorrowHistoryList", method = RequestMethod.GET)
    PageInfo<BorrowHistoryVO> getRecordList(@SpringQueryMap BorrowHistoryQueryVO query);

    /**
     * 根据主键查询borrow_history数据
     *
     * @param id  待查询的borrow_history记录id
     * @return borrow_history数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    BorrowHistoryVO getRecord(@RequestParam("id") String id);

    /**
     * 插入borrow_history记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    Boolean insert(BorrowHistoryVO vo);

    /**
     * 更新borrow_history记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Boolean update(BorrowHistoryVO vo);

    /**
     * 删除borrow_history记录
     *
     * @param id  待删除的borrow_history记录id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Boolean delete(@PathVariable("id") String id);
}