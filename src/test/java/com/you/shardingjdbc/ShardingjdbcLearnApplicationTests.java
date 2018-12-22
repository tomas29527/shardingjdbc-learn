package com.you.shardingjdbc;

import com.you.shardingjdbc.entity.dao.UserInfo;
import com.you.shardingjdbc.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ShardingjdbcLearnApplicationTests {
    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void contextLoads() {
        UserInfo u =new UserInfo();
        u.setU_id(1237);
        u.setU_name("lily");
        userInfoService.insert(u);
    }

}

