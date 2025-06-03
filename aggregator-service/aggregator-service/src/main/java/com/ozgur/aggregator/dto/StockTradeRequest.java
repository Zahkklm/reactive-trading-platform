package com.ozgur.aggregator.dto;


import com.ozgur.aggregator.domain.Ticker;
import com.ozgur.aggregator.domain.TradeAction;

public record StockTradeRequest(Ticker ticker,
                                Integer price,
                                Integer quantity,
                                TradeAction action) {

}
