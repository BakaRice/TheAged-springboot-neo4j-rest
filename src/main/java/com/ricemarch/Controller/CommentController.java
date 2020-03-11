package com.ricemarch.Controller;

import com.ricemarch.Service.CommentService;
import com.ricemarch.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/comments/MomentUuid={MomentUuid}&per_page={perpage}&page={pages}")
    @ResponseBody
    public Page<Comment> findbyUuid(@PathVariable String MomentUuid, @PathVariable int pages, @PathVariable int perpage) {
        return commentService.getPagerCommentByMomentUuid(MomentUuid, pages, perpage);
    }

    @RequestMapping(value = "/comments/Reply/CommentUuid={CommentUuid}&per_page={perpage}&page={pages}")
    @ResponseBody
    public Page<Comment> findReplybyCommentUuid(@PathVariable String CommentUuid, @PathVariable int pages, @PathVariable int perpage) {
        return commentService.getPagerReplyByCommentUuid(CommentUuid, pages, perpage);
    }
}
