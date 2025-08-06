package com.example.Mini_Banco.domain.port.in;

import java.math.BigDecimal;

public interface TransferMoneyUseCase {
    void transfer(Long fromId, Long toId, BigDecimal amount);
}
