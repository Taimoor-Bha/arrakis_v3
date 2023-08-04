package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Trade addTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Optional<Trade> getTradeById(long id) {
        return tradeRepository.findById(id);
    }




}
