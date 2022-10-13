package com.dx;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 启动类
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/7
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.dx.**.mapper")
public class DxBootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxBootStudyApplication.class, args);
    }

}
