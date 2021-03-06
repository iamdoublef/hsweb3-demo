package org.hswebframework.web.demo;

import org.hswebframework.web.authorization.basic.configuration.EnableAopAuthorize;
import org.hswebframework.web.authorization.basic.web.SessionIdUserTokenParser;
import org.hswebframework.web.authorization.basic.web.UserTokenParser;
import org.hswebframework.web.dao.Dao;
import org.hswebframework.web.loggin.aop.EnableAccessLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhouhao
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableCaching //开启缓存
@EnableAccessLogger //开启访问日志
@ComponentScan("org.hswebframework.web.demo")
@MapperScan(value = "org.hswebframework.web.demo", markerInterface = Dao.class) //扫描mybatis dao
@EnableAopAuthorize
public class Application {

//    @Bean
//    public UserTokenParser userTokenParser() {
//        //如果引入了jwt。默认会关闭sessionId,使用此方式继续使用sessionId
//        return new SessionIdUserTokenParser();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

