package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a word to use for demonstrating url parameters");
        Client.basicGetRequest(new Scanner(System.in).nextLine().strip());
        Client.checkForUpdate();
        Client.fetchUpdate();
    }
}
