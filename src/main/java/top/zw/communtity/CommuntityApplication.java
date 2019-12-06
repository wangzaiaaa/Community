package top.zw.communtity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(basePackages = "top.zw.communtity.mapper")
public class CommuntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommuntityApplication.class, args);
    }

}
