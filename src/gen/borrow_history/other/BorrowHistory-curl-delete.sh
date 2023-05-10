curl -v -X DELETE -d http://localhost:8080/borrowHistory/delete/FreeMarker template error (DEBUG mode; use RETHROW in production!):
The following has evaluated to null or missing:
==> column  [in template "tpl/curl-delete.ftl" at line 2, column 114]

----
Tip: If the failing expression is known to legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: ${randomString(column.charLength)}  [in template "tpl/curl-delete.ftl" at line 2, column 99]
----

Java stack trace (for programmers):
----
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:134)
	at freemarker.core.UnexpectedTypeException.newDesciptionBuilder(UnexpectedTypeException.java:85)
	at freemarker.core.UnexpectedTypeException.<init>(UnexpectedTypeException.java:48)
	at freemarker.core.NonHashException.<init>(NonHashException.java:49)
	at freemarker.core.Dot._eval(Dot.java:48)
	at freemarker.core.Expression.eval(Expression.java:83)
	at freemarker.core.ListLiteral.getModelList(ListLiteral.java:93)
	at freemarker.core.MethodCall._eval(MethodCall.java:63)
	at freemarker.core.Expression.eval(Expression.java:83)
	at freemarker.core.DollarVariable.calculateInterpolatedStringOrMarkup(DollarVariable.java:100)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:63)
	at freemarker.core.Environment.visit(Environment.java:330)
	at freemarker.core.Environment.visit(Environment.java:336)
	at freemarker.core.Environment.visit(Environment.java:336)
	at freemarker.core.Environment.process(Environment.java:309)
	at freemarker.template.Template.process(Template.java:384)
	at com.foobar.generator.generator.TableCodeGenerator.renderFile(TableCodeGenerator.java:642)
	at com.foobar.generator.generator.TableCodeGenerator.render(TableCodeGenerator.java:623)
	at com.foobar.generator.generator.TableCodeGenerator.generateTableCodeFiles(TableCodeGenerator.java:585)
	at com.foobar.generator.generator.TableCodeGenerator.lambda$null$0(TableCodeGenerator.java:278)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
