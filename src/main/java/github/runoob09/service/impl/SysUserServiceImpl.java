package github.runoob09.service.impl;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.runoob09.common.constant.SysUserConstant;
import github.runoob09.common.exception.BusinessException;
import github.runoob09.common.result.ResultEnum;
import github.runoob09.config.AESConfig;
import github.runoob09.dao.SysUserMapper;
import github.runoob09.mapper.UserMapper;
import github.runoob09.model.db.SysUser;
import github.runoob09.model.dto.UserLoginRequest;
import github.runoob09.model.dto.UserRegisterRequest;
import github.runoob09.model.vo.SysUserVO;
import github.runoob09.service.SysUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AESConfig aesConfig;

    @Override
    public SysUserVO login(@Valid @NotNull UserLoginRequest request) {
        // 对请求中的密码进行加密
        String userPassword = request.getUserPassword();
        byte[] encryptBytes = SecureUtil.aes(aesConfig.getKey().getBytes()).encrypt(userPassword);
        String encryptPassword = HexUtil.encodeHexStr(encryptBytes);
        // 从数据库中查找用户
        SysUser one = this.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserAccount, request.getUserAccount()));
        if (one == null) {
            throw BusinessException.of(ResultEnum.USER_NOT_FOUND);
        }
        if (!one.getUserPassword().equals(encryptPassword)) {
            throw BusinessException.of(ResultEnum.PASSWORD_INCORRECT);
        }
        return userMapper.sysUserToSysUserVO(one);
    }

    @Override
    public SysUserVO register(@Valid @NotNull UserRegisterRequest request) {
        // 判断两次密码是否一致
        if (!request.getUserPassword().equals(request.getCheckPassword())) {
            throw BusinessException.of(ResultEnum.PASSWORD_NOT_MATCH);
        }
        // 查询该账号是否已被注册
        SysUser one = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserAccount, request.getUserAccount()));
        if (one != null) {
            throw BusinessException.of(ResultEnum.USER_EXISTS);
        }
        // 创建用户
        SysUser sysUser = userMapper.registerToSysUser(request);
        // 加密密码
        String userPassword = sysUser.getUserPassword();
        byte[] encryptBytes = SecureUtil.aes(aesConfig.getKey().getBytes()).encrypt(userPassword);
        String encryptPassword = HexUtil.encodeHexStr(encryptBytes);
        sysUser.setUserPassword(encryptPassword);
        sysUser.setUserStatus(SysUserConstant.Status.ACTIVE);
        // 保存用户
        this.save(sysUser);
        // 去除敏感信息
        return userMapper.sysUserToSysUserVO(sysUser);
    }
}
