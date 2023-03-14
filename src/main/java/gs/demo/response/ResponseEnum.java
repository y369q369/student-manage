package gs.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 公共响应体的状态码枚举类
 * @Author gs
 * @Date 2021-10-28 16:24
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {

    /**
     * 成功返回的状态码
     */
    SUCCESS(0, "success"),
    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(500, "服务器异常"),
    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(10001, "资源不存在"),

    CODE_NOT_EQUAL(1, "验证码错误"),
    USER_NOT_EXIST(1, "用户不存在"),
    PASSWORD_ERROR(1, "密码错误"),

    ;


    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;

}
