package net.luculent.automatioin.laks.platform.util;

import net.luculent.automatioin.laks.platform.domain.Result;
import net.luculent.automatioin.laks.platform.enums.SysExpEnum;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 10:06 2018/10/19
 * @Modified By:
 */
public class ResultUtil {

    /**
     * 返回成功(含参)
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus("success");
        result.setData(object);
        return result;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 返回失败(含参)
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setStatus("filure");
        result.setData(msg);
        return result;
    }

    /**
     * 返回失败(含参)
     *
     * @param sysExpEnum
     * @return
     */
    public static Result error(SysExpEnum sysExpEnum) {
        Result result = new Result();
        result.setStatus("filure");
        result.setData(sysExpEnum.getMessage());
        return result;
    }

    /**
     * 返回失败(含参)
     *
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setStatus("filure");
        result.setData(msg);
        return result;
    }
}
