package github.runoob09.model.vo;

import lombok.Data;

/**
 * @author zhang-jiahao
 * @date 2025/1/8 16:04
 */
@Data
public class SysUserVO {
    private String userAccount;
    private String nickName;
    private String gender;
    private String phone;
    private String email;
}