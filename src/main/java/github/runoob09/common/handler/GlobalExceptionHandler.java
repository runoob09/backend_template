package github.runoob09.common.handler;

import github.runoob09.common.exception.BusinessException;
import github.runoob09.common.result.BasicResult;
import github.runoob09.common.result.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhang-jiahao
 * @date 2025/1/8 12:54
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 处理业务异常
    @ExceptionHandler(BusinessException.class)
    public BasicResult<Void> businessExceptionHandler(BusinessException e) {
        ResultEnum resultEnum = e.getResultEnum();
        return BasicResult.fail(resultEnum);
    }
}
