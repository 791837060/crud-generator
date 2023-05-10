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

import com.coinflex.api.mortgage.dto.MarketDTO;
import com.coinflex.api.mortgage.dto.MarketQueryDTO;

/**
 * market单元测试用例
 *
 * @author 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketTests {

    @Autowired
    private IMarketService marketService;

    /**
     * 测试分页查询market数据
     */
    @Test
    public void testSelectMarketList() {
        MarketQueryDTO query = new MarketQueryDTO();
        query.setPageNo(1);
        query.setPageSize(10);
        Assert.assertTrue(Objects.nonNull(marketService.getRecordList(query)));
    }

    /**
     * 测试插入1条market数据
     */
    @Test
    public void testInsertMarket() {
        MarketDTO record = newRecord();
        Assert.assertTrue(Objects.equals(true, marketService.insert(record)));
    }

    /**
     * 测试插入多条market数据
     */
    @Test
    public void testInsertMarketList() {
        List<MarketDTO> recordList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            recordList.add(newRecord());
        }
        Assert.assertTrue(Objects.equals(true, marketService.insertAll(recordList)));
    }

    /**
     * 测试查询market数据
     */
     @Test
     public void testSelectMarket() {
        Long id = 1L;
        Assert.assertTrue(Objects.nonNull(marketService.getRecord(id)));
    }

    /**
     * 测试更新market数据
     */
    @Test
    public void testUpdateMarket() {
        MarketDTO record = newRecord();
        record.setId(1L);
        Assert.assertTrue(Objects.equals(true, marketService.update(record)));
    }

    /**
     * 测试删除market数据
     */
     @Test
     public void testDeleteMarket() {
        Long id = 1L;
        Assert.assertTrue(Objects.equals(true, marketService.delete(id)));
    }

    /**
     * 构造新测试数据
     *
     * @return 测试数据
     */
    private MarketDTO newRecord() {
        MarketDTO record = new MarketDTO();
        record.setMarketId(53L);
        record.setMarketCode("wJRjby3e8g9");
        record.setName("8PZz2W0fDSDsMTQuNuDlCUrkldTfaJwMJ7k6WGyG1q3auPl8T6iYa3d2");
        record.setMarketType("f3");
        record.setSpreadType("n5");
        record.setBaseId(48L);
        record.setBaseInst("ZObJA6nIeP6ehjjv");
        record.setCounterId(87L);
        record.setCounterInst("0owCcTYHojoY");
        record.setCollateralType("uyde");
        record.setCycleType("I");
        record.setMarginCurrency("L");
        record.setContractValCurrency("ikxoJOC6J");
        record.setReferencePair("PwtqOGVrwdxyxdQkyzOew2WoQpW2");
        record.setMarketGroup("iyWq");
        record.setLinkedMarket("KfUPaWfe2bCaBFvQ1JPtRM7gmHSS0");
        record.setRiskOrderbookA("FLch84fL");
        record.setRiskOrderbookB("XhMBN6");
        record.setTickSize();
        record.setQtyIncrement();
        record.setPricingSource("PhdKRCXvBWZTC5rB9oB73Y");
        record.setUpperPriceType("fcTb966C");
        record.setUpperPriceBound();
        record.setLowerPriceType("RZHcxY");
        record.setLowerPriceBound();
        record.setPriceBound();
        record.setPriceBoundType("Qt7O6zLn4");
        record.setMaxLeverage();
        record.setStatus("1ulRA");
        record.setActive();
        record.setListingDate(new Date());
        record.setDaysListing();
        record.setEndDate(new Date());
        record.setRefInstrumentId(43L);
        record.setCreated(new Date());
        record.setCreator(52L);
        record.setLastUpdated(new Date());
        record.setLastUpdator(31L);
        record.setMarketPrice();
        record.setTag();
        record.setDescription("p7QvOM4p7ALIFrtIxdbpUVFJkM");
        record.setDelistingDate(new Date());
        record.setIsDelisting();
        record.setZone(17);
        record.setFeeCode("D3fdB4qInhSFMcdmBE6uaYuJpS81Y");
        record.setExclusive();
        record.setIndexPrice();
        record.setMakerFee(84L);
        return record;
    }
}