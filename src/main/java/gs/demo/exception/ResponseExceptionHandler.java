package gs.demo.exception;

import gs.demo.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ResponseExceptionHandler {

    @ExceptionHandler(value = OperationException.class)
    public ResponseResult handlerOperationException(OperationException ex) {
        log.warn("【操作异常】", ex);
        return ResponseResult.fail(ex.getMessage());
    }

    @ExceptionHandler(value = CommonException.class)
    public ResponseResult handlerCommonException(CommonException ex) {
        log.error("【通用异常】", ex);
        return ResponseResult.fail(ex.getResponseEnum());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseResult handlerException(Exception ex) {
        log.error("【全局异常】", ex);
        return ResponseResult.fail(ex.getMessage());
    }

}
