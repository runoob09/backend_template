package github.runoob09.common.aspect;

import github.runoob09.common.constant.SysUserConstant;
import github.runoob09.common.exception.BusinessException;
import github.runoob09.common.result.ResultEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 16:08
 */
@Aspect
@Component
public class RequireLoginAspect {
    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(github.runoob09.common.annotation.RequireLogin)")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw BusinessException.of(ResultEnum.SESSION_EXPIRED);
        }
        Object o = session.getAttribute(SysUserConstant.LOGIN_KEY);
        if (o == null) {
            throw BusinessException.of(ResultEnum.USER_NOT_LOGGED_IN);
        }
    }
}
