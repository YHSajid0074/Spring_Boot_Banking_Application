package com.example.Banking.Application.Repository;

/**
 * Projection for {@link com.example.Banking.Application.Entity.Account}
 */
public interface CustomAccountResponseDTO {
    String getAccountHolderName();

    double getBalance();
}