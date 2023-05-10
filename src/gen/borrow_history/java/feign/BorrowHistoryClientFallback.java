package com.coinflex.api.mortgage.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.mortgage.vo.BorrowHistoryVO;
import com.coinflex.api.mortgage.vo.BorrowHistoryQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * borrow_history-FeignClientFallback
 *
 * @author 
 */
@Component
public class BorrowHistoryClientFallback implements IBorrowHistoryClient {
    private static final Logger logger = LoggerFactory.getLogger(BorrowHistoryClientFallback.class);

    /**
     * 分页查询borrow_history数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<BorrowHistoryVO> getRecordList(BorrowHistoryQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询borrow_history数据
     *
     * @param id  待查询的borrow_history记录id
     * @return borrow_history数据
     */
    @Override
    public BorrowHistoryVO getRecord(String id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入borrow_history记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(BorrowHistoryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新borrow_history记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(BorrowHistoryVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除borrow_history记录
     *
     * @param id  待删除的borrow_history记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(String id) {
        //TODO 处理异常情况
        return false;
    }
}