package com.zr;

import com.zr.domain.User;
import com.zr.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasyexcelDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testBatchSave(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("关羽");
        user1.setPassword("guanyu");

        User user2 = new User();
        user2.setId(2);
        user2.setName("张飞");
        user2.setPassword("zhangfei");

        List<User> userList  = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        userMapper.batchInsert(userList);
    }

    @Test
    public void tesrSelectAll(){
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
