package com.example.Mini_Banco.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.Mini_Banco.domain.model.Account;
import com.example.Mini_Banco.domain.port.in.TransferMoneyUseCase;
import com.example.Mini_Banco.domain.port.out.LoadAccountPort;
import com.example.Mini_Banco.domain.port.out.SaveAccountPort;

@Service
public class TransferMoneyService implements TransferMoneyUseCase {

    private final LoadAccountPort loadPort;
    private final SaveAccountPort savePort;

    public TransferMoneyService(LoadAccountPort loadPort, SaveAccountPort savePort) {
        this.loadPort = loadPort;
        this.savePort = savePort;
    }

    @Override
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = loadPort.load(fromId);
        Account to = loadPort.load(toId);

        from.withdraw(amount);
        to.deposit(amount);

        savePort.save(from);
        savePort.save(to);
    }

}
