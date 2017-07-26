package io.icednut.spring.exercise;

import io.icednut.spring.exercise.user.UserDTO;
import io.icednut.spring.exercise.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"applicationContext.xml"})
public class UserServiceClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);

        UserService userService = (UserService) applicationContext.getBean("userService");
        UserDTO dto = new UserDTO();
        dto.setId("test");
        dto.setPassword("test123");

        UserDTO user = userService.getUser(dto);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다.");
        } else {
            System.out.println("로그인 실패");
        }
    }
}
