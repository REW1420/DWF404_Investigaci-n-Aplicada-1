package com.example.Mini_Banco.domain.port.out;

import com.example.Mini_Banco.domain.model.Account;

public interface SaveAccountPort {
    void save(Account account);
}