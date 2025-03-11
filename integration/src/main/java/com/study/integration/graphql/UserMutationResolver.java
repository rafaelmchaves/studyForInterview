package com.study.integration.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {
    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        User newUser = new User(String.valueOf(System.currentTimeMillis()), name, email);
        UserQueryResolver.users.add(newUser);
        return newUser;
    }
}
