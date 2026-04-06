package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.data.DataHelper;
import ru.netology.sql.data.SQLHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verificationField = $("[data-test-id=code] input");
    private SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public AccountPage validVerification (String authCode) {
        Verification(authCode);
        return new AccountPage();
    }

    public void Verification(String authCode) {
        verificationField.shouldBe(Condition.visible).setValue(authCode);
        verificationButton.click();
    }
}

