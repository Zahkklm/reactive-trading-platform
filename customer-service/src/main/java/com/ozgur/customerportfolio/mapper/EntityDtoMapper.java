package com.ozgur.customerportfolio.mapper;

import com.ozgur.customerportfolio.domain.Ticker;
import com.ozgur.customerportfolio.dto.CustomerInformation;
import com.ozgur.customerportfolio.dto.Holding;
import com.ozgur.customerportfolio.dto.StockTradeRequest;
import com.ozgur.customerportfolio.dto.StockTradeResponse;
import com.ozgur.customerportfolio.entity.Customer;
import com.ozgur.customerportfolio.entity.PortfolioItem;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerInformation toCustomerInformation(Customer customer, List<PortfolioItem> items) {
        var holdings = items.stream()
                            .map(i -> new Holding(i.getTicker(), i.getQuantity()))
                            .toList();
        return new CustomerInformation(
                customer.getId(),
                customer.getName(),
                customer.getBalance(),
                holdings
        );
    }

    public static PortfolioItem toPortfolioItem(Integer customerId, Ticker ticker){
        var portfolioItem = new PortfolioItem();
        portfolioItem.setCustomerId(customerId);
        portfolioItem.setTicker(ticker);
        portfolioItem.setQuantity(0);
        return portfolioItem;
    }

    public static StockTradeResponse toStockTradeResponse(StockTradeRequest request, Integer customerId, Integer balance){
        return new StockTradeResponse(
                customerId,
                request.ticker(),
                request.price(),
                request.quantity(),
                request.action(),
                request.totalPrice(),
                balance
        );
    }

}
