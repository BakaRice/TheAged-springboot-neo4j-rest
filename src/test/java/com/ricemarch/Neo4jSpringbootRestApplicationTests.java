package com.ricemarch;

import com.ricemarch.repository.CommentRepository;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.security.Timestamp;
import java.time.Month;
import java.util.*;

@SpringBootTest
class Neo4jSpringbootRestApplicationTests {

    @Autowired
    MomentRepository momentRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    CommentRepository commentRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void testSavaUser() {

//        User user2 = new User("李芳芳");
//        User user3 = new User("程耳");
//        Moment m1 = new Moment("WSZZY", "CONTENT_WSZZY");
//        Moment m2 = new Moment("WSLFF", "COTENT_WSLFF");
//        userRepo.save(user2);
//        Moment m1 = momentRepo.findByTitle("WSLFF").get(0);
//        System.out.println(m1.get(0));
//        Comment c1 = new Comment("章子怡好看啊!");

        User user1 = userRepo.findByName("章子怡");
        // Comment c1 = commentRepo.findByConetnt("章子怡好看啊!");
        Comment c2 = new Comment("2.2最终测试，你也好看");
        Moment m1 = momentRepo.findByTitle("WSLFF").get(0);
        user1.addComments(c2);//user1发表评论c2
        m1.addBeComments(c2);//m1被评论 内容是c2

        userRepo.save(user1);
        momentRepo.save(m1);
        commentRepo.save(c2);
    }

    @Test
    void addFollwer() {
//        User user1 = userRepo.findByName("章子怡").get(0);
//        User user2 = userRepo.findByName("李芳芳").get(0);
        User user1 = new User("李芳芳");
        User user2 = new User("程耳");
        user2.addToFollower(user1);
        userRepo.save(user1);
        userRepo.save(user2);
    }

    @Test
    void addMoments() {
        //Moment moment = momentRepo.findByTitle("我是芳芳嗷").get(0);
        Moment moment = new Moment("李芳芳", "uuid我是1芳嗷", "wsffa");
        User user2 = userRepo.findByName("李芳芳");
        user2.addMoments(moment);
        userRepo.save(user2);
    }

    @Test
    void addLike() {
        User user2 = userRepo.findByName("posttest");
        Moment moment = momentRepo.findByMomentUuid("8993da1b54674e5183f96c5841f5030b");
        user2.addlikes(moment);
        userRepo.save(user2);
    }

    @Test
    void findMomentByName() {

        List<Moment> moments = momentRepo.getMomentFollwFormUserName("李芳芳");
        System.out.println(moments.get(0).toString());
    }

    @Test
    void addFollow() {
        userRepo.addFollow("posttest", "posttest2");
    }

    @Test
    void findfollow() {
        int follow = userRepo.findFollow("posttest", "posttest2");
        System.out.println(follow);
    }

    @Test
    void addComment() {

        Comment comment = new Comment("评论4");
        commentRepo.save(comment);

        User user2 = userRepo.findByName("posttest");
        user2.addComments(comment);

        Comment comment1 = commentRepo.findByCommentUuid("07f16f716b304b8e9924f3c3112bbf6b");
        comment.addCommenToComment(comment1);

        commentRepo.save(comment1);
        userRepo.save(user2);

    }

    @Test
    void findComment() {
        Comment comment1 = commentRepo.findByCommentUuid("07f16f716b304b8e9924f3c3112bbf6b");
        System.out.println(comment1);
    }

    @Test
    void deleteComment() {
        commentRepo.deleteComment("ea727063be414553ad34ea580b454e3c");
    }

    @Test
    void addAllInfoMomment() {
        Moment moment = new Moment("发布人1", "标题1", "正文1");
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add("url1");
        imgs.add("url2");
        moment.setImgUrls(imgs);
        momentRepo.save(moment);
        momentRepo.addtimeMomentUuid(moment.getMomentUuid());
        momentRepo.save(moment);
    }

    @Test
    void addMomentAtom() {
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add("url1");
        imgs.add("url2");
        String content = "testtest";
        String title = "testtest";
        String name = "testtest";
        momentRepo.addMomentAtom(
                UUID.randomUUID().toString().replace("-", "").toLowerCase(),
                imgs,
                name,
                title,
                content
        );
    }
}
