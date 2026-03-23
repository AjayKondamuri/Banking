package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.DTO.TransferAmount;
import com.bank.entity.Bank;
import com.bank.repository.BankRepository;

import jakarta.transaction.Transactional;

@Service
public class BankService {

	@Autowired
	BankRepository repo;
	
	public String createAccount(Bank bank) {
		repo.save(bank);
		return "Account created successfully";
	}
	
	public Bank getAccountbyId(int accId) {
		Optional<Bank> bk= repo.findById(accId);
		return bk.get();
	}
	
	public String checkBalanceById(int accId) {
		Optional<Bank> bank=repo.findById(accId);
		return "Your Account balance is "+bank.get().getBalance();
	}
	
	@Transactional
	public String withdrawAmount(int accId,double amount) {
		Optional<Bank> bank=repo.findById(accId);
		
		if(amount>bank.get().getBalance()) {
			return "Insufficient Balance";
		}
		
		bank.get().setBalance(bank.get().getBalance()-amount);
		return "Withdraw Success!";
		
	}
	
	@Transactional
	public String depositAmount(int accId,double amount) {
		Optional<Bank> bank=repo.findById(accId);
		
		if(bank.get().getAccId()==0) {
			return "invalid accId";
		}
		
		double total=bank.get().getBalance()+amount;
		bank.get().setBalance(total);
		return "amount deposited successfulyy";
	}
	
	@Transactional
	public String transferAmount(TransferAmount transfer) {
		Optional<Bank> bank=repo.findById(transfer.getFromId());
		
		if(bank.get()==null) {
			return "Invalid Account Id";
		}
		
		if(transfer.getAmount()>bank.get().getBalance()) {
			return "Insufficient Balance";
		}
		
		if(transfer.getAmount()<=bank.get().getBalance()) {
			bank.get().setBalance(bank.get().getBalance()-transfer.getAmount());
			Optional<Bank> bk=repo.findById(transfer.getToId());
			bk.get().setBalance(bk.get().getBalance()+transfer.getAmount());
		}
		
		
		return "Transaction successfull";
	}
	
	
	public List<Bank> getAllAccounts(){
		return repo.findAll();
	}
	
}
