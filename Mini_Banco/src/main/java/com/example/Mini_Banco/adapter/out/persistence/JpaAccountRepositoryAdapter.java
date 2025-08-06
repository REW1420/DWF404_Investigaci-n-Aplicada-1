package com.example.Mini_Banco.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.example.Mini_Banco.domain.model.Account;
import com.example.Mini_Banco.domain.port.out.LoadAccountPort;
import com.example.Mini_Banco.domain.port.out.SaveAccountPort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JpaAccountRepositoryAdapter implements LoadAccountPort, SaveAccountPort {

    private final Map<Long, Account> database = new HashMap<>();

    public JpaAccountRepositoryAdapter() {
        database.put(1L, new Account(1L, new BigDecimal("1000")));
        database.put(2L, new Account(2L, new BigDecimal("500")));
    }

    @Override
    public Account load(Long id) {
        return database.get(id);
    }

    @Override
    public void save(Account account) {
        database.put(account.getId(), account);
    }
}
