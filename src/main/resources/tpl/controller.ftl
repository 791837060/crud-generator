package ${table.pkgName};

import com.google.common.base.Preconditions;
import com.github.pagehelper.PageInfo;
<#include "./public/logger.ftl"/>
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
import ${basePkgName}.vo.${table.javaClassName}VO;
import ${basePkgName}.vo.${table.javaClassName}QueryVO;
import ${basePkgName}.dto.${table.javaClassName}DTO;
import ${basePkgName}.service.I${table.javaClassName}Service;
import ${basePkgName}.util.${table.javaClassName}Converter;
import ${basePkgName}.validator.InsertGroup;
import ${basePkgName}.validator.UpdateGroup;
<#if useSwagger == 1>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if resultClass??>import ${resultClass};</#if>
<#list table.columns as column><#if column.isPrimaryKey == 1><#assign pk = column></#if></#list>
<#if pk??>import io.swagger.annotations.ApiParam;</#if>

/**
 * ${table.comments}API接口
 *
 * @author ${table.author!''}
 */<#if useSwagger == 1>
@Api(value = "/${table.javaClassNameLower}", tags = {"${table.comments}API"})</#if>
@RequestMapping("/${table.javaClassNameLower}")
@RestController
public class ${table.javaClassName}Controller {
    private static final Logger logger = LoggerFactory.getLogger(${table.javaClassName}Controller.class);

    @Autowired
    private I${table.javaClassName}Service ${table.javaClassNameLower}Service;

    /**
     * 分页查询${table.comments}数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */<#if useSwagger == 1>
    @ApiOperation(value = "Paging query ${table.comments} data", httpMethod = "GET",tags = {"Paging query ${table.comments} data"})</#if>
    @GetMapping(value = "/getRecordList")
    public <#if resultClassName??>${resultClassName}<</#if>PageInfo<${table.javaClassName}VO><#if resultClassName??>></#if> getRecordList(@Validated({Default.class}) ${table.javaClassName}QueryVO query) {
        PageInfo<${table.javaClassName}DTO> pageInfo = ${table.javaClassNameLower}Service.getRecordList(${table.javaClassName}Converter.voToQueryDTO(query));
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassName}Converter.toVOPageInfo(pageInfo)<#if resultClassName??>)</#if>;
    }

    <#if pk??>
    /**
     * 根据主键查询${table.comments}数据
     *
     * @param ${pk.columnCamelNameLower}  待查询的${table.comments}记录${pk.columnComment}
     * @return ${table.comments}数据
     */
    @ApiOperation(value = "Query ${table.comments} data according to the primary key", httpMethod = "GET",tags = {"Query ${table.comments} data according to the primary key"})
    @GetMapping(value = "/getRecord")
    public <#if resultClassName??>${resultClassName}<</#if>${table.javaClassName}VO<#if resultClassName??>></#if> getRecord(@ApiParam(value = "${table.comments} records ${pk.columnComment} to be queried", type = "${pk.columnJavaType}", required = true, example = "1") @RequestParam("${pk.columnCamelNameLower}") ${pk.columnJavaType} ${pk.columnCamelNameLower}) {
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassName}Converter.dtoToVO(${table.javaClassNameLower}Service.get${table.javaClassName}By${pk.columnCamelNameUpper}(${pk.columnCamelNameLower}))<#if resultClassName??>)</#if>;
    }</#if>

    /**
     * 插入${table.comments}记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */<#if useSwagger == 1>
    @ApiOperation(value = "Insert ${table.comments} records", httpMethod = "POST",tags = {"Insert ${table.comments} records"})</#if>
    @PostMapping(value = "/insert")
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insert(@RequestBody @Validated({InsertGroup.class, Default.class}) ${table.javaClassName}VO vo) {
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassNameLower}Service.insert(${table.javaClassName}Converter.voToDTO(vo))<#if resultClassName??>)</#if>;
    }

    /**
     * 更新${table.comments}记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
    */<#if useSwagger == 1>
    @ApiOperation(value = "Update ${table.comments} records", httpMethod = "POST", tags = {"Update ${table.comments} records"})</#if>
    @PostMapping(value = "/update")
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> update(@RequestBody @Validated({UpdateGroup.class, Default.class}) ${table.javaClassName}VO vo) {
        Preconditions.checkArgument(<#if pk??>vo.get${pk.columnCamelNameUpper}() != null, "The ${table.comments} record ${pk.columnComment} to be updated is empty"</#if>);
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassNameLower}Service.update(${table.javaClassName}Converter.voToDTO(vo))<#if resultClassName??>)</#if>;
    }

    /**
     * 删除${table.comments}记录
     *
     * @param <#if pk??>${pk.columnCamelNameLower}  待删除的${table.comments}记录${pk.columnComment}</#if>
     * @return 是否成功
     */<#if useSwagger == 1>
    @ApiOperation(value = "Delete ${table.comments} records", httpMethod = "DELETE", tags = {"Delete ${table.comments} records"})</#if>
    @DeleteMapping(value = "/delete/{${pk.columnCamelNameLower}}")
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> delete(<#if pk??>@ApiParam(value = "${table.comments} records ${pk.columnComment} to be deleted", type = "${pk.columnJavaType}", required = true, example = "1") @PathVariable("${pk.columnCamelNameLower}") ${pk.columnJavaType} ${pk.columnCamelNameLower}</#if>) {
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassNameLower}Service.delete(${pk.columnCamelNameLower})<#if resultClassName??>)</#if>;
    }
}