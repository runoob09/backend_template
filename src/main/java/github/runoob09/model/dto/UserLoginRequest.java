package github.runoob09.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author zhang-jiahao
 * @date 2025/1/8 14:12
 */
@Data
public class UserLoginRequest {

    @NotEmpty(message = "用户名不能为空")
    private String userAccount;
    @NotEmpty(message = "用户密码不能为空")
    private String userPassword;

}
