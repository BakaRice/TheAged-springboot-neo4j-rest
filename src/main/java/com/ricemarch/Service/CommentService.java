package com.ricemarch.Service;

import com.ricemarch.entity.Comment;
import com.ricemarch.entity.Moment;
import com.ricemarch.entity.User;
import com.ricemarch.repository.CommentRepository;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MomentRepository momentRepository;
    @Autowired
    UserRepository userRepository;

    public void addCommentToMoment(String name, String context, String m_uuid) {
        Moment moment = momentRepository.findByMomentUuid(m_uuid);
        if (moment != null) {

            String toName = moment.getName();//moment对应发表人的name。
            Comment comment = new Comment(context, name, toName);
            commentRepository.addCommentAtomToM(
                    m_uuid,
                    comment.getCommentUuid(),
                    comment.getContent(),
                    comment.getName(),
                    comment.getToName()
            );
        }
    }

    public void addCommentToComment(String name, String content, String c_uuid) {

        Comment beComment = commentRepository.findbyCommentUuid(c_uuid);
        if (beComment != null) {

            String toName = beComment.getName();//comment对应发表人的name
            Comment comment = new Comment(content, name, toName);
            commentRepository.addCommentAtomToC(
                    c_uuid,
                    comment.getCommentUuid(),
                    comment.getContent(),
                    comment.getName(),
                    comment.getToName());
        }

    }

    public void deleteComment(String uuid, String name) {
        if (userRepository.findByName(name) != null)
            commentRepository.deleteComment(uuid);

    }

    public Page<Comment> getPagerCommentByMomentUuid(String m_uuid, int page, int size) {
        Page<Comment> comments = commentRepository.getCommentByMoentUuid_page(m_uuid, PageRequest.of(page, size));
        return comments;
    }

    public Page<Comment> getPagerReplyByCommentUuid(String C_uuid, int page, int size) {
        Page<Comment> comments = commentRepository.getReplyByCommentUuid_page(C_uuid, PageRequest.of(page, size));
        return comments;
    }

}
