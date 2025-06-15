package site.stellarburgers.nomoreparties.request;

import site.stellarburgers.nomoreparties.User;

public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RegisterUserRequest(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
