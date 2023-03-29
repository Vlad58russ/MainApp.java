package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",
                new Car("Model1", 1)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",
                new Car("Model2", 2)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",
                new Car("Model3", 3)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru",
                new Car("Model4", 4)));
        userService.add(new User("User5", "Lastname5", "user5@mail.ru",
                new Car("Model5", 5)));
        userService.add(new User("User6", "Lastname6", "user6@mail.ru",
                new Car("Model6", 6)));
        userService.add(new User("User7", "Lastname7", "user7@mail.ru",
                new Car("Model7", 7)));
        userService.add(new User("User8", "Lastname8", "user8@mail.ru",
                new Car("Model8", 8)));
        userService.add(new User("User9", "Lastname9", "user9@mail.ru",
                new Car("Model9", 9)));
        userService.add(new User("User10", "Lastname10", "user10@mail.ru",
                new Car("Model10", 10)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model = " + user.getCar());
            System.out.println();
        }

        User user = userService.userCar("Model10", 10);
        System.out.println(user);
        context.close();

    }
}