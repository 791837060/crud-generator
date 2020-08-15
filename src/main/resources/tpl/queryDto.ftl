package ${table.pkgName};

<#list table.imports as imp>
import ${imp};
</#list>
import ${basePkgName}.dto.${table.javaClassName}DTO;

/**
 * ${table.comments}查询条件
 *
 * @author ${table.author!''}
 */
public class ${table.javaClassName}QueryDTO extends ${table.javaClassName}DTO {
<#include "./public/serialVersionUID.ftl"/>

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 分页大小
     */
    private Integer pageSize = ${table.pageSize};

    /**
     * 排序属性名称
     */
    private String orderBy;

    /**
     * 排序方向: asc或desc
     */
    private String orderDirection = "desc";
<#list table.columns as column><#if column.enableLike == 1>

    /**
    * ${column.columnComment!''}模糊匹配值
    */
    private ${column.columnJavaType} ${column.columnCamelNameLower}Like;
</#if>
<#if column.enableRange == 1>

    /**
     * ${column.columnComment!''}范围开始
     */
    private ${column.columnJavaType} ${column.columnCamelNameLower}Min;

    /**
     * ${column.columnComment!''}范围结束
     */
    private ${column.columnJavaType} ${column.columnCamelNameLower}Max;
</#if></#list>

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
<#list table.columns as column><#if column.enableLike == 1>

    public ${column.columnJavaType} get${column.columnCamelNameUpper}Like() {
        return this.${column.columnCamelNameLower}Like;
    }

    public void set${column.columnCamelNameUpper}Like(${column.columnJavaType} ${column.columnCamelNameLower}Like) {
        this.${column.columnCamelNameLower}Like = ${column.columnCamelNameLower}Like;
    }</#if>
    <#if column.enableRange == 1>
    public ${column.columnJavaType} get${column.columnCamelNameUpper}Min() {
        return this.${column.columnCamelNameLower}Min;
    }

    public void set${column.columnCamelNameUpper}Min(${column.columnJavaType} ${column.columnCamelNameLower}Min) {
        this.${column.columnCamelNameLower}Min = ${column.columnCamelNameLower}Min;
    }

    public ${column.columnJavaType} get${column.columnCamelNameUpper}Max() {
        return this.${column.columnCamelNameLower}Max;
    }

    public void set${column.columnCamelNameUpper}Max(${column.columnJavaType} ${column.columnCamelNameLower}Max) {
        this.${column.columnCamelNameLower}Max = ${column.columnCamelNameLower}Max;
    }
    </#if></#list>
}