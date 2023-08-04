package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/trade")
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/")
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @PostMapping("/")
    public Trade addBook(@Valid @RequestBody Trade trade) {
        return tradeService.addTrade(trade);
    }

    @GetMapping("/{id}")
    public Optional<Trade> getTradeById(@PathVariable(value = "id") long id) {
        return tradeService.getTradeById(id);
    }

}
