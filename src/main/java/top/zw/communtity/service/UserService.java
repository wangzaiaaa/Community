package top.zw.communtity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zw.communtity.mapper.UserMapper;
import top.zw.communtity.model.User;
import top.zw.communtity.model.UserExample;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> dbUser = userMapper.selectByExample(userExample);
        if (0 == dbUser.size()){
            //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);

        }else{
            User user1 = dbUser.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andIdEqualTo(user1.getId());
            userMapper.updateByExampleSelective(updateUser,new UserExample());

            //更新

        }
    }
}
