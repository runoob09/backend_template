package github.runoob09.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 16:35
 */
public class SysUserConstant {
    public static final String LOGIN_KEY = "login_flag";


    /**
     * 用户状态
     */
    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE(0,"正常"),
        BANNED(1,"封禁");
        private final Integer code;
        private final String value;
    }

    /**
     * 用户性别
     */
    @Getter
    @AllArgsConstructor
    public enum Gender {
        MALE(0,"男性"),
        BANNED(1,"女性");
        private final Integer code;
        private final String value;
    }

}
