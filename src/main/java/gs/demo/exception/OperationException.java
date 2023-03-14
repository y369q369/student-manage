package gs.demo.exception;

import gs.demo.response.ResponseEnum;
import lombok.Data;

/**
 * <p>操作异常：日志打印warn</p>
 *
 * @author gs
 * @since 2023/3/14 15:17
 */
@Data
public class OperationException extends RuntimeException {

    private ResponseEnum responseEnum;

    public OperationException(ResponseEnum responseEnum) {
        super ( responseEnum.getMessage() );
        this.responseEnum = responseEnum;
    }

}
