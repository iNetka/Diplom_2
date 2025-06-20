package site.stellarburgers.nomoreparties.model.request;

import site.stellarburgers.nomoreparties.model.User;

public class UpdateUserRequest {
    private String name;
    private String email;
    private String password;
    private String accessToken;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String name, String email, String password, String accessToken) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessToken = accessToken;
    }

    public UpdateUserRequest(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.accessToken = user.getAccessToken();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
