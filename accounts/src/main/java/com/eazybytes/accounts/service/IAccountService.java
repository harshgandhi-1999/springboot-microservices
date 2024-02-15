package com.eazybytes.accounts.service;


import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto - CustomerDto object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Account Detauls based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);
}
