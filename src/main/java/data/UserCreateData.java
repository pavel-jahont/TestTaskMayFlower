package data;

public interface UserCreateData {

    String USER_SUCCESSFULLY_CREATED = "User Successully created"; // TODO - bug: it's correct to text "successfully" but not "Successully"
    String USERNAME_IS_REQUIRED = "A username is required";
    String PASSWORD_FOR_USER = "A password for the user"; // TODO - bug: should be text "A password is required"
    String EMAIL_IS_REQUIRED = "An Email is required";
    String USERNAME_IS_TAKEN = "This username is taken. Try another.";
    String EMAIL_ALREADY_EXISTS = "Email already exists";
}
