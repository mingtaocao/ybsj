package net.luculent.automatioin.laks.services.userlogin.service.impl;

import net.luculent.automatioin.laks.services.userlogin.dao.UserLoginDao;
import net.luculent.automatioin.laks.services.userlogin.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 10:33 2018/10/19
 * @Modified By:
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginDao userLoginDao;

    @Override
    public List<Map<String, Object>> login(Map<String, Object> condition) {
        return userLoginDao.login(condition);
    }

    @Override
    public Map<String, Object> queryUserByLgName(String username) {
        return userLoginDao.queryUserByLgName(username);
    }
}
