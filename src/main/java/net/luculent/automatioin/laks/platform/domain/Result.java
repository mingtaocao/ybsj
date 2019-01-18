package net.luculent.automatioin.laks.platform.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 10:06 2018/10/19
 * @Modified By:
 */

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回状态
     */
    private String status;

    /**
     * 具体内容：泛型
     */
    private T data;
}
