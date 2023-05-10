package com.coinflex.api.mortgage.dao;

import com.coinflex.api.mortgage.domain.MarketDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * marketMapper
 * 说明：
 * 1.适用于原版Mybatis
 * 2.如有自定义SQL逻辑，不要直接在本接口中编写，而应该重新编写一个接口来继承本接口
 *
 * @author 
 */
@Mapper
public interface MarketMapper {

    /**
     * 查询
     *
     * @param query 查询条件
     * @return 查询结果
     */
    List<MarketDO> getRecordList(Map<String, Object> query);

    /**
     * 根据主键查询
     *
     * @param id 主键值
     * @return 查询结果
     */
    MarketDO getRecordById(@Param("id") Long id);

    /**
     * 查询数量
     *
     * @param query 查询条件
     * @return 查询结果
     */
    long getRecordCount(Map<String, Object> query);

    /**
     * 插入
     *
     * @param record 待插入数据
     * @return 插入行数
     */
    int insert(MarketDO record);

    /**
     * 更新
     *
     * @param record 待更新数据
     * @return 更新行数
     */
    int update(MarketDO record);

    /**
     * 删除
     *
     * @param record 待删除数据
     * @return 删除行数
     */
    int delete(@Param("id") Long id);
}