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

import com.coinflex.api.vault.dto.RedemptionQuotaSummaryDTO;
import com.coinflex.api.vault.dto.RedemptionQuotaSummaryQueryDTO;

/**
 * redemption_quota_summary单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedemptionQuotaSummaryTests {

    @Autowired
    private IRedemptionQuotaSummaryService redemptionQuotaSummaryService;

    /**
     * 测试分页查询redemption_quota_summary数据
     */
    @Test
    public void testSelectRedemptionQuotaSummaryList() {
        RedemptionQuotaSummaryQueryDTO query = new RedemptionQuotaSummaryQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(redemptionQuotaSummaryService.getRecordList(query)));
    }

    /**
     * 测试插入1条redemption_quota_summary数据
     */
    @Test
    public void testInsertRedemptionQuotaSummary() {
        RedemptionQuotaSummaryDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, redemptionQuotaSummaryService.insert(record)));
    }

    /**
     * 测试插入多条redemption_quota_summary数据
     */
    @Test
    public void testInsertRedemptionQuotaSummaryList() {
        List<RedemptionQuotaSummaryDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, redemptionQuotaSummaryService.insertAll(recordList)));
    }

    /**
     * 测试查询redemption_quota_summary数据
     */
     @Test
     public void testSelectRedemptionQuotaSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(redemptionQuotaSummaryService.getRecord(id)));
    }

    /**
     * 测试更新redemption_quota_summary数据
     */
    @Test
    public void testUpdateRedemptionQuotaSummary() {
        RedemptionQuotaSummaryDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, redemptionQuotaSummaryService.update(record)));
    }

    /**
     * 测试删除redemption_quota_summary数据
     */
     @Test
     public void testDeleteRedemptionQuotaSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, redemptionQuotaSummaryService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private RedemptionQuotaSummaryDTO newRecord() {
        RedemptionQuotaSummaryDTO record = new RedemptionQuotaSummaryDTO();
        record.setMainAccountId(7L);
        record.setMaxRedemptionAmount();
        record.setRedemptionAmount();
        record.setAvailableTime(new Date());
        return record;
    }
}