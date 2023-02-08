package webserver.controller;

import db.UserStorage;
import java.util.Map;
import model.MyHttpRequest;
import model.MyHttpResponse;
import model.User;
import org.springframework.http.HttpStatus;
import webserver.Controller;

public class UserSaveController implements Controller {

    @Override
    public String process(MyHttpRequest httpRequest, MyHttpResponse httpResponse) {
        Map<String, String> userInfo = httpRequest.getBody();

        User user = new User(userInfo.get("userId"), userInfo.get("password"), userInfo.get("name"),
                userInfo.get("email"));
        UserStorage.addUser(user);
        httpResponse.setStatus(HttpStatus.FOUND);
        httpResponse.setLocation("/index.html");

        return "";
    }
}
