package com.ozgur.aggregator.dto;


import com.ozgur.aggregator.domain.Ticker;

public record Holding(Ticker ticker,
                      Integer quantity) {
}
