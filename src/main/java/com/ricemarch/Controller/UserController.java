package com.ricemarch.Controller;

import com.ricemarch.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users/add")
    public void addUser(@RequestParam("name") String name) {

        userService.addUser(name);
    }


    @PostMapping(value = "/users/like")
    public void updateLikes(@RequestParam("selfname") String name, @RequestParam("momentId") String uuid) {
        userService.updateLike(name, uuid);
    }

    //添加关注 self 关注 name
    @PostMapping(value = "/users/follow")
    public void updateFollow(@RequestParam("selfname") String name, @RequestParam("name") String name2) {
        userService.updateFollow(name, name2);
    }
}
