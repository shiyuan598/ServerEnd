package Gsafety.GIS.websocket;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
//这里的MybatisAutoConfiguration.class对应你的数据库框架
//@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

}
