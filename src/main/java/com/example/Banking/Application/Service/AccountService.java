package com.example.Banking.Application.Service;

import com.example.Banking.Application.DTO.AccountDto;
import com.example.Banking.Application.Entity.Account;
import com.example.Banking.Application.Exception.AccountNumberDuplicateException;
import com.example.Banking.Application.Repository.AccountRepo;
import com.example.Banking.Application.Repository.CustomAccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    AccountRepo accountRepo;
    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    public Account createAccount(AccountDto accountdto) {
        Account a= new Account();
        Account b=accountRepo.findByAccountNumber(accountdto.accountNumber());
        if(b!=null){
            throw new AccountNumberDuplicateException("Account number already exists");
        }else {
            a.setAccountNumber(accountdto.accountNumber());
        }
        a.setBalance(accountdto.balance());
        a.setAccountHolderName(accountdto.AccountHolderName());
        return accountRepo.save(a);

    }
    public List<CustomAccountResponseDTO> findAllAccounts() {
        return accountRepo.findAllAccount();
    }
public CustomAccountResponseDTO findByAccountId(int id) {
        return accountRepo.findByAccountId(id);

}

    public Account updateAccount(int id,AccountDto accountdto) {
       Account a=accountRepo.findById( id).get();
     a.setAccountNumber(accountdto.accountNumber());
     a.setBalance(accountdto.balance());
     a.setAccountHolderName(accountdto.AccountHolderName());
     return accountRepo.save(a);
    }

    public void deleteAccount(int id) {
accountRepo.deleteById(id);
    }
}
