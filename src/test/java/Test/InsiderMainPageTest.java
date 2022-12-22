package Test;

import Pages.DefaultPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InsiderMainPageTest extends BaseTest{
    @Test (priority = 1)
    public void insidermainpagecheck (){
        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.goToPage("https://useinsider.com/");
        String url = driver.getCurrentUrl();
        assertEquals("https://useinsider.com/", url);
    }

}
