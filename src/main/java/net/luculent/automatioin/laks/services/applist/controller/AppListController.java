package net.luculent.automatioin.laks.services.applist.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.luculent.automatioin.laks.platform.controller.BaseController;
import net.luculent.automatioin.laks.platform.domain.Result;
import net.luculent.automatioin.laks.services.applist.service.AppListService;
import net.luculent.automatioin.laks.services.userlogin.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 查询list
 * @Author: caomingtao
 * @Date Create In 09:58 2018/10/19
 * @Modified By:
 */
@RestController
@RequestMapping(value = "")
@Api(value = "查询applist", description = "查询applist")
public class AppListController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AppListController.class);

    @Resource
    private UserLoginService userLoginService;

    @Resource
    private AppListService appListService;

    /**
     * 查询list
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/applist")
    @ApiOperation(value = "applist", httpMethod = "POST", notes = "暂无")
    public Result queryAppList(
            @RequestParam(value = "username", required = false) String username)
            throws Exception {

        if (logger.isInfoEnabled()) {
            logger.info("RequestParam === >> " + " username = " + username);
        }

        List<Map<String, Object>> detail = null;

        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("1", 1);
        //如果userId 存在
        if (username != null && !username.isEmpty() && !"".equals(username)) {

            //查询用户信息
            Map<String, Object> userMap =
                    userLoginService.queryUserByLgName(username);

            String isTemporary = userMap.get("isTemporary").toString();

            //判断是否临时用户
            if ("Y".equals(isTemporary)) {

                condition.put("accessControl", "Y");
                detail = appListService.queryAppList(condition);

            } else {

                detail = appListService.queryAppList(condition);

            }
        } else {

            //如果userId不存在,返回所有的list(暂时)
            detail = appListService.queryAppList(condition);
        }

        return this.success(detail);
    }
}
