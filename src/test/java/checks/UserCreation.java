package checks;

import data.StepData;
import data.UserCreateData;
import dto.response.Users;

import static data.StepData.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserCreation {

    public void checkUserCreation() {
        assertAll(
                () -> assertEquals(userCreateResponse.message, UserCreateData.USER_SUCCESSFULLY_CREATED),
                () -> assertEquals(200, StepData.response.statusCode()),
                () -> assertEquals(userCreateResponse.details.username, StepData.username),
                () -> assertEquals(userCreateResponse.details.email, StepData.email),
                () -> assertEquals(userCreateResponse.success, Boolean.TRUE),
                () -> assertNotNull(userCreateResponse.details.id)
        );
    }

    public void checkUserInList() {
        Integer createdUser = userCreateResponse.details.id;
        boolean result = false;
        for (Users user : userList) {
            if (user.id == createdUser) {
                assertAll(
                        () -> assertEquals(user.username, userCreateResponse.details.username),
                        () -> assertEquals(user.email, userCreateResponse.details.email),
                        () -> assertEquals(user.password, userCreateResponse.details.password),
                        () -> assertEquals(user.created_at, userCreateResponse.details.created_at),
                        () -> assertEquals(user.updated_at, userCreateResponse.details.updated_at),
                        () -> assertEquals(user.id, userCreateResponse.details.id)
                );
                result = true;
                break;
            }
        }
        assertTrue(result, "User didn't find");
    }
}
