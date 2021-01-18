package ${table.pkgName};

import com.github.pagehelper.PageInfo;
import ${basePkgName}.vo.${table.javaClassName}VO;
import ${basePkgName}.vo.${table.javaClassName}QueryVO;
import ${basePkgName}.feign.${table.javaClassName}ClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
<#if resultClass??>import ${resultClass};</#if>
<#list table.columns as column><#if column.isPrimaryKey == 1><#assign pk = column></#if></#list>

/**
 * ${table.comments}-FeignClient
 *
 * @author ${table.author!''}
 */
@FeignClient(value = "${table.kebabCaseName}-service", fallback = ${table.javaClassName}ClientFallback.class)
public interface I${table.javaClassName}Client {

    /**
     * 分页查询${table.comments}数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @RequestMapping(value = "/get${table.javaClassName}List", method = RequestMethod.GET)
    <#if resultClassName??>${resultClassName}<</#if>PageInfo<${table.javaClassName}VO><#if resultClassName??>></#if> getRecordList(@SpringQueryMap ${table.javaClassName}QueryVO query);

    <#if pk??>
    /**
     * 根据主键查询${table.comments}数据
     *
     * @param ${pk.columnCamelNameLower}  待查询的${table.comments}记录${pk.columnComment}
     * @return ${table.comments}数据
     */
    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    <#if resultClassName??>${resultClassName}<</#if>${table.javaClassName}VO<#if resultClassName??>></#if> getRecord(@RequestParam("${pk.columnCamelNameLower}") ${pk.columnJavaType} ${pk.columnCamelNameLower});</#if>

    /**
     * 插入${table.comments}记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> insert(${table.javaClassName}VO vo);

    /**
     * 更新${table.comments}记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> update(${table.javaClassName}VO vo);

    /**
     * 删除${table.comments}记录
     *
     * @param <#if pk??>${pk.columnCamelNameLower}  待删除的${table.comments}记录${pk.columnComment}</#if>
     * @return 是否成功
     */
    @RequestMapping(value = "/delete/{${pk.columnCamelNameLower}}", method = RequestMethod.DELETE)
    <#if resultClassName??>${resultClassName}<</#if>Boolean<#if resultClassName??>></#if> delete(<#if pk??>@PathVariable("${pk.columnCamelNameLower}") ${pk.columnJavaType} ${pk.columnCamelNameLower}</#if>);
}