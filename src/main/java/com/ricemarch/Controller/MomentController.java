package com.ricemarch.Controller;


import com.ricemarch.Moment;
import com.ricemarch.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/follow/{username}")
    @ResponseBody
    public List<Moment> findbyname(@PathVariable String username) {
        List<Moment> moments = momentRepository.getMomentFollwFormUserName(username);
        return moments;
    }
//    @RequestMapping("/followbypages/{username}/{pages}")
//    @ResponseBody
//    public Page<Moment> findbyname2(@PathVariable String username,@PathVariable int pages) {
//        Page<Moment> moments = momentRepository.getMomentFollwFormUserName_page(username,PageRequest.of(pages,20));
//        return moments;
//    }
}
