package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account Information"
)
public class AccountsDto {

    @Schema(
            description = "Account Number of Customer Bank Account",
            example = "235434635735"
    )
    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account Type of Customer Bank Account",
            example = "Savings"
    )
    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @Schema(
            description = "Bank Branch Address",
            example = "123, abc, def"
    )
    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;
}
