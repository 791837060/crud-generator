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
import com.coinflex.api.mortgage.vo.BorrowHistoryVO;
import com.coinflex.api.mortgage.vo.BorrowHistoryQueryVO;
import com.coinflex.api.mortgage.dto.BorrowHistoryDTO;
import com.coinflex.api.mortgage.service.IBorrowHistoryService;
import com.coinflex.api.mortgage.util.BorrowHistoryConverter;
import com.coinflex.api.mortgage.validator.InsertGroup;
import com.coinflex.api.mortgage.validator.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

/**
 * borrow_historyAPI接口
 *
 * @author 
 */
@Api(value = "/borrowHistory", tags = {"borrow_historyAPI"})
@RequestMapping("/borrowHistory")
@RestController
public class BorrowHistoryController {
    private static final Logger logger = LoggerFactory.getLogger(BorrowHistoryController.class);

    @Autowired
    private IBorrowHistoryService borrowHistoryService;

    /**
     * 分页查询borrow_history数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @ApiOperation(value = "分页查询borrow_history数据", httpMethod = "GET",tags = {"分页查询borrow_history数据"})
    @GetMapping(value = "/getRecordList")
    public PageInfo<BorrowHistoryVO> getRecordList(@Validated({Default.class}) BorrowHistoryQueryVO query) {
        PageInfo<BorrowHistoryDTO> pageInfo = borrowHistoryService.getRecordList(BorrowHistoryConverter.voToQueryDTO(query));
        return BorrowHistoryConverter.toVOPageInfo(pageInfo);
    }

    /**
     * 根据主键查询borrow_history数据
     *
     * @param id  待查询的borrow_history记录id
     * @return borrow_history数据
     */
    @ApiOperation(value = "根据主键查询borrow_history数据", httpMethod = "GET",tags = {"根据主键查询borrow_history数据"})
    @GetMapping(value = "/getRecord")
    public BorrowHistoryVO getRecord(@ApiParam(value = "待查询的borrow_history记录id", type = "String", required = true, example = "1") @RequestParam("id") String id) {
        return BorrowHistoryConverter.dtoToVO(borrowHistoryService.getBorrowHistoryById(id));
    }

    /**
     * 插入borrow_history记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @ApiOperation(value = "插入borrow_history记录", httpMethod = "POST",tags = {"插入borrow_history记录"})
    @PostMapping(value = "/insert")
    public Boolean insert(@RequestBody @Validated({InsertGroup.class, Default.class}) BorrowHistoryVO vo) {
        return borrowHistoryService.insert(BorrowHistoryConverter.voToDTO(vo));
    }

    /**
     * 更新borrow_history记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
    */
    @ApiOperation(value = "更新borrow_history记录", httpMethod = "POST", tags = {"更新borrow_history记录"})
    @PostMapping(value = "/update")
    public Boolean update(@RequestBody @Validated({UpdateGroup.class, Default.class}) BorrowHistoryVO vo) {
        Preconditions.checkArgument(vo.getId() != null, "待更新的borrow_history记录id为空");
        return borrowHistoryService.update(BorrowHistoryConverter.voToDTO(vo));
    }

    /**
     * 删除borrow_history记录
     *
     * @param id  待删除的borrow_history记录id
     * @return 是否成功
     */
    @ApiOperation(value = "删除borrow_history记录", httpMethod = "DELETE", tags = {"删除borrow_history记录"})
    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@ApiParam(value = "待删除的borrow_history记录id", type = "String", required = true, example = "1") @PathVariable("id") String id) {
        return borrowHistoryService.delete(id);
    }
}