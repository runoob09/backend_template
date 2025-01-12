package github.runoob09.model.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import github.runoob09.common.constant.SysUserConstant;
import lombok.Data;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 11:37
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {
    @TableField("nick_name")
    private String nickName;
    @TableField("user_account")
    private String userAccount;
    @TableField("user_password")
    private String userPassword;
    @TableField("user_email")
    private String userEmail;
    @TableField("user_status")
    private SysUserConstant.Status userStatus;
}
