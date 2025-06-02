package com.domain.wiseSaying.service;

import com.domain.wiseSaying.entity.WiseSaying;
import com.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author){

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findForList() {
        return wiseSayingRepository.findForList();
    }
}
