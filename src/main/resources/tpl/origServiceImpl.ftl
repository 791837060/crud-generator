package ${table.pkgName};

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;
import com.github.pagehelper.PageHelper;
<#include "./public/logger.ftl"/>

<#include "./public/serviceCommonImports.ftl"/>
<#if resultClass??>import ${resultClass};</#if>
<#list table.columns as column><#if column.isPrimaryKey == 1><#assign pk = column></#if></#list>
<#if table.logicDeleteColumn??><#list table.columns as column><#if table.logicDeleteColumn == column.columnName><#assign logicDeleteColumn = column></#if></#list></#if>

/**
 * ${table.comments}服务接口实现
 *
 * @author ${table.author!''}
 */
<#if useDubboServiceAnnotation = 1><#include "./public/dubboServiceAnnotation.ftl"/>
<#else>@Service
</#if>
public class ${table.javaClassName}ServiceImpl implements I${table.javaClassName}Service {
    <#include "./public/serviceHeader.ftl"/>

    /**
     * 分页查询
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public <#if resultClassName??>${resultClassName}<</#if>PageInfo<${table.javaClassName}DTO><#if resultClassName??>></#if> getRecordList(${table.javaClassName}QueryDTO query) {
        <#include "./public/checkQueryArguments.ftl"/>

        Map<String, Object> queryMap = new HashMap<>();
        if (!${table.javaClassName}Converter.isFieldExists(query.getOrderBy())) {
            //默认使用主键(唯一索引字段)排序
    <#if pk??>        query.setOrderBy("${pk.columnName}");</#if>
        } else {
            query.setOrderBy(${table.javaClassName}Converter.getOrderColumn(query.getOrderBy()));
        }
        query.setOrderDirection(${table.javaClassName}Converter.getOrderDirection(query.getOrderDirection()));
        ${table.javaClassName}Converter.valuesToMap(query, queryMap, Sets.newHashSet("pageNo", "pageSize"));
<#if logicDeleteColumn??>        queryMap.put("${logicDeleteColumn.columnCamelNameLower}", <#if logicDeleteColumn.isNumber == 1>0<#else>"0"</#if>);</#if>
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageInfo<${table.javaClassName}DO> pageInfo = new PageInfo<>(${table.javaClassNameLower}Mapper.getRecordList(queryMap));
        return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassName}Converter.toDTOPageInfo(pageInfo)<#if resultClassName??>)</#if>;
    }

    <#if pk??>
    /**
     * 根据主键查询
     *
     * @param ${pk.columnCamelNameLower}    主键值
     * @return 查询结果
     */
    @Override
    public <#if resultClassName??>${resultClassName}<</#if>${table.javaClassName}DTO<#if resultClassName??>></#if> getRecord(${pk.columnJavaType} ${pk.columnCamelNameLower}) {
        Preconditions.checkArgument(<#if pk.isChar == 1>StringUtils.isNotBlank(${pk.columnCamelNameLower})<#else>${pk.columnCamelNameLower} != null</#if>, "${pk.columnCamelNameLower} is empty!");
        ${table.javaClassName}DO record = ${table.javaClassNameLower}Mapper.getRecordBy${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
        return record != null ? <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassName}Converter.domainToDTO(record)<#if resultClassName??>)</#if> : <#if resultClassName??>new ${resultClassName}(</#if>null<#if resultClassName??>)</#if>;
    }</#if>

    /**
     * 插入记录
     *
     * @param record    待插入的数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insert(${table.javaClassName}DTO record) {
        ${table.javaClassName}DO domain = ${table.javaClassName}Converter.dtoToDomain(record);
        checkInsertObject(domain);
        int inserted = ${table.javaClassNameLower}Mapper.insert(domain);
        if (inserted != 0) {
            logger.info("${table.name} data inserted successfully!");
            return <#if resultClassName??>new ${resultClassName}(</#if>true<#if resultClassName??>)</#if>;
        } else {
            logger.error("${table.name} data insertion failed!");
            return <#if resultClassName??>new ${resultClassName}(</#if>false<#if resultClassName??>)</#if>;
        }
    }

    /**
     * 批量插入记录
     *
     * @param recordList    待插入的数据列表
     * @return 是否成功
     */
     @Override
     @Transactional(rollbackFor = Exception.class)
     public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insertAll(List<${table.javaClassName}DTO> recordList) {
         Preconditions.checkArgument(!CollectionUtils.isEmpty(recordList), "The data to be inserted is empty");
         int success = 0;
         //说明: 因为Oracle不允许超过1000个参数，所以此处逐条插入
         for (${table.javaClassName}DTO record : recordList) {
             if (record == null) {
                 continue;
             }
             ${table.javaClassName}DO domain = ${table.javaClassName}Converter.dtoToDomain(record);
             checkInsertObject(domain);
             if (${table.javaClassNameLower}Mapper.insert(domain) == 0) {
                 throw new RuntimeException("Failed to insert ${table.comments} data!");
             }
             success++;
         }
         logger.info("A total of {} pieces of ${table.name} data are inserted this time", success);
         return <#if resultClassName??>new ${resultClassName}(</#if>success > 0<#if resultClassName??>)</#if>;
     }

    /**
     * 更新记录
     *
     * @param record    待更新的数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> update(${table.javaClassName}DTO record) {
        Preconditions.checkArgument(record != null, "The data to be updated is empty");
        <#if pk??>Preconditions.checkArgument(record.get${pk.columnCamelNameUpper}() != null, "The data to be updated ${pk.columnCamelNameLower} is empty");</#if>
        int updated = ${table.javaClassNameLower}Mapper.update(${table.javaClassName}Converter.dtoToDomain(record));
        if (updated != 0) {
            logger.info("${table.name} data updated successfully! ${pk.columnCamelNameLower}={}", record.get${pk.columnCamelNameUpper}());
            return <#if resultClassName??>new ${resultClassName}(</#if>true<#if resultClassName??>)</#if>;
        } else {
            logger.error("${table.name} data update failed! ${pk.columnCamelNameLower}={}", record.get${pk.columnCamelNameUpper}());
            return <#if resultClassName??>new ${resultClassName}(</#if>false<#if resultClassName??>)</#if>;
        }
    }

<#if pk??>
    /**
     * 删除记录
     *
     * @param ${pk.columnCamelNameLower}    待删除的数据主键值
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> delete(${pk.columnJavaType} ${pk.columnCamelNameLower}) {
        Preconditions.checkArgument(<#if pk.isChar == 1>StringUtils.isNotBlank(${pk.columnCamelNameLower})<#else>${pk.columnCamelNameLower} != null</#if>, "${pk.columnCamelNameLower} is empty!");
<#if logicDeleteColumn??>        ${table.javaClassName}DO cond = new ${table.javaClassName}DO();
        cond.set${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
        cond.set${logicDeleteColumn.columnCamelNameUpper}(<#if logicDeleteColumn.isNumber == 1>1<#else>"1"</#if>);
        int rowCount = ${table.javaClassNameLower}Mapper.update(cond);<#else>        int rowCount = ${table.javaClassNameLower}Mapper.delete(${pk.columnCamelNameLower});</#if>
        if (rowCount != 0) {
            logger.info("${table.name} data <#if logicDeleteColumn??>logic</#if> deleted successfully! ${pk.columnCamelNameLower}={}", ${pk.columnCamelNameLower});
            return <#if resultClassName??>new ${resultClassName}(</#if>true<#if resultClassName??>)</#if>;
        } else {
            logger.error("${table.name} data <#if logicDeleteColumn??>logic</#if> delete failed! ${pk.columnCamelNameLower}={}", ${pk.columnCamelNameLower});
            return <#if resultClassName??>new ${resultClassName}(</#if>false<#if resultClassName??>)</#if>;
        }
    }

    /**
     * 批量删除记录
     *
     * @param ${pk.columnCamelNameLower}List    待删除的数据主键值列表
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> deleteAll(List<${pk.columnJavaType}> ${pk.columnCamelNameLower}List) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(${pk.columnCamelNameLower}List), "The list of ${table.comments} data ${pk.columnComment} to be deleted is empty");
        int success = 0;
        ${table.javaClassName}DO cond = new ${table.javaClassName}DO();
        for (${pk.columnJavaType} ${pk.columnCamelNameLower} : ${pk.columnCamelNameLower}List) {
            if (<#if pk.isChar == 1>StringUtils.isBlank(${pk.columnCamelNameLower})<#else>${pk.columnCamelNameLower} == null</#if>) {
                continue;
            }
    <#if logicDeleteColumn??>
            cond.set${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
            cond.set${logicDeleteColumn.columnCamelNameUpper}(<#if logicDeleteColumn.isNumber == 1>1<#else>"1"</#if>);
            int rowCount = ${table.javaClassNameLower}Mapper.update(cond);<#else>            int rowCount = ${table.javaClassNameLower}Mapper.delete(${pk.columnCamelNameLower});</#if>
            if (rowCount == 0) {
                logger.error("<#if logicDeleteColumn??>logic</#if> failed to delete ${table.name} data! ${pk.columnCamelNameLower}={}", ${pk.columnCamelNameLower});
                throw new RuntimeException("Failed to delete ${table.comments} data!");
            }
            success++;
        }
        logger.info("A total of <#if logicDeleteColumn??>logic</#if> deleted {} ${table.name} table data this time! ${pk.columnCamelNameLower}List={}", success, ${pk.columnCamelNameLower}List);
        return <#if resultClassName??>new ${resultClassName}(</#if>success > 0<#if resultClassName??>)</#if>;
    }</#if>

<#include "./public/insertObjectCheck.ftl"/>
}