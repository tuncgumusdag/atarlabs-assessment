package Page;

import Base.Base;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends Base {

    protected String buttonTopSearchResults = ".g-item-sortable:nth-of-type(1) .wl-info-wl_kindle_ov_wfa_button";
    protected String elementThirdPage = "#pagn span:nth-of-type(4)";
    protected String elementItemHeader = "#rightResultsATF .s-result-item:nth-of-type(7) .a-size-medium";
    protected String dataKeyword = "Amazon";

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopSearchResults() {
        click(buttonTopSearchResults);
        //Click Top Search Results button
    }

    public void goThirdPage() {
        click(elementThirdPage);
        //Go to third page
    }

    public void keywordAssertion() {
        assertIsInclude(elementItemHeader, dataKeyword);
        //Assert 7th search result contains searched keyword
    }
}
