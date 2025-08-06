package com.example.Mini_Banco.adapter.in.web;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mini_Banco.domain.model.Account;
import com.example.Mini_Banco.domain.port.in.TransferMoneyUseCase;
import com.example.Mini_Banco.domain.port.out.LoadAccountPort;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final TransferMoneyUseCase transferService;
    private final LoadAccountPort loadAccountPort;

    public AccountController(TransferMoneyUseCase transferService, LoadAccountPort loadAccountPort) {
        this.transferService = transferService;
        this.loadAccountPort = loadAccountPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id) {
        Account account = loadAccountPort.load(id);
        return ResponseEntity.ok(new AccountResponse(account.getId(), account.getBalance()));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest req) {
        transferService.transfer(req.fromId(), req.toId(), req.amount());
        return ResponseEntity.ok("Transferencia exitosa");
    }
}

record TransferRequest(Long fromId, Long toId, BigDecimal amount) {
}

record AccountResponse(Long id, BigDecimal balance) {
}
