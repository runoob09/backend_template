package github.runoob09.service;

import com.baomidou.mybatisplus.extension.service.IService;
import github.runoob09.model.db.SysUser;
import github.runoob09.model.dto.UserLoginRequest;
import github.runoob09.model.dto.UserRegisterRequest;
import github.runoob09.model.vo.SysUserVO;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:10
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 用户登陆方法
     *
     * @param request 用户登陆请求
     * @return 用户信息
     */
    SysUserVO login(UserLoginRequest request);

    /**
     * 用户注册方法
     *
     * @param request 用户注册请求
     * @return 用户信息
     */
    SysUserVO register(UserRegisterRequest request);
}
