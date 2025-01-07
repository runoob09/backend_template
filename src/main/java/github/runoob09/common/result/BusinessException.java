package github.runoob09.common.result;

import lombok.AllArgsConstructor;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 16:58
 */
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private Integer code;
    private String message;
    public static BusinessException of(ResultEnum result) {
        return new BusinessException(result.getCode(),result.getMessage());
    }
}
