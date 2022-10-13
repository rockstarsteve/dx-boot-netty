package com.dx.mybatisplus.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * Description: mybatis-plus代码生成器
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/13
 */
public class CodeAutoGenerator {

    /**
     * 代码快速生成
     */
    @Test
    void fastAutoGeneratorTest() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dx_chat?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
                        "root",
                        "root")
                .globalConfig(globalConfig -> {
                    globalConfig
                            // 设置作者
                            .author("rockstarsteven")
                            // 开启 swagger 模式
//                            .enableSwagger()
                            .dateType(DateType.ONLY_DATE)
                            .commentDate("yyyy-MM-dd")
                            // 指定输出目录
                            .outputDir("D://mybatisGeneratorCode");
                })
                .packageConfig(packageConfig -> {
                    packageConfig
                            // 设置父包名
                            .parent("com.dx.chat")
                            // 设置父包模块名
                            .moduleName("user")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://mybatisGeneratorCode"));
                })
                .strategyConfig(strategyConfig -> {
                    strategyConfig
                            // 设置需要生成的表名
                            .addInclude("user")
                            // 设置过滤表前缀
                            .addTablePrefix("", "")
                            /*
                             * Entity策略配置
                             */
                            .entityBuilder()
                            // 设置开启lombok
                            .enableLombok()
                            // 开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            /*
                             * Controller策略配置
                             */
                            .controllerBuilder()
                            // 开启生成@RestController 控制器
                            .enableRestStyle()
                            /*
                             * Mapper策略配置
                             */
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                    ;

                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
