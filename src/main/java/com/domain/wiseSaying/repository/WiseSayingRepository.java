package com.domain.wiseSaying.repository;

import com.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<WiseSaying> findForListByContentContaining(String keyword) {
        // 전체 명언 중 content에 keyword가 포함된 항목만 필터링
        return wiseSayings
                .stream()
                .filter(w-> w.getContent().contains(keyword)) // keyword 포함 여부 확인
                .collect(Collectors.toList()) // 리스트로 변환
                .reversed(); //
    }

    public List<WiseSaying> findForListByAuthorContaining(String keyword) {
        return wiseSayings
                .stream()
                .filter(w -> w.getAuthor().contains(keyword))
                .collect(Collectors.toList())
                .reversed();
    }

    public List<WiseSaying> findForListByContentorAuthor(String keyword, String keyword1) {
        return wiseSayings
                .stream()
                .filter(w -> w.getContent().contains(
                        keyword) || w.getAuthor().contains(keyword))
                .collect(Collectors.toList())
                .reversed();
    }
}
