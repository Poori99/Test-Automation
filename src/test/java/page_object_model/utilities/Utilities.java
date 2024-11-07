package page_object_model.utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Utilities {
    protected BrowserFactory browserFactory;

    @BeforeTest
    public void initializebrowser() {
        browserFactory = BrowserFactory.getBrowserFactory();
    }

    @AfterTest
    public void closeBrowser() {
        browserFactory.getDriver().quit();
    }
}
