package data;

import dto.response.UserBadResponse;
import dto.response.UserCreateResponse;
import dto.response.Users;
import io.restassured.response.Response;

import java.util.List;

public class StepData {

    public static Response response;
    public static String phone;
    public static String password;
    public static String email;
    public static String username;
    public static UserCreateResponse userCreateResponse;
    public static List<Users> userList;
    public static UserBadResponse userBadResponse;

}
