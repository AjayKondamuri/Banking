package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.DTO.TransferAmount;
import com.bank.entity.Bank;
import com.bank.service.BankService;

@RestController
public class BankController {

	@Autowired
	BankService service;
	
	@PostMapping("/account")
	public String createAccount(@RequestBody Bank bank) {
		
		return service.createAccount(bank);
		
	}
	
	@GetMapping("/getAccountDetailsbyId/{accId}")
	public Bank getAccountbyId(@PathVariable int accId) {
		
		return service.getAccountbyId(accId);
		
	}
	
	@GetMapping("/checkBalanceById/{accId}")
	public String checkBalanceById(@PathVariable int accId) {
	    return service.checkBalanceById(accId);
	
	}
	
	@GetMapping("/withdrawAmount/{accId}/{amount}")
	public String withdrawAmount(@PathVariable int accId,@PathVariable double amount) {
		return service.withdrawAmount(accId,amount);
	}
	
	@PutMapping("/deposit/{accId}/{amount}")
	public String depositAmount(@PathVariable int accId,@PathVariable double amount) {
		return service.depositAmount(accId,amount);
	}
	
	@PostMapping("/transferAmount")
	public String transferAmount(@RequestBody TransferAmount transfer) {
		return service.transferAmount(transfer);
	}
	
	@GetMapping("/getAllAccounts")
	public List<Bank> getAllAccounts(){
		return service.getAllAccounts();
	}
	
	
}
