package com.abnamro.stubs;

public class User {
    private String userName;
    private String password;
    private String userId;
    private String[] books;

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String[] books() {
        return books;
    }

    public void setBooks (String[] newBooks) {
        this.books = newBooks;
    }

    public void setUserId(String newUserId) {
        this.userId = newUserId;
    }

    public void setUsername(String newUsername) {
        this.userName = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public User(String userName, String password) {
        setUsername(userName);
        setPassword(password);
    }
}
