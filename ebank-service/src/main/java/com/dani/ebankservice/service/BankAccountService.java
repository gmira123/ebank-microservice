package com.dani.ebankservice.service;

import com.dani.ebankservice.entities.BankAccount;
import com.dani.ebankservice.feign.CustomerRestClient;
import com.dani.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankAccountService {

    final private BankAccountRepository bankAccountRepository;
    final private CustomerRestClient  customerRestClient;

    public BankAccountService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(String  id) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        account.setCustomer(customerRestClient.getCustomerById(account.getCustomerId()));
        return account;
    }

    public BankAccount save(BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }
}
