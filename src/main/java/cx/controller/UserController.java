package cx.controller;

import cx.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-8-25.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @RequestMapping("getUserList")
    @ResponseBody
    public Object getUserList(){
        return userServiceI.getListUser(null);
    }




}
