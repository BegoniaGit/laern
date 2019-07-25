package site.yanyan.learn.controller.sys;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yanyan.kit.Stamp;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.dao.sys.SysPermissionDao;
import site.yanyan.learn.dao.sys.SysRoleDao;
import site.yanyan.learn.dao.sys.SysUserDao;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.sys.SysPermission;
import site.yanyan.learn.pojo.sys.SysRole;
import site.yanyan.learn.pojo.sys.SysUser;
import site.yanyan.learn.utils.SerializeUtils;
import site.yanyan.learn.vo.sys.LoginUserQuery;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Api(tags = "登录获取令牌")
@RestController
@Validated
@RequestMapping("/secret")
public class LoginController extends BaseController {


    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysRoleDao sysRoleDao;

    @Autowired
    SysPermissionDao sysPermissionDao;


    @PostMapping(value = "/login")
    public ResultResponse<String> login(@RequestBody LoginUserQuery loginUserQuery) {


        SysUser sysUser = sysUserDao.getUserByInfo(loginUserQuery);


        if (sysUser == null)
            return new ResultResponse<String>(-1, "登录信息错误");

        SysRole sysRole = sysRoleDao.getById(sysUser.getRoleId());
        List<SysPermission> sysPermission = sysPermissionDao.listByRoleId(sysRole.getRoleId());
        String[] permissions = new String[sysPermission.size()];
        int count = 0;
        for (SysPermission s : sysPermission)
            permissions[count++] = s.getPermissionName();
        sysUser.setRoleName(sysRole.getName());
        sysUser.setPermissions(sysPermission);


        final long OVER_TIME = 24 * 60 * 60 * 1000;  //设置过期时间

        final Base64.Encoder encoder = Base64.getEncoder();

        String sysUserSerialize = SerializeUtils.serialize(sysUser);
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("site.yanyan.wwww.secret");
            token = JWT.create()
                    .withClaim("signingParty", "learn")
//                    .withClaim("userInfo", (sysUserSerialize))
                    .withClaim("userId", sysUser.getUserId())
                    .withClaim("roleId", sysUser.getRoleId())
                    .withArrayClaim("permissions", permissions)
                    .withExpiresAt(new Date(System.currentTimeMillis() + OVER_TIME))//设置过期时间
                    .sign(algorithm);
            Stamp.log("token 签署通过");
            return new ResultResponse<>(0, "ok", token);
        } catch (JWTCreationException exception) {
            Stamp.err("token 签署异常");
            return new ResultResponse<>(-1, "登录信息错误");
        }
    }
}
