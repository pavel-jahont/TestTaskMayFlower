package step;

import controller.UserCreateController;
import data.StepData;
import dto.request.FakeUserCreateRequest;
import dto.request.UserCreateRequest;
import dto.response.*;
import util.RandomGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import static data.StepData.*;

public class UserSteps {

    private UserCreateController userController = new UserCreateController();
    private RandomGenerator randomGenerator = new RandomGenerator();
    private ObjectMapper mapper = new ObjectMapper();

    public void createUser() {
        StepData.response = userController.callPostUserCreate(createRandomUser(), 200);
        StepData.userCreateResponse = response.as(UserCreateResponse.class);
    }

    public void createUserWithExistingParameters() {
        StepData.response = userController.callPostUserCreate(new UserCreateRequest(username, email, password), 400);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithExistingUsername() {
        StepData.response = userController.callPostUserCreate(
                new UserCreateRequest(username, randomGenerator.generateEmail(), randomGenerator.generatePassword()), 400);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithExistingEmail() {
        StepData.response = userController.callPostUserCreate(
                new UserCreateRequest(randomGenerator.generateName(), email, randomGenerator.generatePassword()), 400);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void getUsersList() {
        StepData.response = userController.callGetUserList();
        StepData.userList = Arrays.asList(response.getBody().as(Users[].class));
    }

    public void createUserWithCustomParameters(String userName, String email, String password, int statusCode) {
        StepData.response = userController.callPostUserCreate(new UserCreateRequest(userName, email, password), statusCode);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithEmptyPassword(int statusCode) {
        username = randomGenerator.generateName();
        email = randomGenerator.generateEmail();
        StepData.response = userController.callPostUserCreate(
                new UserCreateRequest(username, email, ""), statusCode);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithEmptyEmail(int statusCode) {
        username = randomGenerator.generateName();
        password = randomGenerator.generatePassword();
        StepData.response = userController.callPostUserCreate(
                new UserCreateRequest(username, "", password), statusCode);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithEmptyUsername(int statusCode) {
        email = randomGenerator.generateEmail();
        password = randomGenerator.generatePassword();
        StepData.response = userController.callPostUserCreate(
                new UserCreateRequest("", email, password), statusCode);
        StepData.userBadResponse = response.as(UserBadResponse.class);
    }

    public void createUserWithFakeParameters(int statusCode) {
        int id = Integer.valueOf(randomGenerator.getRandomNumber(7));
        email = randomGenerator.generateEmail();
        password = randomGenerator.generatePassword();
        username = randomGenerator.generateName();
        StepData.response = userController.callPostFakeUserCreate(
                new FakeUserCreateRequest(id, email, email, password), statusCode);
        StepData.userBadResponse = response.as(UserBadResponse.class);

    }

    public UserCreateRequest createRandomUser() {
        password = randomGenerator.generatePassword();
        email = randomGenerator.generateEmail();
        username = randomGenerator.generateName();
        UserCreateRequest userCreateRequest = new UserCreateRequest(username, email, password);
        return userCreateRequest;
    }

}
