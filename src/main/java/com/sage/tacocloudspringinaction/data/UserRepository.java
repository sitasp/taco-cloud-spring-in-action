package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
