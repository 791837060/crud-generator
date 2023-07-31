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

import com.coinflex.api.vault.dto.VaultSnapshotsDTO;
import com.coinflex.api.vault.dto.VaultSnapshotsQueryDTO;

/**
 * vault_snapshots单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultSnapshotsTests {

    @Autowired
    private IVaultSnapshotsService vaultSnapshotsService;

    /**
     * 测试分页查询vault_snapshots数据
     */
    @Test
    public void testSelectVaultSnapshotsList() {
        VaultSnapshotsQueryDTO query = new VaultSnapshotsQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(vaultSnapshotsService.getRecordList(query)));
    }

    /**
     * 测试插入1条vault_snapshots数据
     */
    @Test
    public void testInsertVaultSnapshots() {
        VaultSnapshotsDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, vaultSnapshotsService.insert(record)));
    }

    /**
     * 测试插入多条vault_snapshots数据
     */
    @Test
    public void testInsertVaultSnapshotsList() {
        List<VaultSnapshotsDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, vaultSnapshotsService.insertAll(recordList)));
    }

    /**
     * 测试查询vault_snapshots数据
     */
     @Test
     public void testSelectVaultSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(vaultSnapshotsService.getRecord(id)));
    }

    /**
     * 测试更新vault_snapshots数据
     */
    @Test
    public void testUpdateVaultSnapshots() {
        VaultSnapshotsDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, vaultSnapshotsService.update(record)));
    }

    /**
     * 测试删除vault_snapshots数据
     */
     @Test
     public void testDeleteVaultSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, vaultSnapshotsService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private VaultSnapshotsDTO newRecord() {
        VaultSnapshotsDTO record = new VaultSnapshotsDTO();
        record.setVaultSummaryId(75L);
        record.setPoolId(74L);
        record.setAccountId(50L);
        record.setMainAccountId(58L);
        record.setTotalAmount();
        record.setTakeEffectAmount();
        record.setSnapshotTime("XtocZ0i1NBKU");
        record.setDividendAmount();
        record.setDividendTime(new Date());
        record.setDividendStatus("Uu60x0pHys3KABsWHpt5rkWTCvfNcXkhvfu");
        record.setPoolTakeEffectTotalAmount();
        record.setPoolInterestRate();
        record.setPoolTotalInterest();
        return record;
    }
}