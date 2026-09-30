package com.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char op1;
        char op2;
        int a = 3;
        int b = 4;
        int c = 2;
        int d = 14;
        System.out.println("3[]4[]2=14 빈칸에 들어갈 알맞은 연산자를 맞춰보세요.");
        while (true) {
            System.out.print("첫번째 연산자 입력 (+,-,*,/): ");
            String input = sc.next();
            if (input.length() != 1) {
                System.out.println("연산자 한 글자만 입력해 주세요.");
                continue;
            }
            op1 = input.charAt(0);

            if (op1 == '+' || op1 == '-' || op1 == '*' || op1 == '/') {
                break;
            }

            System.out.println("잘못된 입력입니다.");
        }

        while (true) {
            System.out.print("두번째 연산자 입력 (+,-,*,/): ");
            String input = sc.next();
            if (input.length() != 1) {
                System.out.println("연산자 한 글자만 입력해 주세요.");
                continue;
            }
            op2 = input.charAt(0);

            if (op2 == '+' || op2 == '-' || op2 == '*' || op2 == '/') {
                break;
            }

            System.out.println("잘못된 입력입니다.");
        }

        if (priority(op1) >= priority(op2)) {
            int x = calculate(a, b, op1);
            int result = calculate(x, c, op2);
            if (result == d) {
                System.out.println("정답입니다.");
            } else {
                System.out.println("틀렸습니다.");
            }
        } else {
            int x = calculate(b, c, op2);
            int result = calculate(a, x, op1);
            if (result == d) {
                System.out.println("정답입니다.");
            } else {
                System.out.println("틀렸습니다.");
            }
        }
    }

    static int calculate(int a, int b, char op) {

        int result = 0;

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }

        return result;
    }

    static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
