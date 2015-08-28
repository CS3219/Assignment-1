package com.ui;

import java.util.Scanner;
import com.implicit.ImplicitController;

/**
 * Just a rough UI for now so that we can get started.
 * @author Manika Agarwal
 *
 */

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 1 to use implicit invocation and 2 to use pipeline: ");
        int choice = scanner.nextInt();
        
        
        if (choice == 1) {
            ImplicitController ic = new ImplicitController();
            ic.initialize();
        } else if (choice == 2) {
            
        } else {
            System.out.println("Invalid input");
        }
        scanner.close();
    }
}
