package com.ui;

import java.util.Scanner;

import com.implicit.implicitController;

/**
 * Just a rough UI for now so that we can get started.
 * @author Manika Agarwal
 *
 */
public class UI {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Enter 1 to use implicit invocation and 2 to use pipeline: ");
        int choice = reader.nextInt();
        reader.close();
        
        if (choice == 1) {
            implicitController ic = new implicitController();
            ic.initialize();
        }
    }
}
