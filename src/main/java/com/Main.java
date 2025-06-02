package com;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        lab1();
    }

    private static void lab1() {
//        String input = "input \n blah";
        String input = """
                input
                blah
                """;
        Scanner scanner = new Scanner(input);

        String cmd = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.println("cmd : " + cmd);
        System.out.println("content : " + content);
    }
}