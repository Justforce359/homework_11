package com.justforge359;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открытие главной страницы")
    public void openMainPage () {
        open("https://github.com/");
    }

    @Step("Поиск в репозитории {repo}")
    public void searchForRepository (String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Клик на ссылку на репозиторий {repo}")
    public void clickOnRepositoryLink (String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открытие таб Issue")
    public void openIssueTab () {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия Issue с {issueName}")
    public void shouldSeeIssueWithName (String issueName){
        $(withText(issueName)).should(exist);
    }

}
