package com.webshiro.controller;

import com.webshiro.dao.UserMapper;
import com.webshiro.entity.Permission;
import com.webshiro.entity.Role;
import com.webshiro.entity.User;
import com.webshiro.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/2/12 0012.
 */
@Controller
public class loginController {

    @Value("${defaultPath}")
    private String defaultPath;

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录验证交由shiroFilter完成，这里只跳转的login.jsp
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotBlank(principal)){
            return "redirect:"+defaultPath;
        }
        return "login";
    }

    /**
     * 登录成功
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/default")
    public String defaultPath(HttpServletRequest request, HttpServletResponse response, Model model){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("principal",principal);
        return "success";
    }

    /**
     * 注册新账号，并且加密，存入数据库
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/signIn")
    public String signIn(String username,String password){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("md5",password,username+salt,2);
        password= hash.toString();
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(username);
        user.setPassword(password);
        user.setSalt(salt);
        User userByUsername = userMapper.findUserByUsername(username);


        userMapper.insert(user);

        return "redirect:login";
    }

    @RequestMapping("/authorTest")
    @RequiresPermissions(value = "user:fuck")
    public String authorTest(Model model){
        String principal = (String)SecurityUtils.getSubject().getPrincipal();
        User rolesByUserName = userMapper.findRolesByUserName(principal);
        User permissionsByUserName = userMapper.findPermissionsByUserName(principal);
        model.addAttribute("roles",rolesByUserName.getRoles());
        model.addAttribute("permissions",permissionsByUserName.getPermissions());
        return "message";
    }
}
