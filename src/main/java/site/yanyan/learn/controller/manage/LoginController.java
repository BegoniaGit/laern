package site.yanyan.learn.controller.manage;

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
import site.yanyan.learn.dao.SysUserDao;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.sys.SysUser;
import site.yanyan.learn.utils.SerializeUtils;
import site.yanyan.learn.vo.LoginUserQuery;

import java.util.Base64;
import java.util.Date;

@Api(tags = "登录获取令牌")
@RestController
@Validated
@RequestMapping("/secret")
public class LoginController extends BaseController {


    @Autowired
    SysUserDao sysUserDao;


    @PostMapping(value = "/login")
    public ResultResponse<String> login(@RequestBody LoginUserQuery loginUserQuery) {


        SysUser sysUser = sysUserDao.getUserByInfo(loginUserQuery);

        if (sysUser == null)
            return new ResultResponse<String>(-1, "登录信息错误");

        final long OVER_TIME =  1000;


        final Base64.Encoder encoder = Base64.getEncoder();

        String s = SerializeUtils.serialize(sysUser);
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("site.yanyan.wwww.secret");
            token = JWT.create()
                    .withClaim("signingParty", "learn")
                    .withClaim("userInfo", encoder.encodeToString(s.getBytes()))
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
