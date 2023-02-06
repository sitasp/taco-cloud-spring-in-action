package com.sage.tacocloudspringinaction.security;

import com.sage.tacocloudspringinaction.UserP;
import com.sage.tacocloudspringinaction.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService  implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepository){
        this.userRepo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        It should not return null
        UserP userP = userRepo.findByUsername(username);
        if(userP != null){
            return userP;
        }
        throw new UsernameNotFoundException("User: '" + username + "' not found");
    }
}
