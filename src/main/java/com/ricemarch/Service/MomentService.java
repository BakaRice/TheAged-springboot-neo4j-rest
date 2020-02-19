package com.ricemarch.Service;

import com.ricemarch.Moment;
import com.ricemarch.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class MomentService {

    @Autowired
    MomentRepository momentRepository;

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
    public void addMoments(String name, String title, String content, ArrayList<String> imglist) {
        //ArrayList<String> imglist = new ArrayList<>(Arrays.asList(imgs));
        momentRepository.addMomentAtom(
                UUID.randomUUID().toString().replace("-", "").toLowerCase(),
                imglist,
                name,
                title,
                content
        );
    }

    public void delMoments(String name, String uuid) {
        Moment moment = momentRepository.findByMomentUuid(uuid);
        if (moment.getName().equals(name))
            momentRepository.delMomentByUuid(uuid);
    }
}
