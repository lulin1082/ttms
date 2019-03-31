package cn.tedu.ttms.login.controller;

import cn.tedu.ttms.common.web.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:31 PM
 * @Version 1.0
 */
@Controller
public class LoginController {

   /* @Autowired
    UserRealm userRealm;*/

    Logger logger = LoggerFactory.getLogger(LoggerFactory.class);


    @RequestMapping("/toLogin")
    public String login() {
        logger.info("请求登页面");
        return "login/login";
    }

    /* @RequestMapping(value = "/comfirmUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")*/
    @RequestMapping(value = "/confirmUser", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult confirmUser(String username, String userpwd, boolean remeber) {
        Subject currentUser = SecurityUtils.getSubject();
        //System.out.println("用户名" + username + "密码" + userpwd);
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
            token.setRememberMe(remeber);
            currentUser.login(token);
        }


        return new JsonResult();
    }


}
