package com.coinflex.api.accountvalue.test.test;

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

import com.coinflex.api.accountvalue.dto.CollateralRecordDTO;
import com.coinflex.api.accountvalue.dto.CollateralRecordQueryDTO;

/**
 * collateral_record单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollateralRecordTests {

    @Autowired
    private ICollateralRecordService collateralRecordService;

    /**
     * 测试分页查询collateral_record数据
     */
    @Test
    public void testSelectCollateralRecordList() {
        CollateralRecordQueryDTO query = new CollateralRecordQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(collateralRecordService.getRecordList(query)));
    }

    /**
     * 测试插入1条collateral_record数据
     */
    @Test
    public void testInsertCollateralRecord() {
        CollateralRecordDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, collateralRecordService.insert(record)));
    }

    /**
     * 测试插入多条collateral_record数据
     */
    @Test
    public void testInsertCollateralRecordList() {
        List<CollateralRecordDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, collateralRecordService.insertAll(recordList)));
    }

    /**
     * 测试查询collateral_record数据
     */
     @Test
     public void testSelectCollateralRecord() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(collateralRecordService.getRecord(id)));
    }

    /**
     * 测试更新collateral_record数据
     */
    @Test
    public void testUpdateCollateralRecord() {
        CollateralRecordDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, collateralRecordService.update(record)));
    }

    /**
     * 测试删除collateral_record数据
     */
     @Test
     public void testDeleteCollateralRecord() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, collateralRecordService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private CollateralRecordDTO newRecord() {
        CollateralRecordDTO record = new CollateralRecordDTO();
        record.setAccountId(76L);
        record.setMainAccountId(93L);
        record.setBusinessType("Dktl3wIb1KQjwrs0l5gCYmQz1CqostJHQMbX");
        record.setActionType("D");
        record.setAmount();
        record.setRequestAt(new Date());
        record.setExecutionStatus("zXPYz9Dz0wF7FE");
        record.setLastUpdatedAt(new Date());
        record.setCoinPositionId("AV");
        record.setAddress("OMns");
        record.setStakeStatus("gnlv15W9LYdGkYKVi1u24WTqgDK99yXO");
        record.setStakeCoin("KfVPRnZqofLByiF2CZ");
        record.setTransferCoin("6vdDvZ887ZmjN7RVY");
        return record;
    }
}