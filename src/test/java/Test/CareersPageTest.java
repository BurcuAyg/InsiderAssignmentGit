package Test;
import Pages.CareersPage;
import Pages.DefaultPage;
import Pages.InsiderMainPage;
import Pages.QalityAssurancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CareersPageTest extends BaseTest {

    @Test (priority=2)
    public void careersPageCheck () {
        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.goToPage("https://useinsider.com/");
        InsiderMainPage insiderMainPage = new InsiderMainPage(driver);
        insiderMainPage.gotoCareerPage();
        Assert.assertTrue(driver.getPageSource().contains("New York"));
        Assert.assertTrue(driver.getPageSource().contains("Life at Insider"));
    }

    @Test (priority=3)
    public void fiterTurkeyQualityAssuranceJobs () throws InterruptedException {
        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.goToPage("https://useinsider.com/");
        InsiderMainPage insiderMainPage = new InsiderMainPage(driver);
        insiderMainPage.gotoCareerPage();
        CareersPage careersPage = new CareersPage(driver);
        careersPage.gotoQaPage();
        Thread.sleep(1500);
        QalityAssurancePage qalityAssurancePage = new QalityAssurancePage(driver);
        qalityAssurancePage.fiterQaJobs();
        qalityAssurancePage.checkAllJobContainQA();
        qalityAssurancePage.checkAllJobContainIstanbulTurkey();

    }

}
