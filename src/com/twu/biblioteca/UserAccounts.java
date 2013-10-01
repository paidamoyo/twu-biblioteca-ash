package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

public class UserAccounts {
    private HashMap<String, String> usernameAndPassword;
    private HashMap<String, String> usernameAndInformation;
    private PrintStream printStream;

    public UserAccounts(PrintStream printStream) {
        this.printStream = printStream;
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
        return usernameAndPassword.containsKey(username) && usernameAndPassword.containsValue(password);
    }

    public void displayMembershipDetails(String username) throws IOException {
        printStream.println(usernameAndInformation.get(username));
    }
}
