package com.example.Banking.Application.Repository;

import com.example.Banking.Application.DTO.AccountDto;
import com.example.Banking.Application.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    @Query("""
         SELECT
                account
            FROM Account account
        """)
    List<CustomAccountResponseDTO> findAllAccount();
    @Query("""
         SELECT
                account
            FROM Account account where account.id=:id
        """)
    CustomAccountResponseDTO findByAccountId(int id);

    @Query(nativeQuery = true, value =   "SELECT " +
                                         "* " +
                                         "FROM account" +
                                         " WHERE account_number = :accountNumber")
    Account findByAccountNumber(@Param("accountNumber") String accountNumber);
}
