package net.luculent.automatioin.laks.platform.controller;

import net.luculent.automatioin.laks.platform.domain.Result;
import net.luculent.automatioin.laks.platform.enums.SysExpEnum;
import net.luculent.automatioin.laks.platform.util.ResultUtil;

import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 10:03 2018/10/19
 * @Modified By:
 */
public class BaseController {

    /**
     * 返回成功(含参)
     *
     * @param obj
     * @return
     */
    public Result success(Object obj) {
        return ResultUtil.success(obj);
    }

    /**
     * 返回成功
     *
     * @return
     */
    public Result success() {
        return ResultUtil.success();
    }

    /**
     * 返回信息
     *
     * @param code
     * @param msg
     * @return
     */
    public Result message(int code, String msg) {
        return ResultUtil.error(code, msg);
    }

    /**
     * 返回信息
     *
     * @param sysExpEnum
     * @return
     */
    public Result message(SysExpEnum sysExpEnum) {
        return ResultUtil.error(sysExpEnum);
    }

    /**
     * 返回失败
     *
     * @return
     */
    public Result error() {
        return ResultUtil.error(SysExpEnum.UNKNOW_ERROR);
    }

    /**
     * 创建新增数据
     *
     * @return
     */
    public Map<String, Object> createData() {
        return null;
    }

    /**
     * 返回失败
     *
     * @return
     */
    public Result error(String msg) {
        return ResultUtil.error(msg);
    }
}
