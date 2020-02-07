package com.ricemarch.Service;

import com.ricemarch.Moment;
import com.ricemarch.User;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MomentRepository momentRepository;

    public void addUser(String username) {
        User user = new User(username);
        userRepository.save(user);
    }

    public User findUser(String username) {
        User user = userRepository.findByName(username);
        return user;
    }

    /*
    通过判断两用户间的[关注 FOLLOW]关系数量，从而达到关注和取消关注。
     */
    public int updateFollow(String name, String name2) {
        //name -like-> name2
        int count = userRepository.findFollow(name, name2);
        if (count == 0) {
            User user = userRepository.findByName(name);
            User user1 = userRepository.findByName(name2);

            user.addToFollower(user1);
            userRepository.save(user);
            return 1;
        } else if (count > 0)
            userRepository.deletefollow(name, name2);
        return -1;
    }

    /*
    通过判断两用户间的[点赞 LIKE_IN]关系数量，从而达到点赞和取消点赞。
     */
    public void updateLike(String name, String uuid) {

        int count = userRepository.findLike(name, uuid);
        if (count == 0) {
            User user = userRepository.findByName(name);
            Moment moment = momentRepository.findByMomentUuid(uuid);
            user.addlikes(moment);
        } else if (count > 0) {
            userRepository.deletefollow(name, uuid);
        }
    }
}
