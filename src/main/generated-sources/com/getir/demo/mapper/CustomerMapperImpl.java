package com.getir.demo.mapper;

import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.model.entity.Customer;
import com.getir.demo.model.entity.CustomerContact;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer map(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDTO.getName() );
        customer.setSurname( customerDTO.getSurname() );

        return customer;
    }

    @Override
    public CustomerContact maptoContact(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        CustomerContact customerContact = new CustomerContact();

        customerContact.setEmail( customerDTO.getEmail() );
        customerContact.setPhoneNumber( customerDTO.getPhoneNumber() );
        customerContact.setAdres( customerDTO.getAdres() );

        return customerContact;
    }
}
