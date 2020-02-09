package com.ricemarch.Controller;


import com.ricemarch.Moment;
import com.ricemarch.Service.MomentService;
import com.ricemarch.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/moments")
public class MomentController {

    @Autowired
    MomentService momentService;

    //返回当前username的用户关注的用户发布的朋友圈
    @RequestMapping("/follow/{username}")
    @ResponseBody
    public List<Moment> findbyname(@PathVariable String username) {

        return momentService.getMomentsbyUsername(username);

    }

    //返回当前username的用户关注的用户发布的朋友圈，按页分布
    @RequestMapping(value = "/followbypages/username={username}&per_page={perpage}&page={pages}")
    @ResponseBody
    public Page<Moment> findbyname2(@PathVariable String username, @PathVariable int pages, @PathVariable int perpage) {
        return momentService.getPagerMomentsbyUsername(username, pages, perpage);

    }

    //    新发布moment！
    @PostMapping("/add")
    public void addMoments(@RequestParam ArrayList<String> imgs,
                           @RequestParam String name,
                           @RequestParam String title,
                           @RequestParam String cotent) {
        momentService.addMoments(name, title, cotent, imgs);
    }

    // 删除指定uuid moment！
    @PostMapping("/del")
    public void delMoments(@PathVariable String uuid,
                           @PathVariable String name) {

    }

}
