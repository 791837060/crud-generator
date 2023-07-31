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

import com.coinflex.api.vault.dto.CoinConvertRecordDTO;
import com.coinflex.api.vault.dto.CoinConvertRecordQueryDTO;

/**
 * coin_convert_record单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinConvertRecordTests {

    @Autowired
    private ICoinConvertRecordService coinConvertRecordService;

    /**
     * 测试分页查询coin_convert_record数据
     */
    @Test
    public void testSelectCoinConvertRecordList() {
        CoinConvertRecordQueryDTO query = new CoinConvertRecordQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(coinConvertRecordService.getRecordList(query)));
    }

    /**
     * 测试插入1条coin_convert_record数据
     */
    @Test
    public void testInsertCoinConvertRecord() {
        CoinConvertRecordDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, coinConvertRecordService.insert(record)));
    }

    /**
     * 测试插入多条coin_convert_record数据
     */
    @Test
    public void testInsertCoinConvertRecordList() {
        List<CoinConvertRecordDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, coinConvertRecordService.insertAll(recordList)));
    }

    /**
     * 测试查询coin_convert_record数据
     */
     @Test
     public void testSelectCoinConvertRecord() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(coinConvertRecordService.getRecord(id)));
    }

    /**
     * 测试更新coin_convert_record数据
     */
    @Test
    public void testUpdateCoinConvertRecord() {
        CoinConvertRecordDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, coinConvertRecordService.update(record)));
    }

    /**
     * 测试删除coin_convert_record数据
     */
     @Test
     public void testDeleteCoinConvertRecord() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, coinConvertRecordService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private CoinConvertRecordDTO newRecord() {
        CoinConvertRecordDTO record = new CoinConvertRecordDTO();
        record.setMainAccountId(42L);
        record.setQuantity();
        record.setFromCoin("k0qYoOTD51FFpSX");
        record.setToCoin("LGGRlEcykuqxpBguV4iuWROMOP");
        record.setBusinessType("vQj4Fx7uKI9XPwiw");
        record.setStatus("RpAocoR9GWCiYtjxqDlYXqXGO");
        record.setRequestTime(new Date());
        return record;
    }
}