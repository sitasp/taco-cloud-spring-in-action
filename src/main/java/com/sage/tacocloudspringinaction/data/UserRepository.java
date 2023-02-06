package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.UserP;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserP, Long> {

    UserP findByUsername(String username);
}
