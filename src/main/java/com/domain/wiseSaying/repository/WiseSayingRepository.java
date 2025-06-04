package com.domain.wiseSaying.repository;

import com.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {
    private int id = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()) {
            wiseSaying.setId(++id);
            wiseSayings.add(wiseSaying);
        }
        return wiseSaying;
    }

    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }

    public WiseSaying findById(int id) {
        int index = IntStream
                .range(0, wiseSayings.size())
                .filter(e -> wiseSayings.get(e).getId() == id)
                .findFirst()
                .orElse(-1);

        if (index == -1) {
            return null;
        }else {
            return wiseSayings.get(index);
        }
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
}
