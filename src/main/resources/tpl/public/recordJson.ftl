{<#list table.columns as column>"${column.columnCamelNameLower}":<#if column.isChar == 1>"${randomString(column.charLength)}"<#elseif column.isDateTime == 1>${randomTimestamp()}<#else >${randomNumber()}</#if><#if column?has_next>,</#if></#list>}