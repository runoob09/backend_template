package github.runoob09.controller;

import github.runoob09.common.result.BasicResult;
import github.runoob09.model.dto.UserLoginRequest;
import github.runoob09.model.dto.UserRegisterRequest;
import github.runoob09.model.vo.SysUserVO;
import github.runoob09.service.SysUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:14
 */
@RestController("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("login")
    public BasicResult<SysUserVO> login(@Valid @NotNull @RequestBody UserLoginRequest userLoginRequest) {
        return BasicResult.success(sysUserService.login(userLoginRequest));
    }

    @PostMapping("register")
    public BasicResult<SysUserVO> register(@Valid @NotNull @RequestBody UserRegisterRequest userRegisterRequest) {
        return BasicResult.success(sysUserService.register(userRegisterRequest));
    }
}
