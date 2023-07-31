package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.CoinConvertRecordVO;
import com.coinflex.api.vault.vo.CoinConvertRecordQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * coin_convert_record-FeignClientFallback
 *
 * @author jack
 */
@Component
public class CoinConvertRecordClientFallback implements ICoinConvertRecordClient {
    private static final Logger logger = LoggerFactory.getLogger(CoinConvertRecordClientFallback.class);

    /**
     * 分页查询coin_convert_record数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<CoinConvertRecordVO> getRecordList(CoinConvertRecordQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询coin_convert_record数据
     *
     * @param id  待查询的coin_convert_record记录id
     * @return coin_convert_record数据
     */
    @Override
    public CoinConvertRecordVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入coin_convert_record记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(CoinConvertRecordVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新coin_convert_record记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(CoinConvertRecordVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除coin_convert_record记录
     *
     * @param id  待删除的coin_convert_record记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}