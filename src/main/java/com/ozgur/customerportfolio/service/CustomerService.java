package com.ozgur.customerportfolio.service;

import com.ozgur.customerportfolio.dto.CustomerInformation;
import com.ozgur.customerportfolio.entity.Customer;
import com.ozgur.customerportfolio.exceptions.ApplicationExceptions;
import com.ozgur.customerportfolio.mapper.EntityDtoMapper;
import com.ozgur.customerportfolio.repository.CustomerRepository;
import com.ozgur.customerportfolio.repository.PortfolioItemRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PortfolioItemRepository portfolioItemRepository;

    public CustomerService(CustomerRepository customerRepository, PortfolioItemRepository portfolioItemRepository) {
        this.customerRepository = customerRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public Mono<CustomerInformation> getCustomerInformation(Integer customerId) {
        return this.customerRepository.findById(customerId)
                                      .switchIfEmpty(ApplicationExceptions.customerNotFound(customerId))
                                      .flatMap(this::buildCustomerInformation);
    }

    private Mono<CustomerInformation> buildCustomerInformation(Customer customer) {
        return this.portfolioItemRepository.findAllByCustomerId(customer.getId())
                                           .collectList()
                                           .map(list -> EntityDtoMapper.toCustomerInformation(customer, list));
    }

}
