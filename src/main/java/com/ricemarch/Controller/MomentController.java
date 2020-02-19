package com.ricemarch.Controller;


import com.ricemarch.Dto.MomentUploadDto;
import com.ricemarch.Moment;
import com.ricemarch.Service.MomentService;
import com.ricemarch.api.CommonResult;
import com.ricemarch.repository.MomentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger LOGGER = LoggerFactory.getLogger(MomentController.class);
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
    @ResponseBody
    public CommonResult addMoments(@RequestParam ArrayList<String> imgs,
                                   @RequestParam String name,
                                   @RequestParam String title,
                                   @RequestParam String content) {
        try {
            momentService.addMoments(name, title, content, imgs);
            MomentUploadDto momentUploadDto = new MomentUploadDto();
            momentUploadDto.setName(name);
            momentUploadDto.setTitle(title);

            LOGGER.info("Success upload moment！name:[" + name + "] title:[" + title + "]");

            return CommonResult.success(momentUploadDto);
        } catch (Exception e) {
            return CommonResult.failed();
        }


    }

    // 删除指定uuid moment！
    @PostMapping("/del")
    public void delMoments(@RequestParam("momentUuid") String momentUuid, @RequestParam("name") String name) {
        momentService.delMoments(name, momentUuid);
    }

}
