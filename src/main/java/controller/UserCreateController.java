package controller;

import constant.endpoint.BaseUrl;
import dto.request.FakeUserCreateRequest;
import dto.request.UserCreateRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserCreateController {

    public Response callPostUserCreate(UserCreateRequest body, int statusCode) {
        baseURI = BaseUrl.BASE_URL;
        return given().given()
                .cookie(baseURI)
                .urlEncodingEnabled(true)
                .header("Accept", JSON.getAcceptHeader())
                .contentType(JSON)
                .log().all()
                .body(body)
                .post(BaseUrl.POST_CREATE_USER)
                .then().statusCode(statusCode)
                .assertThat()
                .log().all()
                .extract().response();
    }

    public Response callGetUserList() {
        baseURI = BaseUrl.BASE_URL;
        return given().given()
                .urlEncodingEnabled(true)
                .header("Accept", JSON.getAcceptHeader())
                .get(baseURI + "/" + BaseUrl.GET_USERS)
                .then().statusCode(200)
                .assertThat()
                .log().all()
                .extract().response();
    }

    public Response callPostFakeUserCreate(FakeUserCreateRequest body, int statusCode) {
        baseURI = BaseUrl.BASE_URL;
        return given().given()
                .cookie(baseURI)
                .urlEncodingEnabled(true)
                .header("Accept", JSON.getAcceptHeader())
                .contentType(JSON)
                .log().all()
                .body(body)
                .post(BaseUrl.POST_CREATE_USER)
                .then().statusCode(statusCode)
                .assertThat()
                .log().all()
                .extract().response();
    }
}
