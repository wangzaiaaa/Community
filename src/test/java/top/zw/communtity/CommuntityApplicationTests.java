package top.zw.communtity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zw.communtity.mapper.QuestionMapper;
import top.zw.communtity.mapper.UserMapper;

@SpringBootTest
class CommuntityApplicationTests {

    @Autowired
    private QuestionMapper mapper;
    @Test
    void contextLoads() {
        System.out.println(mapper.count());
    }

}
