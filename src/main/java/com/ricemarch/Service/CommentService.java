package com.ricemarch.Service;

import com.ricemarch.Comment;
import com.ricemarch.Moment;
import com.ricemarch.User;
import com.ricemarch.repository.CommentRepository;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MomentRepository momentRepository;
    @Autowired
    UserRepository userRepository;

    public void addCommentToMoment(String name, String conetext, String m_uuid) {
        Comment comment = new Comment(conetext);
        comment.setName(name);

        Moment moment = momentRepository.findByMomentUuid(m_uuid);
        User user = userRepository.findByName(name);

        user.addComments(comment);
        moment.addBeComments(comment);

        userRepository.save(user);
        commentRepository.save(comment);
        momentRepository.save(moment);
    }


    public void addCommentToComment(String name, String conetext, String c_uuid) {
        Comment comment = new Comment(conetext);
        comment.setName(name);

        User user = userRepository.findByName(name);
        Comment becomment = commentRepository.findByCommentUuid(c_uuid);
        comment.addCommenToComment(becomment);
        user.addComments(comment);

        commentRepository.save(comment);
        commentRepository.save(becomment);
        userRepository.save(user);

    }

    public void deleteComment(String uuid, String name) {
        if (userRepository.findByName(name) != null)
            commentRepository.deleteComment(uuid);

    }
}
