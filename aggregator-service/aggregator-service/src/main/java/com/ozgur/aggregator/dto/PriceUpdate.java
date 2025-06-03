package com.ozgur.aggregator.dto;

import com.ozgur.aggregator.domain.Ticker;

import java.time.LocalDateTime;

public record PriceUpdate(Ticker ticker,
                          Integer price,
                          LocalDateTime time) {
}
