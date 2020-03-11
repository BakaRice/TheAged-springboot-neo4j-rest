package com.ricemarch.Controller;

import com.ricemarch.Dto.UserAddDto;
import com.ricemarch.Service.UserService;
import com.ricemarch.api.CommonResult;
import com.ricemarch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/add/{username}")
    @ResponseBody
    public CommonResult addUser(@PathVariable String username) {
        String failInfo;
        try {
            UserAddDto userAddDto = new UserAddDto();
            userService.addUser(username);
            userAddDto.setUsername(username);
            return CommonResult.success(username);
        } catch (Exception e) {
            failInfo = e.toString();
        }
        return CommonResult.failed(failInfo);

    }

    @RequestMapping(value = "/users/status/{username}")
    @ResponseBody
    public User findUser(@PathVariable String username) {
//        UserStatusDto userStatusDto = new UserStatusDto();
        try {
            @NotNull
            User user = userService.findUser(username);
//            userStatusDto.setUser(user);
//            return CommonResult.success(userStatusDto);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return CommonResult.failed();
        return null;
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
