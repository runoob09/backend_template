package github.runoob09.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.runoob09.dao.SysUserMapper;
import github.runoob09.model.db.SysUser;
import github.runoob09.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 12:10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
