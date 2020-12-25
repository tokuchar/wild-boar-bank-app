package com.boar.api;

import com.boar.model.AccountType;
import com.boar.model.Currency;
import com.boar.model.dao.AccountClient;
import com.boar.model.dao.BankCard;
import com.boar.service.AccountService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountApiTest {

    @MockBean
    private AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /account success")
    void getAccountTestSuccess() throws Exception {
        Set<BankCard> bankCard = new HashSet<>();
        AccountClient accountClient1 = new AccountClient(1l, "120", "124", "20.00", "3.00", LocalDate.now(), AccountType.CURRENT, Currency.AUD, bankCard);
        AccountClient accountClient2 = new AccountClient(2l, "1210", "11", "20.00", "3.00", LocalDate.now(), AccountType.CURRENT, Currency.AUD, bankCard);
        doReturn(Lists.newArrayList(accountClient1, accountClient2)).when(accountService).getAccount(1l);

/*
        mockMvc.perform(get("/rest/widgets"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
*/
    }

}
