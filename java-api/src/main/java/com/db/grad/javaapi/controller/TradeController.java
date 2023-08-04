package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {
    private final TradeServiceImpl tradeServiceImpl;

    @Autowired
    public TradeController(final TradeServiceImpl tradeServiceImpl) {
        this.tradeServiceImpl = tradeServiceImpl;
    }


    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeServiceImpl.findAllTrades();
    }
}