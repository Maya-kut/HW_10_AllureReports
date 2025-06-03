import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    private final static String repository = "java";
    private final static int issue = 30;
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        {
            $(".search-input").click();
            $("#query-builder-test").setValue(repository).pressEnter();
        }
    }

    @Step("Кликаем по ссылке репозитория {repository")
    public void clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWitNumber(int issue) {
        $(withText(String.valueOf(issue))).should(Condition.exist);
    }

}
