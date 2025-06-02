package com.ozgur.customerportfolio.dto;

import com.ozgur.customerportfolio.domain.Ticker;
import com.ozgur.customerportfolio.domain.TradeAction;

public record StockTradeResponse(Integer customerId,
                                 Ticker ticker,
                                 Integer price,
                                 Integer quantity,
                                 TradeAction action,
                                 Integer totalPrice,
                                 Integer balance) {
}
