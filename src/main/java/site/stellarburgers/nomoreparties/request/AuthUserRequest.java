package site.stellarburgers.nomoreparties.request;

import site.stellarburgers.nomoreparties.User;

public class AuthUserRequest {
    private String email;
    private String password;

    public AuthUserRequest() {
    }

    public AuthUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthUserRequest(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

