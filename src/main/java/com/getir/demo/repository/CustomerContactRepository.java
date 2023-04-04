package com.getir.demo.repository;

import com.getir.demo.model.entity.Customer;
import com.getir.demo.model.entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {
}
