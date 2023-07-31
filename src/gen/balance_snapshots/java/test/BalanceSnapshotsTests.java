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

import com.coinflex.api.vault.dto.BalanceSnapshotsDTO;
import com.coinflex.api.vault.dto.BalanceSnapshotsQueryDTO;

/**
 * balance_snapshots单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceSnapshotsTests {

    @Autowired
    private IBalanceSnapshotsService balanceSnapshotsService;

    /**
     * 测试分页查询balance_snapshots数据
     */
    @Test
    public void testSelectBalanceSnapshotsList() {
        BalanceSnapshotsQueryDTO query = new BalanceSnapshotsQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(balanceSnapshotsService.getRecordList(query)));
    }

    /**
     * 测试插入1条balance_snapshots数据
     */
    @Test
    public void testInsertBalanceSnapshots() {
        BalanceSnapshotsDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, balanceSnapshotsService.insert(record)));
    }

    /**
     * 测试插入多条balance_snapshots数据
     */
    @Test
    public void testInsertBalanceSnapshotsList() {
        List<BalanceSnapshotsDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, balanceSnapshotsService.insertAll(recordList)));
    }

    /**
     * 测试查询balance_snapshots数据
     */
     @Test
     public void testSelectBalanceSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(balanceSnapshotsService.getRecord(id)));
    }

    /**
     * 测试更新balance_snapshots数据
     */
    @Test
    public void testUpdateBalanceSnapshots() {
        BalanceSnapshotsDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, balanceSnapshotsService.update(record)));
    }

    /**
     * 测试删除balance_snapshots数据
     */
     @Test
     public void testDeleteBalanceSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, balanceSnapshotsService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private BalanceSnapshotsDTO newRecord() {
        BalanceSnapshotsDTO record = new BalanceSnapshotsDTO();
        record.setAccountId(72L);
        record.setInstrumentId("6RfV2cZCM4OL");
        record.setQuantity();
        record.setSnapshotTime(new Date());
        record.setCreated(new Date());
        return record;
    }
}