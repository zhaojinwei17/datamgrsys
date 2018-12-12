package com.zjw.datamgrsys.controller;

import com.zjw.datamgrsys.pojo.User;
import com.zjw.datamgrsys.service.UserService;
import com.zjw.datamgrsys.util.CookieUtils;
import com.zjw.datamgrsys.util.JsonUtils;
import com.zjw.datamgrsys.util.MgrResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    UserService userService;
    @Resource
    User user;

    @RequestMapping("/register")
    public MgrResult register(User user){
        MgrResult result = userService.register(user);
        return result;
    }

    @RequestMapping("/login")
    public MgrResult login(User user, HttpServletRequest request, HttpServletResponse response){
        MgrResult result = userService.login(user);
        if(result.getStatus()==200){
            HttpSession session = request.getSession();
            user= (User) result.getData();

            this.user.setId(user.getId());
            this.user.setName(user.getName());
            this.user.setPhone(user.getPhone());
            this.user.setClasses(user.getClasses());
            this.user.setUpdatetime(user.getUpdatetime());
            this.user.setCreatetime(user.getCreatetime());
            this.user.setPassword(user.getPassword());
            this.user.setCremen(user.getCremen());
            this.user.setGroupname(user.getGroupname());
            this.user.setRoleid(user.getRoleid());
            this.user.setUpdatemen(user.getUpdatemen());

            String json = JsonUtils.objectToJson(result.getData());
            String token= UUID.randomUUID().toString();
            token="user："+token;
            session.setAttribute(token,json);
            CookieUtils.setCookie(request,response,"mgruser",token);
        }
        return result;
    }
    @RequestMapping("/logout")
    public  MgrResult logout(HttpServletRequest request){
        String sessionId = CookieUtils.getCookieValue(request, "mgruser");
        HttpSession session = request.getSession();
        session.removeAttribute(sessionId);
        return MgrResult.ok();
    }
    @RequestMapping("/getuser")
    public MgrResult getUser(HttpServletRequest request) {
        return MgrResult.ok(user);
    }
}