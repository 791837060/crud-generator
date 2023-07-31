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

import com.coinflex.api.vault.dto.InterestSummaryDTO;
import com.coinflex.api.vault.dto.InterestSummaryQueryDTO;

/**
 * interest_summary单元测试用例
 *
 * @author jack
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestSummaryTests {

    @Autowired
    private IInterestSummaryService interestSummaryService;

    /**
     * 测试分页查询interest_summary数据
     */
    @Test
    public void testSelectInterestSummaryList() {
        InterestSummaryQueryDTO query = new InterestSummaryQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(interestSummaryService.getRecordList(query)));
    }

    /**
     * 测试插入1条interest_summary数据
     */
    @Test
    public void testInsertInterestSummary() {
        InterestSummaryDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, interestSummaryService.insert(record)));
    }

    /**
     * 测试插入多条interest_summary数据
     */
    @Test
    public void testInsertInterestSummaryList() {
        List<InterestSummaryDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, interestSummaryService.insertAll(recordList)));
    }

    /**
     * 测试查询interest_summary数据
     */
     @Test
     public void testSelectInterestSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(interestSummaryService.getRecord(id)));
    }

    /**
     * 测试更新interest_summary数据
     */
    @Test
    public void testUpdateInterestSummary() {
        InterestSummaryDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, interestSummaryService.update(record)));
    }

    /**
     * 测试删除interest_summary数据
     */
     @Test
     public void testDeleteInterestSummary() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, interestSummaryService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private InterestSummaryDTO newRecord() {
        InterestSummaryDTO record = new InterestSummaryDTO();
        record.setInterestTotalAmount();
        record.setSnapshotTime("La47dHQuhNdjUBG");
        record.setCoin("xN8xR89gt95");
        record.setInterestRate();
        record.setInterestRateStatus("eebx2zb8cnkHzSIcBncfeGtCSes54cXsJ");
        record.setDividendTime(new Date());
        record.setDividendStatus("ACfA2VN0M3e1i");
        record.setBizId("Ul78gHje3iXvUPINwsaYUiFxw");
        record.setLastUpdatedAt(new Date());
        return record;
    }
}