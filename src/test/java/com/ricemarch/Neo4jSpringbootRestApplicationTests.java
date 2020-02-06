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

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

        User user1 = userRepo.findByName("章子怡").get(0);
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
        Moment moment = new Moment("我是1芳嗷","wsffa");
        User user2 = userRepo.findByName("李芳芳").get(0);
        user2.addMoments(moment);
        userRepo.save(user2);
    }

    @Test
    void findMomentByName() {

        List<Moment> moments = momentRepo.getMomentFollwFormUserName("李芳芳");
        System.out.println(moments.get(0).toString());
    }

    @Test
    void aVoid() {

    }

}
