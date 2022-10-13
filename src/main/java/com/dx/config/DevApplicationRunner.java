package com.dx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Description: 开发环境启动后的内容
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/14
 */
@Slf4j
@Component
@Profile("dev")
public class DevApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        log.info("================================== http://localhost:8088/doc.html ================================================");
    }
}
