package github.runoob09.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRegisterRequest {
    @NotEmpty(message = "账号不能为空")
    private String userAccount;
    @NotEmpty(message = "密码不能为空")
    private String userPassword;
    @NotEmpty(message = "确认密码不能为空")
    private String checkPassword;
}
