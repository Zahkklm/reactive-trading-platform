package com.ozgur.aggregator.dto;

import com.ozgur.aggregator.domain.Ticker;
import com.ozgur.aggregator.domain.TradeAction;

public record TradeRequest(Ticker ticker,
                           TradeAction action,
                           Integer quantity) {
}
