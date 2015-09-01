package com.ui;

import java.io.IOException;
import java.util.Scanner;

import com.implicit.ImplicitController;
import com.pipeAndFilter.Input;

/**
 * Just a rough UI for now so that we can get started.
 * @author Manika Agarwal
 *
 */

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*System.out.println(System.in.available());
        while(true) {*/
        System.out.print("Enter 1 to use implicit invocation, 2 to use pipeline: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            ImplicitController ic = new ImplicitController();
            ic.start();
        } else if (choice == 2) {
            Input input = new Input();
            input.start();
        } //else if (choice == 3) {
        //break;
        //        } 
        else {
            System.out.println("Invalid input");
        }
        //  }
        scanner.close();
    }
}
