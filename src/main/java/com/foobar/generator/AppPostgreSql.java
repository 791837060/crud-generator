package com.foobar.generator;

import com.foobar.generator.constant.DatabaseType;
import com.foobar.generator.generator.TableCodeGenerator;
import com.foobar.generator.info.JdbcInfo;
import com.foobar.generator.info.RunParam;
import com.foobar.generator.info.TableContext;

/**
 * 入口类
 */
public class AppPostgreSql {

    public static void main(String[] args) throws Exception {
        JdbcInfo param = new JdbcInfo();

        //指定数据库类型
        param.setDbType(DatabaseType.POSTGRESQL);

        //数据库主机名或IP
        param.setHost("172.21.31.3"); //kiwi
        //数据库端口号
        param.setPort("26000"); //kiwi
        //数据库实例名(oracle填写实例名，mysql或sqlserver留空)
        param.setServiceName("coinflex_dev_kiwi"); //kiwi
        //数据库用户名
        param.setUsername("coinflex");

        //数据库主机名或IP
        //param.setHost("172.21.31.251"); //lemon
        //数据库端口号
        //param.setPort("26257"); //lemon
        //数据库实例名(oracle填写实例名，mysql或sqlserver留空)
        //param.setServiceName("coinflex_dev_lemon"); //lemon
        //数据库用户名
        //param.setUsername("root");

        //schema名称(oracle填写Schema名称，mysql或sqlserver则填写数据库名称)
        param.setSchema("public");

        //数据库用户密码
        param.setPassword(null);


        TableCodeGenerator generator = new TableCodeGenerator(param);

        RunParam rp = new RunParam();
        //java基础包名(留空则默认使用com.example.myapp)
        rp.setBasePkgName("com.coinflex.api.account");
        rp.setBasePkgName("com.coinflex.api.mortgage");
        rp.setBasePkgName("com.coinflex.api.accountvalue");
        rp.setBasePkgName("com.coinflex.api.vault");

        //输出目录的绝对路径(留空则生成到当前用户主目录)



        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/borrow_snapshots");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/lending_pool");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/all");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/t_partner");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/borrow_history");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/borrow_summary");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/lending_summary");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/lending_history");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/lending_snapshots");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/ltv_setting");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/ousd_interest_setting");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/vault_record");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/vault_summary");


        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/position_snapshots");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/redemption_quota_summary");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/coin_convert_record");

        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/vault_snapshots");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/interest_summary");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/vault_balance_snapshots");
        rp.setOutputPath("/Users/zenghuikang/crud-generator/src/gen/vault_pool");


        ///Users/zenghuikang/openx/opnx-api/service-mortgage




        //表名
        TableContext table = TableContext.withName("borrow_history");
         table = TableContext.withName("lending_pool");
         table = TableContext.withName("borrow_snapshots");
         table = TableContext.withName("t_partner");
         table = TableContext.withName("borrow_history");
        table = TableContext.withName("borrow_summary");
        table = TableContext.withName("lending_summary");
        table = TableContext.withName("lending_history");
        table = TableContext.withName("lending_snapshots");
        table = TableContext.withName("ltv_setting");
        table = TableContext.withName("ousd_interest_setting");
        table = TableContext.withName("vault_record");
        table = TableContext.withName("vault_summary");


        table = TableContext.withName("position_snapshots");
        table = TableContext.withName("redemption_quota_summary");
        table = TableContext.withName("coin_convert_record");

        table = TableContext.withName("vault_snapshots");
        table = TableContext.withName("interest_summary");
        table = TableContext.withName("vault_balance_snapshots");
        table = TableContext.withName("vault_pool");



        //需去掉的表名前缀(留空不去掉任何前缀)
        table.setTableNamePrefixToRemove(null);

        //手动指定主键字段名(不区分大小写); 如果程序无法自动检测到主键字段，则在此参数指定；适用于无主键且无唯一索引的表
        //table.setPrimaryKeyColumn("code");

        //如果该表有乐观锁，可在此设置其字段名，默认值为 version (不区分大小写)
        //table.setVersionColumn("total");
        //table.setLogicDeleteColumn("DEL_FLAG");

        rp.addTable(table);

        //如果需要去掉的表名前缀均相同，则可以全局配置它，不再需要在 TableContext 中逐个配置前缀
        //generator.setGlobalTableNamePrefixToRemove("t_");

        //默认使用 Spring 的 @Service 注解。如果需要使用 Dubbo 的@Service注解，请设置该值为true
        //generator.setUseDubboService(true);

        //是否生成所有代码(默认true; 当数据表字段发生变化后需要重新生成代码时，可设置为false，只生成实体类、XML等核心代码)
        //generator.setGenerateAll(false);

        //generator.setClassNameGenerator(t -> org.apache.commons.text.CaseUtils.toCamelCase(t, true, '_') + "Entity");

        //生成
        generator.run(rp);
    }
}
