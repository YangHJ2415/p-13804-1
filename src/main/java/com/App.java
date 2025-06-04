package com;

import com.domain.system.SystemController;
import com.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run() {
        WiseSayingController wiseSayingController = AppContext.wiseSayingController;
        SystemController systemController = AppContext.systemController;

        System.out.println("== 명언 앱 ==");

        while (true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            switch (cmd){
                case "등록" -> {
                    wiseSayingController.actionWrite();
                }
                case "목록" -> {
                    wiseSayingController.actionList();
                }
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }


}