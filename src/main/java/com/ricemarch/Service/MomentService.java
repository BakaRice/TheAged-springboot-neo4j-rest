package com.ricemarch.Service;

import com.ricemarch.Moment;
import com.ricemarch.repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
