package com.coinflex.api.mortgage.test.test;

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

import com.coinflex.api.mortgage.dto.BorrowHistoryDTO;
import com.coinflex.api.mortgage.dto.BorrowHistoryQueryDTO;

/**
 * borrow_history单元测试用例
 *
 * @author 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowHistoryTests {

    @Autowired
    private IBorrowHistoryService borrowHistoryService;

    /**
     * 测试分页查询borrow_history数据
     */
    @Test
    public void testSelectBorrowHistoryList() {
        BorrowHistoryQueryDTO query = new BorrowHistoryQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(borrowHistoryService.getRecordList(query)));
    }

    /**
     * 测试插入1条borrow_history数据
     */
    @Test
    public void testInsertBorrowHistory() {
        BorrowHistoryDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, borrowHistoryService.insert(record)));
    }

    /**
     * 测试插入多条borrow_history数据
     */
    @Test
    public void testInsertBorrowHistoryList() {
        List<BorrowHistoryDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, borrowHistoryService.insertAll(recordList)));
    }

    /**
     * 测试查询borrow_history数据
     */
     @Test
     public void testSelectBorrowHistory() {
        String id = "1";
        Assert.assertTrue(Objects.nonNull(borrowHistoryService.getRecord(id)));
    }

    /**
     * 测试更新borrow_history数据
     */
    @Test
    public void testUpdateBorrowHistory() {
        BorrowHistoryDTO record = newRecord();
        record.setId("1");
        Assert.assertTrue(Objects.equals(true, borrowHistoryService.update(record)));
    }

    /**
     * 测试删除borrow_history数据
     */
     @Test
     public void testDeleteBorrowHistory() {
        String id = "1";
        Assert.assertTrue(Objects.equals(true, borrowHistoryService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private BorrowHistoryDTO newRecord() {
        BorrowHistoryDTO record = new BorrowHistoryDTO();
        record.setAccountId(80L);
        record.setCollateral("GZ80XFBNz3PYfa4tGzkKfZsVANuGJgcLP");
        record.setQuantity();
        record.setAmount();
        record.setCreatedAt(new Date());
        record.setBusinessType("PVtGGN");
        record.setActionType("O9fPrCOzy1B7v6YFch5O");
        record.setExecutionStatus("3KmsGpdVXfe3fmaD7vDmnTREk5FHRxsmVQX9");
        record.setLastUpdatedAt(new Date());
        return record;
    }
}