package com.you.shardingjdbc.controller;

import com.you.shardingjdbc.entity.dao.UserInfo;
import com.you.shardingjdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/21 14:41
 * @since <版本号>
 */
@RestController
public class ShardingController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/sharding")
    public String sharding() {
        UserInfo u = new UserInfo();
        u.setU_id(1234);
        u.setU_name("lily");
        userInfoService.insert(u);

        return "ok";
    }
}
