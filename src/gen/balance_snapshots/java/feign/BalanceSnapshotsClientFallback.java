package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.BalanceSnapshotsVO;
import com.coinflex.api.vault.vo.BalanceSnapshotsQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * balance_snapshots-FeignClientFallback
 *
 * @author jack
 */
@Component
public class BalanceSnapshotsClientFallback implements IBalanceSnapshotsClient {
    private static final Logger logger = LoggerFactory.getLogger(BalanceSnapshotsClientFallback.class);

    /**
     * 分页查询balance_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<BalanceSnapshotsVO> getRecordList(BalanceSnapshotsQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询balance_snapshots数据
     *
     * @param id  待查询的balance_snapshots记录id
     * @return balance_snapshots数据
     */
    @Override
    public BalanceSnapshotsVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入balance_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(BalanceSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新balance_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(BalanceSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除balance_snapshots记录
     *
     * @param id  待删除的balance_snapshots记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}