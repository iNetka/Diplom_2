package site.stellarburgers.nomoreparties.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import site.stellarburgers.nomoreparties.model.User;

@Data
@AllArgsConstructor
public class AuthUserRequest {
    private String email;
    private String password;

    public AuthUserRequest() {
    }

//    public AuthUserRequest(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

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

