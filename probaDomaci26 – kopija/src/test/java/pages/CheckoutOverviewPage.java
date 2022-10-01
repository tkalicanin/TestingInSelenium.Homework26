package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.time.Duration;

public class CheckoutOverviewPage extends BasePage {

    private By paymentInfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]");
    private By shippingInfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");
    private By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By finishButton = By.xpath("//*[@id=\"finish\"]");
    private By checkoutCompleteTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
            //("//*[@id=\"header_container\"]/div[2]/span");
    ////*[@id="header_container"]/div[2]/span

    public CheckoutOverviewPage (WebDriver driver) {
        super(driver);
    }

    public WebElement getPaymentInfo () {
        return getDriver().findElement(paymentInfo);
    }

    public WebElement getShippingInfo () {
        return getDriver().findElement(shippingInfo);
    }

    public WebElement getTotal () {
        return getDriver().findElement(total);
    }

    public WebElement getFinishButton () {
        return getDriver().findElement(finishButton);
    }

    public WebElement getCheckoutCompleteTitle () {
        return getDriver().findElement(checkoutCompleteTitle);
    }

    public void clickOnFinishButton () {
        getFinishButton().isDisplayed();
        getFinishButton().click();

    }

}
