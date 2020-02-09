package com.ricemarch.Controller;

import com.ricemarch.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {


    @Autowired
    CommentService commentService;

    //添加对于moment的评论
    @PostMapping(value = "/comments/add_M")
    public void addCommentToMoment(
            @RequestParam("name") String name,
            @RequestParam("context") String context,
            @RequestParam("m_uuid") String m_uuid) {
        commentService.addCommentToMoment(name, context, m_uuid);
    }

    //添加对于comment的评论
    @PostMapping(value = "/comments/add_C")
    public void addCommentToComment(
            @RequestParam("name") String name,
            @RequestParam("context") String context,
            @RequestParam("c_uuid") String c_uuid
    ) {
        commentService.addCommentToComment(name, context, c_uuid);
    }

    //删除指定的comments
    @PostMapping(value = "/comments/deleteAll")
    public void deleteAllComments(
            @RequestParam("c_uuid") String c_uuid,
            @RequestParam("name") String name) {
        commentService.deleteComment(c_uuid, name);
    }
}
