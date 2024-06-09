package com.eazybytes.accounts.functions;

import com.eazybytes.accounts.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountsFunctions {

    private static final Logger log = LoggerFactory.getLogger(AccountsFunctions.class);

    // This is a consumer which accepts data of type Long and doesn't produce any ouput.
    // accountsService will be injected auto while runtime.
    // when the exchange send the data this consumer will accept it and process according to that.
    @Bean
    public Consumer<Long> updateCommunication(IAccountService accountsService) {
        return accountNumber -> {
            log.info("Updating Communication status for the account number : " + accountNumber.toString());
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }

}