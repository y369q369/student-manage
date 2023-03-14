package gs.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author gs
 * @Date 2021-10-28 16:19
 * @Description 公共响应体
 */
@Data
@AllArgsConstructor
public class ResponseResult<T> {

    /**
     * 返回的状态码
     */
    private Integer code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    public ResponseResult(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResponseEnum.SUCCESS, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseEnum.SUCCESS, data);
    }

    public static <T> ResponseResult<T> fail(ResponseEnum responseEnum) {
        return new ResponseResult<>(responseEnum, null);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<>(1, message, null);
    }

}
