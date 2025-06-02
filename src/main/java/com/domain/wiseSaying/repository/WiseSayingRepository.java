package com.domain.wiseSaying.repository;

import com.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int id = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying save(WiseSaying wiseSaying) {
        wiseSaying.setId(++id);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }
}
