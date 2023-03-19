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

    private Integer code = 1;

    private String message;

    public OperationException(ResponseEnum responseEnum) {
        super ( responseEnum.getMessage() );
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public OperationException(String message) {
        super ( message );
        this.message = message;
    }

}
