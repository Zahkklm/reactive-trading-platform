package com.ozgur.aggregator.dto;

import com.ozgur.aggregator.domain.Ticker;
import com.ozgur.aggregator.domain.TradeAction;

public record StockTradeResponse(Integer customerId,
                                 Ticker ticker,
                                 Integer price,
                                 Integer quantity,
                                 TradeAction action,
                                 Integer totalPrice,
                                 Integer balance) {
}
