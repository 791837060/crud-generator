package ${table.pkgName};

import java.util.List;

import com.github.pagehelper.PageInfo;
import ${basePkgName}.dto.${table.javaClassName}DTO;
import ${basePkgName}.dto.${table.javaClassName}QueryDTO;
<#if resultClass??>import ${resultClass};</#if>
<#list table.columns as column><#if column.isPrimaryKey == 1><#assign pk = column></#if></#list>

/**
 * ${table.comments}服务接口
 *
 * @author ${table.author!''}
 */
public interface I${table.javaClassName}Service {

    /**
     * 分页查询
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    <#if resultClassName??>${resultClassName}<</#if>PageInfo<${table.javaClassName}DTO><#if resultClassName??>></#if> getRecordList(${table.javaClassName}QueryDTO query);

    <#if pk??>
    /**
     * 根据主键查询
     *
     * @param ${pk.columnCamelNameLower}    主键值
     * @return 查询结果
     */
    <#if resultClassName??>${resultClassName}<</#if>${table.javaClassName}DTO<#if resultClassName??>></#if> getRecord(${pk.columnJavaType} ${pk.columnCamelNameLower});</#if>

    /**
     * 插入记录
     *
     * @param record    待插入的数据
     * @return 是否成功
     */
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insert(${table.javaClassName}DTO record);

    /**
     * 批量插入记录
     *
     * @param recordList    待插入的数据列表
     * @return 是否成功
     */
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insertAll(List<${table.javaClassName}DTO> recordList);

    /**
     * 更新记录
     *
     * @param record    待更新的数据
     * @return 是否成功
     */
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> update(${table.javaClassName}DTO record);

<#if pk??>
    /**
     * 删除记录
     *
     * @param ${pk.columnCamelNameLower}    待删除的数据主键值
     * @return 是否成功
     */
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> delete(${pk.columnJavaType} ${pk.columnCamelNameLower});

    /**
     * 批量删除记录
     *
     * @param ${pk.columnCamelNameLower}List    待删除的数据主键值列表
     * @return 是否成功
     */
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> deleteAll(List<${pk.columnJavaType}> ${pk.columnCamelNameLower}List);</#if>
}