package com.jetbrains;

import java.util.Scanner;
import java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter x: ");
        Scanner scanner = new Scanner(System.in);
	    int x = scanner.nextInt();

        System.out.print("Enter y: ");
        scanner = new Scanner(System.in);
        int y = scanner.nextInt();

        System.out.println("1: +");
        System.out.println("2: -");
        System.out.println("3: *");
        System.out.println("4: /");
        System.out.println("5: %");
        System.out.println("6: ^");
        System.out.print("Select an action: ");
        int answer = scanner.nextInt();

        switch (answer)
        {
            case 1:
                System.out.println(x + " + " + y + " = " + (x + y));
                break;
            case 2:
                System.out.println(x + " - " + y + " = " + (x - y));
                break;
            case 3:
                System.out.println(x + " * " + y + " = " + (x * y));
                break;
            case 4:
                System.out.println(x + " / " + y + " = " + (x / y));
                break;
            case 5:
                System.out.println(x + " % " + y + " = " + (x % y));
                break;
            case 6:
                System.out.println(x + " ^ " + y + " = " + Math.pow(x, y));
                break;
            default:
                System.out.println("oops...");
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("List of actions: + - / * % ^");
//        System.out.println("Enter: <X> <action> <Y>");
//
//        System.out.print("$:");
//        String answer = in.nextLine();
//
//        if (answer.equals("")) {
//            return;
//        }
//
//        StringBuilder builderForDigitX = new StringBuilder();
//        StringBuilder builderForDigitY = new StringBuilder();
//        StringBuilder builderForAction = new StringBuilder();
//
//        int x = 0;
//        int y = 0;
//        char action = ' ';
//
//        for (int i = 0; i < answer.length(); i++) {
//            char ch = answer.charAt(i);
//            if (ch == ' ') {
//                continue;
//            } else if (Character.isDigit(ch) && action == ' ') {
//                for (; Character.isDigit(ch); i++) {
//                    ch = answer.charAt(i);
//                    builderForDigitX.append(ch);
//                }
//                String strX = builderForDigitX.toString();
//                x = Integer.parseInt(strX);
//            } else if (Character.isDigit(ch) && action != ' ') {
//                for (; Character.isDigit(ch); i++) {
//                    ch = answer.charAt(i);
//                    builderForDigitY.append(ch);
//                }
//                String strY = builderForDigitY.toString();
//                y = Integer.parseInt(strY);
//            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^' || ch == '%') {
//                action = ch;
//            }
//        }
//
//        switch (action)
//        {
//            case '+':
//                System.out.println(x + " + " + y + " = " + (x + y));
//                break;
//            case '-':
//                System.out.println(x + " - " + y + " = " + (x - y));
//                break;
//            case '*':
//                System.out.println(x + " * " + y + " = " + (x * y));
//                break;
//            case '/':
//                System.out.println(x + " / " + y + " = " + (x / y));
//                break;
//            case '%':
//                System.out.println(x + " % " + y + " = " + (x % y));
//                break;
//            case '^':
//                System.out.println(x + " % " + y + " = " + Math.pow(x, y));
//                break;
//            default:
//                System.out.println("oops...");
//        }
//    }
}
