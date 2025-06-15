package site.stellarburgers.nomoreparties;

public class User {

    private String name;
    private String email;
    private String password;
    private String accessToken;
    private String refreshToken;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String accessToken, String refreshToken) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public User(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.accessToken = user.getAccessToken();
        this.refreshToken = user.getRefreshToken();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
