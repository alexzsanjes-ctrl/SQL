package ru.netology.sql.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.sql.data.DataHelper;
import ru.netology.sql.data.SQLHelper;
import ru.netology.sql.page.AccountPage;
import ru.netology.sql.page.LoginPage;
import ru.netology.sql.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

//    @BeforeAll
//    static void setupAll() {
//        Configuration.browser = "firefox";
//        Configuration.holdBrowserOpen = false;
//    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void cleanTables() {
        SQLHelper.cleanAuthCodesTable();
        SQLHelper.cleanAuthCardsTable();
        SQLHelper.cleanUsersTable();
    }

    @Test
    void ShouldSuccessAuthorisation() {
        var loginPage = new LoginPage();
        var verificationPage = loginPage.validLogin(DataHelper.getPassword());
        var AccountPage = verificationPage.validVerification();
        AccountPage.heading();
    }
}
