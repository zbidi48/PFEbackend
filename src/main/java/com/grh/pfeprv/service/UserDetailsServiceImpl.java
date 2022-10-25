package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.User;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository ;




    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(email).orElseThrow(() ->  new NotFoundException("User not found [email: " + email + "]"));
        return UserDetailsImpl.build(user);
    }
}
