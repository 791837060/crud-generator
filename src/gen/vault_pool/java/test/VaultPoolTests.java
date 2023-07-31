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

import com.coinflex.api.vault.dto.VaultPoolDTO;
import com.coinflex.api.vault.dto.VaultPoolQueryDTO;

/**
 * vault_pool单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultPoolTests {

    @Autowired
    private IVaultPoolService vaultPoolService;

    /**
     * 测试分页查询vault_pool数据
     */
    @Test
    public void testSelectVaultPoolList() {
        VaultPoolQueryDTO query = new VaultPoolQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(vaultPoolService.getRecordList(query)));
    }

    /**
     * 测试插入1条vault_pool数据
     */
    @Test
    public void testInsertVaultPool() {
        VaultPoolDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, vaultPoolService.insert(record)));
    }

    /**
     * 测试插入多条vault_pool数据
     */
    @Test
    public void testInsertVaultPoolList() {
        List<VaultPoolDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, vaultPoolService.insertAll(recordList)));
    }

    /**
     * 测试查询vault_pool数据
     */
     @Test
     public void testSelectVaultPool() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(vaultPoolService.getRecord(id)));
    }

    /**
     * 测试更新vault_pool数据
     */
    @Test
    public void testUpdateVaultPool() {
        VaultPoolDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, vaultPoolService.update(record)));
    }

    /**
     * 测试删除vault_pool数据
     */
     @Test
     public void testDeleteVaultPool() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, vaultPoolService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private VaultPoolDTO newRecord() {
        VaultPoolDTO record = new VaultPoolDTO();
        record.setToken("uwBMY");
        record.setPoolName("KL6EOAOdpuLQLnQyVh");
        record.setAccountId(81L);
        record.setTotalAmount();
        record.setTakeEffectTotalAmount();
        return record;
    }
}