package com.you.shardingjdbc.service.impl;

import com.you.shardingjdbc.dao.mapper.UserInfoMapper;
import com.you.shardingjdbc.entity.dao.UserInfo;
import com.you.shardingjdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/21 16:04
 * @since <版本号>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void insert(UserInfo userInfo) {
         userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> seachPage(int startNo) {
        return null;
    }
}
