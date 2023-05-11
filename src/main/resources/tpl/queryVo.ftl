package ${table.pkgName};

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
<#if useSwagger == 1>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import ${basePkgName}.vo.${table.javaClassName}VO;

/**
 * ${table.comments}查询条件
 *
 * @author ${table.author!''}
 */<#if useSwagger == 1>
@ApiModel(value = "${table.comments} query condition", description = "${table.comments} query condition")</#if>
public class ${table.javaClassName}QueryVO extends ${table.javaClassName}VO {
<#include "./public/serialVersionUID.ftl"/>

<#if useSwagger == 1>
    @ApiModelProperty(value = "page number", dataType = "Integer", example = "1")</#if>
    @NotNull(message = "page number is empty", groups = {Default.class})
    @Min(value = 1, message = "Page number must be greater than or equal to {value}", groups = {Default.class})
    @Max(value = 2147483646, message = "Page number cannot be greater than {value}", groups = {Default.class})
    private Integer pageNo = 1;

<#if useSwagger == 1>
    @ApiModelProperty(value = "Paging Size", dataType = "Integer", example = "10")</#if>
    @NotNull(message = "page size is empty", groups = {Default.class})
    @Min(value = 1, message = "Paging size must be greater than or equal to {value}", groups = {Default.class})
    @Max(value = 2147483646, message = "Paging size cannot be greater than {value}", groups = {Default.class})
    private Integer pageSize = ${table.pageSize};

<#if useSwagger == 1>
    @ApiModelProperty(value = "sort field name", dataType = "String")</#if>
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "Invalid sort field name", groups = {Default.class})
    private String orderBy;

<#if useSwagger == 1>
    @ApiModelProperty(value = "Sort direction: asc or desc", dataType = "String", example = "desc")</#if>
    @Pattern(regexp = "(?i)asc|desc", message = "The sort direction must be asc or desc", groups = {Default.class})
    private String orderDirection = "desc";
<#list table.columns as column><#if column.enableLike == 1>

    @ApiModelProperty(value = "${column.columnComment!''}fuzzy match value", dataType = "String", example = "abc")
    private ${column.columnJavaType} ${column.columnCamelNameLower}Like;
</#if></#list>

<#include "./public/pageParams.ftl"/>

<#include "./public/orderParams.ftl"/>

<#list table.columns as column><#if column.enableLike == 1>

    public ${column.columnJavaType} get${column.columnCamelNameUpper}Like() {
        return this.${column.columnCamelNameLower}Like;
    }

    public void set${column.columnCamelNameUpper}Like(${column.columnJavaType} ${column.columnCamelNameLower}Like) {
        this.${column.columnCamelNameLower}Like = ${column.columnCamelNameLower}Like;
    }</#if></#list>
}