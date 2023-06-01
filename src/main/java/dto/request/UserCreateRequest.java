package dto.request;

public class UserCreateRequest {
    public String username;
    public String email;
    public String password;

    public UserCreateRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
