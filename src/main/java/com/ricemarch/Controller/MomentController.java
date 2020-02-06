package com.ricemarch.Controller;


import com.ricemarch.Moment;
import com.ricemarch.Service.MomentService;
import com.ricemarch.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/moments")
public class MomentController {

    @Autowired
    MomentRepository momentRepository;

    @Autowired
    MomentService momentService;

    //返回当前username的用户关注的用户发布的朋友圈
    @RequestMapping("/follow/{username}")
    @ResponseBody
    public List<Moment> findbyname(@PathVariable String username) {

        return momentService.getMomentsbyUsername(username);

    }

    @RequestMapping("/followbypages/{username}/{pages}")
    @ResponseBody
    public Page<Moment> findbyname2(@PathVariable String username, @PathVariable int pages) {
//       Page<Moment> moments = momentRepository.getMomentFollwFormUserName_page(username, PageRequest.of(pages,1));
//        return moments;

        return momentService.getPagerMomentsbyUsername(username, pages, 2);

    }
            }
