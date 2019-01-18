package net.luculent.automatioin.laks.services.userlogin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.luculent.automatioin.laks.platform.controller.BaseController;
import net.luculent.automatioin.laks.platform.domain.Result;
import net.luculent.automatioin.laks.services.userlogin.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户登录
 * @Author: caomingtao
 * @Date Create In 09:56 2018/10/19
 * @Modified By:
 */
@RestController
@RequestMapping(value = "")
@Api(value = "用户登录", description = "用户登录")
public class UserLoginController extends BaseController {

    @Resource
    private UserLoginService userLoginService;

    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    /**
     * @param username 用户名
     * @param password 用户密码
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "login", httpMethod = "POST", notes = "暂无")
    public Result addActivitySuggest(@RequestParam String username,
                                     @RequestParam String password) throws Exception {

        if (logger.isInfoEnabled()) {

            logger.info("RequestParam === >> " +
                    "username = " + username + ",password = " + password);
        }

        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("userName", username);

        List<Map<String, Object>> verifyUserName = userLoginService.login(condition);

        // 判断用户名是否存在
        if (verifyUserName != null && !verifyUserName.isEmpty()) {

            condition.put("passWord", password);
            List<Map<String, Object>> verifyPassWord = userLoginService.login(condition);

            // 判断密码是否正确
            if (verifyPassWord != null && !verifyPassWord.isEmpty()) {

                // 验证是否临时用户
                String isTemporary = verifyPassWord.get(0).get("isTemporary").toString();

                if ("Y".equals(isTemporary)) {

                    Object expiryTime = verifyPassWord.get(0).get("expiryTime");

                    // 判断是否有设置过期时间
                    if (expiryTime != null) {

                        Timestamp timestamp = (Timestamp) expiryTime;
                        Long longTime = timestamp.getTime();

                        Date now = new Date();

                        // 如果过期时间小于现在时间,则登录失败
                        if (longTime < now.getTime()) {

                            return this.error("您为临时用户,账号有效已过期!");
                        }
                    }
                }
                return this.success("登录成功!");

            } else {
                return this.error("用户密码不正确!");
            }

        } else {
            return this.error("用户不存在!");
        }
    }
}
