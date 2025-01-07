package github.runoob09.common.result;

import lombok.Getter;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:18
 */
@Getter
public class BasicResult<T> {

    // 响应码
    private int code;
    // 响应消息
    private String message;
    // 响应数据
    private T data;

    // 私有构造函数，确保只能通过success或fail方法创建
    private BasicResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 私有构造函数，用于包含返回数据的情况
    private BasicResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // ===================== 静态方法 =====================

    // 成功返回，不带数据
    public static <T> BasicResult<T> success() {
        return new BasicResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(),null);
    }

    // 成功返回，带数据
    public static <T> BasicResult<T> success(T data) {
        return new BasicResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    // 失败返回
    public static BasicResult<Void> fail(ResultEnum resultEnum) {
        return new BasicResult<>(resultEnum.getCode(), resultEnum.getMessage());
    }

    // 失败返回，带数据
    public static <T> BasicResult<T> fail(ResultEnum resultEnum, T data) {
        return new BasicResult<>(resultEnum.getCode(), resultEnum.getMessage(), data);
    }


    // ===================== 重写toString()方法 =====================
    @Override
    public String toString() {
        return "BasicResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

