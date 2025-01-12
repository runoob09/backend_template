package github.runoob09.common.result;

import lombok.Getter;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:17
 */
@Getter
public enum ResultEnum {

    // 成功结果
    SUCCESS(200, "操作成功"),

    // ===================== 客户端错误 =====================
    BAD_REQUEST(400, "错误的请求参数"),
    UNAUTHORIZED(401, "用户未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "不允许使用此方法"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "资源冲突"),
    GONE(410, "资源已删除"),
    PAYLOAD_TOO_LARGE(413, "请求体过大"),
    UNPROCESSABLE_ENTITY(422, "数据验证失败"),

    // ===================== 服务器错误 =====================
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "未实现该功能"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    VERSION_NOT_SUPPORTED(505, "版本不支持"),

    // ===================== 业务错误 =====================
    USER_EXISTS(6000, "用户已存在"),
    USER_NOT_FOUND(6001, "用户不存在"),
    PASSWORD_INCORRECT(6002, "密码错误"),
    SESSION_EXPIRED(6003, "会话已过期"),
    ACCOUNT_LOCKED(6004, "账户已锁定"),
    ACCOUNT_DISABLED(6005, "账户已禁用"),
    INSUFFICIENT_PRIVILEGES(6006, "权限不足"),
    INVALID_FORMAT(6007, "格式无效"),
    RESOURCE_CONFLICT(6008, "资源冲突"),
    INVALID_TOKEN(6009, "无效的令牌"),
    USER_NOT_LOGGED_IN(6010, "用户未登录"), // 新增：用户未登录错误码
    SESSION_INVALID(6011, "会话无效"), // 新增：会话无效错误码
    TOKEN_EXPIRED(6012, "令牌已过期"), // 新增：令牌过期错误码
    TOKEN_INVALID(6013, "令牌无效"), // 新增：令牌无效错误码
    PASSWORD_NOT_MATCH(6014,"密码不匹配"),
    // ===================== 其他 =====================
    UNKNOWN_ERROR(9999, "未知错误");


    private final int code;
    private final String message;

    // 构造函数
    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 获取结果码
    public int getCode() {
        return code;
    }

    // 获取结果信息
    public String getMessage() {
        return message;
    }

    // 根据结果码查找对应的结果信息
    public static String getMessageByCode(int code) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if (resultEnum.getCode() == code) {
                return resultEnum.getMessage();
            }
        }
        return UNKNOWN_ERROR.getMessage();  // 默认返回未知错误信息
    }
}
