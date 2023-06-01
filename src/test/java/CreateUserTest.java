import checks.UserCreation;
import data.StepData;
import org.testng.annotations.Test;
import step.UserSteps;

import static data.StepData.userBadResponse;
import static data.UserCreateData.*;
import static org.junit.jupiter.api.Assertions.*;


public class CreateUserTest {

    private UserSteps userSteps = new UserSteps();
    private UserCreation userCreation = new UserCreation();

    @Test(description = "Create user", priority = 0)
    public void createUser() {
        userSteps.createUser();
        userCreation.checkUserCreation();
    }

    @Test(description = "Create user and check user in user's list", priority = 0)
    public void createUserAndCheckInList() {
        userSteps.createUser();
        userSteps.getUsersList();
        userCreation.checkUserInList();
    }

    @Test(description = "Create user with empty parameters", priority = 0)
    public void createUserWithEmptyParameters() {
        userSteps.createUserWithCustomParameters("", "", "", 400);
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), USERNAME_IS_REQUIRED)
        );
    }

    @Test(description = "Create user with null parameters", priority = 1)
    public void createUserWithNullParameters() {
        userSteps.createUserWithCustomParameters(null, null, null, 400);
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), USERNAME_IS_REQUIRED)
        );
    }

    @Test(description = "Create user with empty password", priority = 1)
    public void createUserWithEmptyPassword() {
        userSteps.createUserWithEmptyPassword(400);
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), PASSWORD_FOR_USER)
        );
    }

    @Test(description = "Create user with empty email", priority = 1)
    public void createUserWithEmptyEmail() {
        userSteps.createUserWithEmptyEmail(400);
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), EMAIL_IS_REQUIRED)
        );
    }

    @Test(description = "Create user with empty username", priority = 1)
    public void createUserWithEmptyUsername() {
        userSteps.createUserWithEmptyUsername(400);
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), USERNAME_IS_REQUIRED)
        );
    }

    @Test(description = "Create already existing user", priority = 0)
    public void createAlreadyExistingUser() {
        userSteps.createUser();
        userSteps.createUserWithExistingParameters();
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), USERNAME_IS_TAKEN)
        );
    }

    @Test(description = "Create user with already existing username", priority = 0)
    public void createUserWithAlreadyExistingUsername() {
        userSteps.createUser();
        userSteps.createUserWithExistingUsername();
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), USERNAME_IS_TAKEN)
        );
    }

    @Test(description = "Create user with already existing email", priority = 0)
    public void createUserWithAlreadyExistingEmail() {
        userSteps.createUser();
        userSteps.createUserWithExistingEmail();
        assertAll(
                () -> assertEquals(400, StepData.response.statusCode()),
                () -> assertEquals(userBadResponse.message.get(0), EMAIL_ALREADY_EXISTS)
        );
    }

    @Test(description = "Create user with fake fields", priority = 0)
    public void createUserWithFakeFields() {
        userSteps.createUserWithFakeParameters(400);
        //TODO  bug: it's possible to create new user with random id, for example

        // request:
//        {
//                "id": 8799711,
//                "username": "WIUUVKO5LJ@gmail.com",
//                "email": "WIUUVKO5LJ@gmail.com",
//                "password": "+7911Z72QQD2UYK"
//        }

        // response:
//        HTTP/1.1 200 OK
//        Content-Type: application/json; charset=utf-8
//        Content-Length: 287
//        Date: Thu, 01 Jun 2023 20:56:58 GMT
//        Connection: keep-alive
//        Keep-Alive: timeout=5
//        {
//            "success": true,
//                "details": {
//            "username": "WIUUVKO5LJ@gmail.com",
//                    "email": "WIUUVKO5LJ@gmail.com",
//                    "password": "$2a$10$.uLg/Qx.hhQcNgyPW3nisug4s8y0/usLQXrvBG9ekBXQNUmpw7Adi",
//                    "created_at": "2023-06-01 20:56:58",
//                    "updated_at": "2023-06-01 20:56:58",
//                    "id": 8799711
//        },
//            "message": "User Successully created"
//        }
        // and after that numbering is broken !!!
    }


}
