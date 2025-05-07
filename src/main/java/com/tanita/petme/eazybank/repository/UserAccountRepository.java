package com.tanita.petme.eazybank.repository;

import com.tanita.petme.eazybank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

}
