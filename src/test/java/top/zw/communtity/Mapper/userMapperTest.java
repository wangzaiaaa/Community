package top.zw.communtity.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zw.communtity.mapper.UserMapper;
import top.zw.communtity.model.User;

@SpringBootTest

public class userMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testfindByToken(){
        User user = userMapper.findByToken("3567620e-8c6c-43fb-8ebd-72bc40d4ef7e");
        System.out.println(user);
    }

}
