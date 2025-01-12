package github.runoob09.mapper;

import github.runoob09.model.db.SysUser;
import github.runoob09.model.dto.UserRegisterRequest;
import github.runoob09.model.vo.SysUserVO;
import org.mapstruct.Mapper;

/**
 * @author zhang-jiahao
 * @date 2025/1/8 16:03
 */
@Mapper
public interface UserMapper {
    /**
     * 将SysUser转换为SysUserVO
     * @param sysUser 用户实体
     * @return 具有安全信息的用户实体
     */
    SysUserVO sysUserToSysUserVO(SysUser sysUser);

    /**
     * 将SysUserVO转换为SysUser
     * @param request 注册请求
     * @return 用户实体
     */
    SysUser registerToSysUser(UserRegisterRequest request);
}
