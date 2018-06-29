package Tests;

import Base.Base;
import Page.ResultsPage;
import org.testng.annotations.Test;

public class ResultsPageTest extends Base {

    @Test
    public void resultPageTest() {
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.clickTopSearchResults();
        resultsPage.goThirdPage();
        resultsPage.keywordAssertion();
    }
}
