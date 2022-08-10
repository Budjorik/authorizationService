package ru.netology.authorizationservice.repository;

import ru.netology.authorizationservice.enumeration.Authorities;
import ru.netology.authorizationservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    public ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("Ivan", new User("Ivan", "111",
                List.of(Authorities.READ, Authorities.WRITE)));
        users.put("Olga", new User("Olga", "777",
                List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("Petr", new User("Petr", "000",
                null));
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUser())) {
            System.out.println("Ошибка: токой пользователь уже существует!");
        } else {
            users.put(user.getUser(), user);
            System.out.println("Пользователь успешно добавлен!");
        }
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user)) {
            if (users.get(user).getPassword().equals(password)) {
                return users.get(user).getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}
