package com.iosoft2021.generator;

import java.util.Arrays;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("iosoft2021");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setDateType(DateType.TIME_PACK);
        gc.setIdType(IdType.AUTO);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(
                "jdbc:mysql://192.168.56.100:3306/mbpd?useUnicode=true&characterEncoding=utf-8");
        dsc.setSchemaName("mbpd");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName("moudule1");
        pc.setParent("com.iosoft2021");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");

        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");

        strategy.setTableFillList(Arrays.asList(new TableFill("create_time", FieldFill.INSERT),
                new TableFill("update_time", FieldFill.INSERT_UPDATE)));
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        //        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}