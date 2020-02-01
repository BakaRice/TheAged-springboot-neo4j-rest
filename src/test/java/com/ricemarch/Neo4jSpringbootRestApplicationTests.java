package com.ricemarch;

import com.ricemarch.repository.CommentRepository;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
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

        User user1 = userRepo.findByName("李芳芳").get(0);
       // Comment c1 = commentRepo.findByCconetnt("章子怡好看啊!");
       // Moment m1 = momentRepo.findByTitle("WSZZY").get(0);
     //   user1.addComments(c1);
     //   m1.addBeComments(c1);

        userRepo.save(user1);
        //commentRepo.save(c1);
       // momentRepo.save(m1);
        //m1.addComments(c1);
        // momentRepo.save(m1);
        //commentRepo.save(c1);
//       momentRepo.save(m1);
//        momentRepo.save(m2);
//        if (m1 != null && user1 != null) {
//            user1.addMoments(m1);
//        }
//        userRepo.save(user1);
//        userRepo.save(user2);
//        userRepo.save(user3);

    }

}
