package com.coinflex.api.mortgage.controller;

import com.google.common.base.Preconditions;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import com.coinflex.api.mortgage.vo.MarketVO;
import com.coinflex.api.mortgage.vo.MarketQueryVO;
import com.coinflex.api.mortgage.dto.MarketDTO;
import com.coinflex.api.mortgage.service.IMarketService;
import com.coinflex.api.mortgage.util.MarketConverter;
import com.coinflex.api.mortgage.validator.InsertGroup;
import com.coinflex.api.mortgage.validator.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

/**
 * marketAPI接口
 *
 * @author 
 */
@Api(value = "/market", tags = {"marketAPI"})
@RequestMapping("/market")
@RestController
public class MarketController {
    private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

    @Autowired
    private IMarketService marketService;

    /**
     * 分页查询market数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @ApiOperation(value = "分页查询market数据", httpMethod = "GET",tags = {"分页查询market数据"})
    @GetMapping(value = "/getRecordList")
    public PageInfo<MarketVO> getRecordList(@Validated({Default.class}) MarketQueryVO query) {
        PageInfo<MarketDTO> pageInfo = marketService.getRecordList(MarketConverter.voToQueryDTO(query));
        return MarketConverter.toVOPageInfo(pageInfo);
    }

    /**
     * 根据主键查询market数据
     *
     * @param id  待查询的market记录id
     * @return market数据
     */
    @ApiOperation(value = "根据主键查询market数据", httpMethod = "GET",tags = {"根据主键查询market数据"})
    @GetMapping(value = "/getRecord")
    public MarketVO getRecord(@ApiParam(value = "待查询的market记录id", type = "Long", required = true, example = "1") @RequestParam("id") Long id) {
        return MarketConverter.dtoToVO(marketService.getMarketById(id));
    }

    /**
     * 插入market记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @ApiOperation(value = "插入market记录", httpMethod = "POST",tags = {"插入market记录"})
    @PostMapping(value = "/insert")
    public Boolean insert(@RequestBody @Validated({InsertGroup.class, Default.class}) MarketVO vo) {
        return marketService.insert(MarketConverter.voToDTO(vo));
    }

    /**
     * 更新market记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
    */
    @ApiOperation(value = "更新market记录", httpMethod = "POST", tags = {"更新market记录"})
    @PostMapping(value = "/update")
    public Boolean update(@RequestBody @Validated({UpdateGroup.class, Default.class}) MarketVO vo) {
        Preconditions.checkArgument(vo.getId() != null, "待更新的market记录id为空");
        return marketService.update(MarketConverter.voToDTO(vo));
    }

    /**
     * 删除market记录
     *
     * @param id  待删除的market记录id
     * @return 是否成功
     */
    @ApiOperation(value = "删除market记录", httpMethod = "DELETE", tags = {"删除market记录"})
    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@ApiParam(value = "待删除的market记录id", type = "Long", required = true, example = "1") @PathVariable("id") Long id) {
        return marketService.delete(id);
    }
}