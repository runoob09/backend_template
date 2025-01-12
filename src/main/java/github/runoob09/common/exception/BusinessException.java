package github.runoob09.common.exception;

import github.runoob09.common.result.ResultEnum;
import lombok.Getter;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 16:58
 */
@Getter
public class BusinessException extends RuntimeException {
    // 错误信息及状态码
    private final Integer code;
    private final String message;
    // 状态枚举
    private final ResultEnum resultEnum;

    private BusinessException(ResultEnum resultEnum) {
        code = resultEnum.getCode();
        message = resultEnum.getMessage();
        this.resultEnum = resultEnum;
    }

    public static BusinessException of(ResultEnum result) {
        return new BusinessException(result);
    }
}
