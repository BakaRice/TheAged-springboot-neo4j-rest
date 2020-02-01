package com.ricemarch;

import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Month;

@SpringBootTest
class Neo4jSpringbootRestApplicationTests {

    @Autowired
    MomentRepository momentRepo;
    @Autowired
    UserRepository userRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void testSavaUser() {

        User user2 = new User("李芳芳");
//        User user3 = new User("程耳");
//        //Moment m1 = new Moment("WSZZY", "CONTENT_WSZZY");
        //Moment m2 = new Moment("WSLFF", "COTENT_WSLFF");
userRepo.save(user2);
        User user1 = userRepo.findByName("李芳芳").get(0);
        Moment m1 = momentRepo.findByTitle("WSLFF").get(0);
//       momentRepo.save(m1);
//        momentRepo.save(m2);
        if (m1!=null&&user1!=null){
            user1.addMoments(m1);
        }
        userRepo.save(user1);
//        userRepo.save(user2);
//        userRepo.save(user3);

    }

}
