package gs.demo.exception;

import gs.demo.response.ResponseEnum;
import lombok.Data;

/**
 * <p>通用异常：日志打印error</p>
 *
 * @author gs
 * @since 2023/3/14 15:17
 */
@Data
public class CommonException extends RuntimeException {

    private ResponseEnum responseEnum;

    public CommonException(ResponseEnum responseEnum) {
        super ( responseEnum.getMessage() );
        this.responseEnum = responseEnum;
    }

}
