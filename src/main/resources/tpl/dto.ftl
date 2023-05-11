package ${table.pkgName};

import java.io.Serializable;
<#include "./public/toStringImport.ftl"/>
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
<#list table.imports as imp>
import ${imp};
</#list>

/**
 * ${table.comments}DTO对象
 *
 * @author ${table.author!''}
 */
public class ${table.javaClassName}DTO <#if baseEntityClass??>extends ${baseEntityClass}<#else>implements Serializable</#if> {
<#include "./public/serialVersionUID.ftl"/>

<#list table.columns as column>
    /**
     * ${column.columnComment!''}
     */<#if column.nullable == 0><#if column.isChar == 1>
    @NotBlank(message = "${column.columnComment!''}(${column.columnCamelNameLower}) is empty")<#else>
    @NotNull(message = "${column.columnComment!''}(${column.columnCamelNameLower}) is empty")</#if></#if><#if column.isChar == 1>
    @Length(max = ${column.columnLength}, message = "${column.columnComment!''}(${column.columnCamelNameLower}) cannot exceed {max} characters in length")</#if>
    private ${column.columnJavaType} ${column.columnCamelNameLower};

</#list>

<#include "./public/toString.ftl"/>

<#include "./public/getterAndSetter.ftl"/>
}