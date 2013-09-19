package com.twu.biblioteca;

import java.util.HashMap;

public class UserAccounts {
    private HashMap<String, String> usernameAndPassword;
    private HashMap<String, String> usernameAndInformation;

    public UserAccounts() {
        usernameAndPassword = new HashMap<String, String>();
        usernameAndInformation = new HashMap<String, String>();
        usernameAndPassword.put("111-1111", "1");
        usernameAndPassword.put("111-1112", "2");
        usernameAndPassword.put("111-1113", "3");
        usernameAndInformation.put("111-1111", "Name:Ash Phone:919 423 3888 email:tt@gmail.com");
        usernameAndInformation.put("111-1112", "Name:Don Phone:918 423 3888 email:tq@gmail.com");
        usernameAndInformation.put("111-1113", "Name:Melina Phone:917 423 3888 email:tp@gmail.com");
    }

    public boolean checkLoginDetails(String username, String password) {
        if (usernameAndPassword.containsKey(username) && usernameAndPassword.containsValue(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void displayMembershipDetails(String username, String password) {
        if (checkLoginDetails(username, password)) {
            System.out.println(usernameAndInformation.get(username));
        } else {
            System.out.println("Please talk to a Librarian. Thank you.");
        }
    }

}