package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.PositionSnapshotsVO;
import com.coinflex.api.vault.vo.PositionSnapshotsQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * position_snapshots-FeignClientFallback
 *
 * @author jack
 */
@Component
public class PositionSnapshotsClientFallback implements IPositionSnapshotsClient {
    private static final Logger logger = LoggerFactory.getLogger(PositionSnapshotsClientFallback.class);

    /**
     * 分页查询position_snapshots数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<PositionSnapshotsVO> getRecordList(PositionSnapshotsQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询position_snapshots数据
     *
     * @param id  待查询的position_snapshots记录id
     * @return position_snapshots数据
     */
    @Override
    public PositionSnapshotsVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入position_snapshots记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(PositionSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新position_snapshots记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(PositionSnapshotsVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除position_snapshots记录
     *
     * @param id  待删除的position_snapshots记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}