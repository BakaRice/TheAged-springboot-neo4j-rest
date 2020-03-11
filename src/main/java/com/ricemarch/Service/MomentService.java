package com.ricemarch.Service;

import com.ricemarch.entity.Moment;
import com.ricemarch.repository.MomentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MomentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MomentService.class);

    @Autowired
    MomentRepository momentRepository;

    public Page<Moment> findAllMoment(int page, int size) {
        Page<Moment> momentPage = momentRepository.findAllMoment(PageRequest.of(page, size));
        return momentPage;
    }

    public Page<Moment> getPagerMomentsbyUsername(String username, int page, int size) {
        Page<Moment> momentPage = momentRepository.getMomentFollwFormUserName_page(username, PageRequest.of(page, size));
        List<Moment> list = momentPage.getContent();
        return momentPage;
    }

    public List<Moment> getMomentsbyUsername(String username) {
        List<Moment> moments = momentRepository.getMomentFollwFormUserName(username);
        return moments;
    }

    //ADD NEW MOMENT
    public String addMoments(String name, String title, String content, ArrayList<String> imglist) {
        //ArrayList<String> imglist = new ArrayList<>(Arrays.asList(imgs));
        String id = null;
        try {
            id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            momentRepository.addMomentAtom(
                    id,
                    imglist,
                    name,
                    title,
                    content);

            LOGGER.info("Success add moment form user:[" + name + "]");
            return id;

        } catch (Exception e) {

            LOGGER.error(e.toString());
            return null;
        }

    }

    public void delMoments(String name, String uuid) {
        Moment moment = momentRepository.findByMomentUuid(uuid);
        if (moment.getName().equals(name))
            momentRepository.delMomentByUuid(uuid);
    }
}
