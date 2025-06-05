package com.domain.wiseSaying.service;

import com.AppContext;
import com.domain.wiseSaying.entity.WiseSaying;
import com.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String content, String author){

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findForList(String keywordType, String keyword) {
        // 검색 키워드가 비어 있으면 전체 명언 리스트 반환
        if (keyword.isBlank()) return wiseSayingRepository.findForList();

        // keywordType에 따라 검색 방식 결정
        return switch (keywordType){
            // keywordType이 "content"면, content를 기준으로 검색
            case "content" -> wiseSayingRepository.findForListByContentContaining(keyword);
            // keywordType이 "author"면, author를 기준으로 검색
            case "author" -> wiseSayingRepository.findForListByAuthorContaining(keyword);
            default -> wiseSayingRepository.findForListByContentorAuthor(keyword, keyword);
        };
    }

    public boolean delete(int id) {
        WiseSaying wiseSaying = wiseSayingRepository.findById(id);

        if ( wiseSaying == null ) return false;

        wiseSayingRepository.delete(wiseSaying);

        return true;
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);
    }
}
