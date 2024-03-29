package com.niit.C13_s4_pc1.service;


import com.niit.C13_s4_pc1.domain.Customer;
import com.niit.C13_s4_pc1.exception.CustomerAlreadyExistException;
import com.niit.C13_s4_pc1.exception.CustomerNotFoundException;
import com.niit.C13_s4_pc1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if (customerRepository.findById(customer.getCustomerId()).isEmpty()) {
            return customerRepository.save(customer);
        }
        throw new CustomerAlreadyExistException();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(int id) throws CustomerNotFoundException {
        if (customerRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return "Customer Deleted successfully";
    }

    @Override
    public List<Customer> getCustomerWhoBougthSamsungPhone(String product) {
        return customerRepository.getCustomerWhoBougthSamsungPhone(product);
    }
}
