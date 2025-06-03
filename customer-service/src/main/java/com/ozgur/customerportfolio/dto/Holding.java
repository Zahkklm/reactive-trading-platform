package com.ozgur.customerportfolio.dto;

import com.ozgur.customerportfolio.domain.Ticker;

public record Holding(Ticker ticker,
                      Integer quantity) {
}
