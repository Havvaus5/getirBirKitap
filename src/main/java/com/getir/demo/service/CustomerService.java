package com.getir.demo.service;

import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.model.entity.Customer;

public interface CustomerService {
    String save(CustomerDTO customerDTO);

    Customer getCustomerById(Long id);

}
