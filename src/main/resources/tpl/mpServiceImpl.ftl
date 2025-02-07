package ${table.pkgName};

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.common.collect.Sets;
<#include "./public/logger.ftl"/>

<#include "./public/serviceCommonImports.ftl"/>
<#if resultClass??>import ${resultClass};</#if>
<#list table.columns as column><#if column.isPrimaryKey == 1><#assign pk = column></#if></#list>
<#if table.versionColumn??><#list table.columns as column><#if table.versionColumn == column.columnName><#assign versionColumn = column></#if></#list></#if>
<#if table.logicDeleteColumn??><#list table.columns as column><#if table.logicDeleteColumn == column.columnName><#assign logicDeleteColumn = column></#if></#list></#if>

/**
 * ${table.comments}服务接口实现
 * 适用于MybatisPlus
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

        QueryWrapper<${table.javaClassName}DO> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<${table.javaClassName}DO> lambdaQueryWrapper = wrapper.lambda();
        <#list table.columns as column>
        if (query.get${column.columnCamelNameUpper}() != null<#if column.isChar == 1> && StringUtils.isNotBlank(query.get${column.columnCamelNameUpper}())</#if>) {
            lambdaQueryWrapper.eq(${table.javaClassName}DO::get${column.columnCamelNameUpper}, <#if column.isChar == 1>StringUtils.trim(</#if>query.get${column.columnCamelNameUpper}()<#if column.isChar == 1>)</#if>);
        }
        <#if column.enableLike == 1>
        if (query.get${column.columnCamelNameUpper}Like() != null<#if column.isChar == 1> && StringUtils.isNotBlank(query.get${column.columnCamelNameUpper}Like())</#if>) {
            lambdaQueryWrapper.like(${table.javaClassName}DO::get${column.columnCamelNameUpper}, "%" + StringUtils.trim(query.get${column.columnCamelNameUpper}Like()) + "%");
        }
        </#if>
        <#if column.enableRange == 1>
        if (query.get${column.columnCamelNameUpper}Min() != null) {
            lambdaQueryWrapper.ge(${table.javaClassName}DO::get${column.columnCamelNameUpper}, query.get${column.columnCamelNameUpper}Min());
        }
        if (query.get${column.columnCamelNameUpper}Max() != null) {
            lambdaQueryWrapper.le(${table.javaClassName}DO::get${column.columnCamelNameUpper}, query.get${column.columnCamelNameUpper}Max());
        }
        </#if>
        <#if column.enableIn == 1>
        if (!CollectionUtils.isEmpty(query.get${column.columnCamelNameUpper}In())) {
            lambdaQueryWrapper.in(${table.javaClassName}DO::get${column.columnCamelNameUpper}, query.get${column.columnCamelNameUpper}In());
        }
        </#if>
        <#if column.enableNotIn == 1>
        if (!CollectionUtils.isEmpty(query.get${column.columnCamelNameUpper}NotIn())) {
           lambdaQueryWrapper.notIn(${table.javaClassName}DO::get${column.columnCamelNameUpper}, query.get${column.columnCamelNameUpper}NotIn());
        }
        </#if>
        </#list>
<#if logicDeleteColumn??>        lambdaQueryWrapper.eq("${logicDeleteColumn.columnCamelNameLower}", <#if logicDeleteColumn.isNumber == 1>0<#else>"0"</#if>);</#if>
        if (!${table.javaClassName}Converter.isFieldExists(query.getOrderBy())) {
            //默认使用主键(唯一索引字段)排序
        <#if pk??>    query.setOrderBy("${pk.columnCamelNameLower}");</#if>
        }
        if (${table.javaClassName}Converter.ASC.equalsIgnoreCase(query.getOrderDirection())) {
            wrapper.orderByAsc(query.getOrderBy());
        } else {
            wrapper.orderByDesc(query.getOrderBy());
        }
        Page<${table.javaClassName}DO> page = new Page<>(query.getPageNo(), query.getPageSize());
        IPage<${table.javaClassName}DO> p = ${table.javaClassNameLower}Mapper.selectPage(page, wrapper);
        if (p == null) {
            return null;
        }
        PageInfo<${table.javaClassName}DTO> b = new PageInfo<>();
        b.setTotal((int) p.getTotal());
        b.setPageNum((int) p.getCurrent());
        b.setPageSize((int) p.getSize());
        b.setPages((int) p.getPages());
        if (!CollectionUtils.isEmpty(p.getRecords())) {
            List<${table.javaClassName}DTO> list = new ArrayList();
            p.getRecords().forEach(e -> {
               list.add(${table.javaClassName}Converter.domainToDTO(e));
            });
            b.setList(list);
        }
        return <#if resultClassName??>new ${resultClassName}(</#if>b<#if resultClassName??>)</#if>;
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
        ${table.javaClassName}DO cond = new ${table.javaClassName}DO();
        cond.set${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
        ${table.javaClassName}DO obj = ${table.javaClassNameLower}Mapper.selectById(cond);
        if (obj != null<#if logicDeleteColumn??> && Objects.equals(<#if logicDeleteColumn.isNumber == 1>0,<#else>"0",</#if> obj.get${logicDeleteColumn.columnCamelNameUpper}())</#if>) {
            return <#if resultClassName??>new ${resultClassName}(</#if>${table.javaClassName}Converter.domainToDTO(obj)<#if resultClassName??>)</#if>;
        } else {
            return <#if resultClassName??>new ${resultClassName}(</#if>null<#if resultClassName??>)</#if>;
        }
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
        Preconditions.checkArgument(record != null, "The data to be inserted is empty"); <#if versionColumn??>
        record.set${versionColumn.columnCamelNameUpper}(1L);</#if>
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
         for (${table.javaClassName}DTO record : recordList) {
             if (record == null) {
                continue;
             }
            <#if versionColumn??>
             record.set${versionColumn.columnCamelNameUpper}(1L);</#if>
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
        ${table.javaClassName}DO cond = ${table.javaClassName}Converter.dtoToDomain(record);
        int updated = ${table.javaClassNameLower}Mapper.updateById(cond);
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
        ${table.javaClassName}DO cond = new ${table.javaClassName}DO();
        cond.set${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
<#if logicDeleteColumn??>        cond.set${logicDeleteColumn.columnCamelNameUpper}(<#if logicDeleteColumn.isNumber == 1>1<#else>"1"</#if>);
        int rowCount = ${table.javaClassNameLower}Mapper.updateById(cond);<#else>
        int rowCount = ${table.javaClassNameLower}Mapper.deleteById(cond);</#if>
        if(rowCount != 0) {
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
            cond.set${pk.columnCamelNameUpper}(${pk.columnCamelNameLower});
    <#if logicDeleteColumn??>        cond.set${logicDeleteColumn.columnCamelNameUpper}(<#if logicDeleteColumn.isNumber == 1>1<#else>"1"</#if>);
            int rowCount = ${table.javaClassNameLower}Mapper.updateById(cond);<#else>
            int rowCount = ${table.javaClassNameLower}Mapper.deleteById(cond);</#if>
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