package com.ozgur.aggregator.dto;

import com.ozgur.aggregator.domain.Ticker;

public record StockPriceResponse(Ticker ticker,
                                 Integer price) {
}
