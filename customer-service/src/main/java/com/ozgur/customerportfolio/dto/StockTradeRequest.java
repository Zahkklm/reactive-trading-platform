package com.ozgur.customerportfolio.dto;

import com.ozgur.customerportfolio.domain.Ticker;
import com.ozgur.customerportfolio.domain.TradeAction;

public record StockTradeRequest(Ticker ticker,
                                Integer price,
                                Integer quantity,
                                TradeAction action) {

    public Integer totalPrice(){
        return price * quantity;
    }

}
