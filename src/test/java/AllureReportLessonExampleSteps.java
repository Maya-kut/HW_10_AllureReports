import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureReportLessonExampleSteps {
    private final static String repository = "java";
    private final static int issue = 30;

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий " + repository, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(repository).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + repository, () -> {
            $(linkText("kubernetes-client/java")).click();
        });
        step("Открываем Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + issue, () -> {
            $(withText(String.valueOf(issue))).should(Condition.exist);
        });
    }
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchRepository(repository);
        webSteps.clickOnRepositoryLink(repository);
        webSteps.openIssueTab();
        webSteps.shouldSeeIssueWitNumber(issue);
    }
}
