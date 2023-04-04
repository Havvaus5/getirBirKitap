package com.getir.demo.mapper;

import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.model.entity.Customer;
import com.getir.demo.model.entity.CustomerContact;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer map(CustomerDTO customerDTO, CustomerContact customerContact) ;

    CustomerContact maptoContact(CustomerDTO customerDTO);
}
