package com.ricemarch.Service;

import com.ricemarch.entity.Moment;
import com.ricemarch.entity.User;
import com.ricemarch.repository.MomentRepository;
import com.ricemarch.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

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
        Moment moment = momentRepository.findByMomentUuid(uuid);

        int likeCount = moment.getLikeNum();
        if (count == 0) {
            User user = userRepository.findByName(name);
            moment.setLikeNum(likeCount + 1);//点赞数量+1
            user.addlikes(moment);
            userRepository.save(user);
        } else if (count > 0) {
            userRepository.deletelike(name, uuid);
            if (likeCount > 0)
                moment.setLikeNum(likeCount - 1);
        }
    }


    public void publishMoment(String name, String uuid) {
        try {
            User user = userRepository.findByName(name);
            Moment moment = momentRepository.findByMomentUuid(uuid);
            user.addMoments(moment);
            userRepository.save(user);
            LOGGER.info("success add relationship \"PUBLISH\" user:[" + name + "] " + "MomentUuid:[" + uuid + "]");
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }
}
