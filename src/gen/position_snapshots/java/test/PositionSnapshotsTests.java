package com.coinflex.api.vault.test.test;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coinflex.api.vault.dto.PositionSnapshotsDTO;
import com.coinflex.api.vault.dto.PositionSnapshotsQueryDTO;

/**
 * position_snapshots单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionSnapshotsTests {

    @Autowired
    private IPositionSnapshotsService positionSnapshotsService;

    /**
     * 测试分页查询position_snapshots数据
     */
    @Test
    public void testSelectPositionSnapshotsList() {
        PositionSnapshotsQueryDTO query = new PositionSnapshotsQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(positionSnapshotsService.getRecordList(query)));
    }

    /**
     * 测试插入1条position_snapshots数据
     */
    @Test
    public void testInsertPositionSnapshots() {
        PositionSnapshotsDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, positionSnapshotsService.insert(record)));
    }

    /**
     * 测试插入多条position_snapshots数据
     */
    @Test
    public void testInsertPositionSnapshotsList() {
        List<PositionSnapshotsDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, positionSnapshotsService.insertAll(recordList)));
    }

    /**
     * 测试查询position_snapshots数据
     */
     @Test
     public void testSelectPositionSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(positionSnapshotsService.getRecord(id)));
    }

    /**
     * 测试更新position_snapshots数据
     */
    @Test
    public void testUpdatePositionSnapshots() {
        PositionSnapshotsDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, positionSnapshotsService.update(record)));
    }

    /**
     * 测试删除position_snapshots数据
     */
     @Test
     public void testDeletePositionSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, positionSnapshotsService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private PositionSnapshotsDTO newRecord() {
        PositionSnapshotsDTO record = new PositionSnapshotsDTO();
        record.setAccountId(41L);
        record.setMarketCode("wGMmwCIR4Vc");
        record.setQuantity();
        record.setMarkPrice();
        record.setSnapshotTime(new Date());
        return record;
    }
}