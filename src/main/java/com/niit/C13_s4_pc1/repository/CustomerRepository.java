package com.niit.C13_s4_pc1.repository;

import com.niit.C13_s4_pc1.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    @Query("{'customerProduct.productName':{$in:['?0']}}")
    public List<Customer> getCustomerWhoBougthSamsungPhone(String product);
}
