package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    private static final Scanner in = new Scanner(System.in);

    public void showWelcomeMessage() {
        System.out.println("*************************");
        System.out.println("**     Weyland Corp.   **");
        System.out.println("**      Catering       **");
        System.out.println("*************************");
        System.out.println();
    }

}
