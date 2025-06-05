package com.domain.wiseSaying.controller;

import com.AppContext;
import com.domain.wiseSaying.entity.WiseSaying;
import com.domain.wiseSaying.service.WiseSayingService;
import com.global.Rq;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController() {
        this.scanner = AppContext.scanner;
        this.wiseSayingService = AppContext.wiseSayingService;
    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public void actionList() {
        if (wiseSayingService.findForList().isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
            return;
        }

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (WiseSaying wiseSaying : wiseSayingService.findForList()) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if(id == -1){
            System.out.println("id를 정확히 입력해주세요");
            return;
        }
        boolean deleted = wiseSayingService.delete(id);
        if(!deleted){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if ( wiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n",  wiseSaying.getContent());
        System.out.printf("명언 : ");
        String content = scanner.nextLine();

        System.out.printf("작가(기존) : %s\n",  wiseSaying.getAuthor());
        System.out.printf("작가 : ");
        String author = scanner.nextLine();

        wiseSayingService.modify(wiseSaying, content, author);
    }
}
