package com.study.integration.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.ArrayList;

@Controller
public class UserQueryResolver {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("1", "Alice", "alice@example.com"));
        users.add(new User("2", "Bob", "bob@example.com"));
    }

    @QueryMapping
    public User getUser(@Argument String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return users;
    }
}

