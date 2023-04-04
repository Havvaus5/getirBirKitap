package com.getir.demo.service.impl;

import com.getir.demo.exception.GetirException;
import com.getir.demo.mapper.CustomerMapper;
import com.getir.demo.model.dto.CustomerDTO;
import com.getir.demo.model.entity.Customer;
import com.getir.demo.model.entity.CustomerContact;
import com.getir.demo.repository.CustomerContactRepository;
import com.getir.demo.repository.CustomerRepository;
import com.getir.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final CustomerContactRepository customerContactRepository;

    @Override
    public String save(CustomerDTO customerDTO) {
        CustomerContact customerContact = customerMapper.maptoContact(customerDTO);
        customerContact = customerContactRepository.save(customerContact);

        Customer customer = customerMapper.map(customerDTO, customerContact);
        customer = customerRepository.save(customer);
        return String.format("Müşteri %s id ile sisteme kaydedilmiştir.", customer.getId());
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        optionalCustomer.orElseThrow(() -> new GetirException("Müşteri kaydı bulunamadı"));
        return optionalCustomer.get();
    }
}
