package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    // we are using all args constructor annotation and in this class we are having single constructor, so we don't need autowire annotation here
    private IAccountService iAccountService;

    // this below api would only work if we remove above consumes variable inside RequestMapping annotation
    /*@GetMapping("/")
    public ResponseEntity<ResponseDto> checkServerRunning() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, "Server is running"));
    }*/

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto){
        boolean isUpdated = iAccountService.updateAccount(customerDto);

        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam String mobileNumber){
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);

        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE));
        }
    }
}