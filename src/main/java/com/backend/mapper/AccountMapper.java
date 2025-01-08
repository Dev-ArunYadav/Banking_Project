package com.backend.mapper;

import com.backend.dto.request.AccountCreationRequestDTO;
import com.backend.dto.response.AccountCreationResponseDTO;
import com.backend.entity.Account;
import com.backend.model.AccountCredentials;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Account toEntity(AccountCreationRequestDTO dto);

    @Mapping(source = "account.accountNumber", target = "accountNumber")
    @Mapping(source = "account.accountHolder", target = "accountHolder")
    @Mapping(source = "account.email", target = "email")
    @Mapping(source = "credentials.customerId", target = "customerId")
    @Mapping(source = "credentials.temporaryPassword", target = "temporaryPassword")
    AccountCreationResponseDTO toResponseDTO(Account account, AccountCredentials credentials);
}
