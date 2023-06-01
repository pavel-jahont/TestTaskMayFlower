package dto.request;

public class FakeUserCreateRequest {
    public int id;
    public String username;
    public String email;
    public String password;

    public FakeUserCreateRequest(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
