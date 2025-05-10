package com.tanita.petme.eazybank.config.security;

import com.tanita.petme.eazybank.model.Customer;
import com.tanita.petme.eazybank.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public DefaultUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        Collection<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(customer.getRole())
        );

        return new User(customer.getEmail(), customer.getPassword(), authorities);
    }

}
