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

import com.coinflex.api.vault.dto.VaultBalanceSnapshotsDTO;
import com.coinflex.api.vault.dto.VaultBalanceSnapshotsQueryDTO;

/**
 * vault_balance_snapshots单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultBalanceSnapshotsTests {

    @Autowired
    private IVaultBalanceSnapshotsService vaultBalanceSnapshotsService;

    /**
     * 测试分页查询vault_balance_snapshots数据
     */
    @Test
    public void testSelectVaultBalanceSnapshotsList() {
        VaultBalanceSnapshotsQueryDTO query = new VaultBalanceSnapshotsQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(vaultBalanceSnapshotsService.getRecordList(query)));
    }

    /**
     * 测试插入1条vault_balance_snapshots数据
     */
    @Test
    public void testInsertVaultBalanceSnapshots() {
        VaultBalanceSnapshotsDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, vaultBalanceSnapshotsService.insert(record)));
    }

    /**
     * 测试插入多条vault_balance_snapshots数据
     */
    @Test
    public void testInsertVaultBalanceSnapshotsList() {
        List<VaultBalanceSnapshotsDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, vaultBalanceSnapshotsService.insertAll(recordList)));
    }

    /**
     * 测试查询vault_balance_snapshots数据
     */
     @Test
     public void testSelectVaultBalanceSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(vaultBalanceSnapshotsService.getRecord(id)));
    }

    /**
     * 测试更新vault_balance_snapshots数据
     */
    @Test
    public void testUpdateVaultBalanceSnapshots() {
        VaultBalanceSnapshotsDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, vaultBalanceSnapshotsService.update(record)));
    }

    /**
     * 测试删除vault_balance_snapshots数据
     */
     @Test
     public void testDeleteVaultBalanceSnapshots() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, vaultBalanceSnapshotsService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private VaultBalanceSnapshotsDTO newRecord() {
        VaultBalanceSnapshotsDTO record = new VaultBalanceSnapshotsDTO();
        record.setAccountId(29L);
        record.setMainAccountId(94L);
        record.setCoin("ag2fdHDFJTPwP3Gl8rMF8MNEBOaME1Q");
        record.setSnapshotTime("VRT9B8OyW8e2FFwRm");
        record.setQuantity();
        record.setInterestRate();
        record.setInterestAmount();
        record.setDeductedStatus("8EDcJTJ6Sa3teRLY0cVNP7lLZ9Sw7KX49");
        record.setDeductedTime(new Date());
        record.setLastUpdatedAt(new Date());
        return record;
    }
}