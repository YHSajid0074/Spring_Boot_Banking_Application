package com.example.Banking.Application.Controller;

import com.example.Banking.Application.DTO.AccountDto;
import com.example.Banking.Application.Entity.Account;
import com.example.Banking.Application.Repository.CustomAccountResponseDTO;
import com.example.Banking.Application.Service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {
    AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomAccountResponseDTO> getAccount(@PathVariable int id) {
     return ResponseEntity.ok(accountService.findByAccountId(id));
    }

    @PostMapping("Create")
   public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto) {
     return ResponseEntity.ok(accountService.createAccount(accountDto));
   }
   @PutMapping("{id}")
   public ResponseEntity<Account> updateAccount(@PathVariable int id,@RequestBody AccountDto accountDto) {
       Account account= accountService.updateAccount(id, accountDto);
       return ResponseEntity.ok(account);
   }
   @DeleteMapping("{id}")
   public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
   }
   @GetMapping
   public ResponseEntity<List<CustomAccountResponseDTO>> getAllAccounts() {
      return ResponseEntity.ok(accountService.findAllAccounts());
   }

}

