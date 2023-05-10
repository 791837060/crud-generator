package com.coinflex.api.mortgage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.mortgage.dto.BorrowHistoryDTO;
import com.coinflex.api.mortgage.dto.BorrowHistoryQueryDTO;


/**
 * borrow_history服务接口
 *
 * @author 
 */
public interface IBorrowHistoryService {

    /**
     * 分页查询
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    PageInfo<BorrowHistoryDTO> getRecordList(BorrowHistoryQueryDTO query);

    /**
     * 根据主键查询
     *
     * @param id    主键值
     * @return 查询结果
     */
    BorrowHistoryDTO getRecord(String id);

    /**
     * 插入记录
     *
     * @param record    待插入的数据
     * @return 是否成功
     */
    Boolean insert(BorrowHistoryDTO record);

    /**
     * 批量插入记录
     *
     * @param recordList    待插入的数据列表
     * @return 是否成功
     */
    Boolean insertAll(List<BorrowHistoryDTO> recordList);

    /**
     * 更新记录
     *
     * @param record    待更新的数据
     * @return 是否成功
     */
    Boolean update(BorrowHistoryDTO record);

    /**
     * 删除记录
     *
     * @param id    待删除的数据主键值
     * @return 是否成功
     */
    Boolean delete(String id);

    /**
     * 批量删除记录
     *
     * @param idList    待删除的数据主键值列表
     * @return 是否成功
     */
    Boolean deleteAll(List<String> idList);
}