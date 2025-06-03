
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class AllureReportLessonSteps {
    private final static String repository = "java";
    private final static int issue = 3994;

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
