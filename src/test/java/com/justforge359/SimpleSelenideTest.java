package com.justforge359;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleSelenideTest extends BaseTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("justforge359")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testIssueSearch(){
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("Justforce359/homework_11");
        $("#query-builder-test").submit();
        $(linkText("Justforce359/homework_11")).click();
        $("#issues-tab").click();
        $(withText("Some issue")).should(exist);
    }
}
