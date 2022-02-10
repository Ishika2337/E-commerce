package com.ecommerce.WomensDressStore.security;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user=customerRepository.getById(username);
        return new MyUserDetails(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Customer> user = customerRepository.findById(username);
//        user.orElseThrow(()-> new UsernameNotFoundException("Not Found: " + username));
//        return user.map(MyUserDetails::new).get();
//    }
}
