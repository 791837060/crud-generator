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

import com.coinflex.api.vault.dto.VaultSummaryDTO;
import com.coinflex.api.vault.dto.VaultSummaryQueryDTO;

/**
 * vault_summary单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultSummaryTests {

    @Autowired
    private IVaultSummaryService vaultSummaryService;

    /**
     * 测试分页查询vault_summary数据
     */
    @Test
    public void testSelectVaultSummaryList() {
        VaultSummaryQueryDTO query = new VaultSummaryQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(vaultSummaryService.getRecordList(query)));
    }

    /**
     * 测试插入1条vault_summary数据
     */
    @Test
    public void testInsertVaultSummary() {
        VaultSummaryDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, vaultSummaryService.insert(record)));
    }

    /**
     * 测试插入多条vault_summary数据
     */
    @Test
    public void testInsertVaultSummaryList() {
        List<VaultSummaryDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, vaultSummaryService.insertAll(recordList)));
    }

    /**
     * 测试查询vault_summary数据
     */
     @Test
     public void testSelectVaultSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(vaultSummaryService.getRecord(id)));
    }

    /**
     * 测试更新vault_summary数据
     */
    @Test
    public void testUpdateVaultSummary() {
        VaultSummaryDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, vaultSummaryService.update(record)));
    }

    /**
     * 测试删除vault_summary数据
     */
     @Test
     public void testDeleteVaultSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, vaultSummaryService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private VaultSummaryDTO newRecord() {
        VaultSummaryDTO record = new VaultSummaryDTO();
        record.setAccountId(73L);
        record.setMainAccountId(58L);
        record.setDepositAmount();
        record.setTakeEffectAmount();
        record.setPoolId(73L);
        record.setLastUpdatedAt(new Date());
        record.setDividendAmount();
        record.setTotalAmount();
        record.setTotalRedeem();
        record.setCreatedAt(new Date());
        return record;
    }
}