package com;

import com.domain.system.SystemController;
import com.domain.wiseSaying.controller.WiseSayingController;
import com.domain.wiseSaying.repository.WiseSayingRepository;
import com.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;

    public static WiseSayingRepository wiseSayingRepository;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingController wiseSayingController;

    public static SystemController systemController;

    public static void renew(Scanner _scanner) {
        scanner = _scanner;

        wiseSayingRepository = new WiseSayingRepository();
        wiseSayingService = new WiseSayingService();
        wiseSayingController = new WiseSayingController();
        systemController = new SystemController();
    }

    public static void renew(){
        renew(new Scanner(System.in));
    }
}
