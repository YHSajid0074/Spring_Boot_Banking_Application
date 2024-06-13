package com.example.Banking.Application.DTO;

import java.math.BigDecimal;

public record AccountDto(int id,
                         String accountNumber,
                         String AccountHolderName,
                         BigDecimal balance) {
}
