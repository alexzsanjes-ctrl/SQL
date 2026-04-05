package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.data.SQLHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verificationField = $("[data-test-id=code] input");
    private SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public AccountPage validVerification() {
        verificationField.shouldBe(Condition.visible, Duration.ofSeconds(5))
                .setValue(SQLHelper.getCode().getCode());
        verificationButton.click();
        return new AccountPage();
    }
}

