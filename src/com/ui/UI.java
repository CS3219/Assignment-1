package com.ui;

import java.util.Scanner;

import com.implicitInvocation.ImplicitController;
import com.pipeAndFilter.PipeAndFilterController;

/**
 * Just a rough UI for now so that we can get started.
 * @author Manika Agarwal
 *
 */

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 1 to use implicit invocation, 2 to use pipeline and 3 to exit: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                ImplicitController ic = new ImplicitController();
                ic.start();
            } else if (choice == 2) {
                PipeAndFilterController pipeAndFilterController = new PipeAndFilterController();
                pipeAndFilterController.startExecution();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        
        scanner.close();
    }
}
