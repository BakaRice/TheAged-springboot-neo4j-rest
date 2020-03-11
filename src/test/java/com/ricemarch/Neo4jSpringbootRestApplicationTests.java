package com.ricemarch;

import com.ricemarch.entity.Comment;
import com.ricemarch.entity.Moment;
import com.ricemarch.entity.User;
import com.ricemarch.repository.CommentRepository;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void addUser() {
        User user = new User("小谭");

        userRepo.save(user);
    }

    @Test
    void addFollower() {
        User user1 = userRepo.findByName("程耳");
        User user2 = userRepo.findByName("小谭");

        user1.addToFollower(user2);
        userRepo.save(user1);
        userRepo.save(user2);

    }

    @Test
    void addPublish() {
        Moment moment = momentRepo.findByMomentUuid("e5f847ea295a43a9a7e31b37f86fa915");
//        Moment moment2 = momentRepo.findByMomentUuid("2a571a8a38fe49019188acad37f0c897");
//        Moment moment3 = momentRepo.findByMomentUuid("aadcf8a28a29403594ecb3e5fcc1e88c");
//        Moment moment4 = momentRepo.findByMomentUuid("d3365969a6a047cda0be77e05eac2d62");
//        Moment moment5 = momentRepo.findByMomentUuid("21ed5be1ec534cc6b8492e99dfbe6380");

        User user1 = userRepo.findByName("程耳");
        user1.addMoments(moment);
//        user1.addMoments(moment2);
//        user1.addMoments(moment3);
//        user1.addMoments(moment4);
//        user1.addMoments(moment5);
        userRepo.save(user1);
    }


    @Test
    void findComment(){
        Comment beComment = commentRepo.findbyCommentUuid("dd2ade23b5f14e489322bb10f317bffd");
    }

    /*
    {
  "name": "李芳芳",
  "MomentUuid": "60460a8dc34e4f7581b2e9455873d08c",
  "title": "5",
  "imgUrls": [
    "https://pixabay.com/get/57e5d6404855a414f6da8c7dda79367b1536dce555506c4870277bd0914dcd51bf_640.jpg",
    "https://pixabay.com/get/55e2d3454853ad14f6da8c7dda79367b1536dce555506c4870277bd0914dcd51bf_640.jpg",
    "https://pixabay.com/get/57e8d7414e51ab14f6da8c7dda79367b1536dce555506c4870277bd0914dcd51bf_640.jpg"
  ],
  "content": "wsffa",
  "likeNum": 0
}
     */
}
