package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private SelenideElement pageHeader = $("[data-test-id=dashboard]");

    public AccountPage() {

    }

    public void heading() {
        pageHeader.should(Condition.visible)
                .should(Condition.exactText("Личный кабинет"));
    }
}

