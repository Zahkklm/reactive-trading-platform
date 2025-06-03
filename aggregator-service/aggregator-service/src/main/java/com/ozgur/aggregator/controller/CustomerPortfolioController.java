package com.ozgur.aggregator.controller;

import com.ozgur.aggregator.dto.CustomerInformation;
import com.ozgur.aggregator.dto.StockTradeResponse;
import com.ozgur.aggregator.dto.TradeRequest;
import com.ozgur.aggregator.service.CustomerPortfolioService;
import com.ozgur.aggregator.validator.RequestValidator;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CustomerPortfolioController {

    private final CustomerPortfolioService customerPortfolioService;

    public CustomerPortfolioController(CustomerPortfolioService customerPortfolioService) {
        this.customerPortfolioService = customerPortfolioService;
    }

    @GetMapping("/{customerId}")
    public Mono<CustomerInformation> getCustomerInformation(@PathVariable Integer customerId) {
        return this.customerPortfolioService.getCustomerInformation(customerId);
    }

    @PostMapping("/{customerId}/trade")
    public Mono<StockTradeResponse> trade(@PathVariable Integer customerId, @RequestBody Mono<TradeRequest> mono) {
        return mono.transform(RequestValidator.validate())
                   .flatMap(req -> this.customerPortfolioService.trade(customerId, req));
    }

}
