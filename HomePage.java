package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage{
    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    private By clickShopBy = By.xpath("//*[text() = 'SHOP']");
    private By premiumGlasses = By.xpath("//*[text() = 'Premium Glasses']");
    private By warmHoodie = By.xpath("//*[text() = 'Warm Hoodie']");
    private By addToCartBtn = By.xpath("//button[@type='submit']");
    private By removeInCartButton = By.xpath(".//*[@data-hook = 'remove-button']");
    private By removeIcon = By.xpath("//*[@data-hook = 'cart-widget-remove-item']");
    private By minimizeIcon = By.xpath("//button[@data-hook = 'cart-widget-close']");
    private By storesCategory = By.xpath("//*[text() = 'Stores']");
    private By sizeDropdown = By.xpath("//*[text()= 'Select']");
    private By smallSize = By.xpath("//*[text() = 'Small']");
    private By greyColor = By.xpath("//*[contains(@style,'background-color: rgb(128, 128, 128)')]");
    private By viewCartButton = By.xpath("*//a[@data-hook = 'widget-view-cart-button']");
    private By qtyField = By.xpath("//*[@data-hook = 'wsr-input']");


    //*********Page Methods*********
    //Go to Homepage
    public void goToWix (){
        //*********Page Variables*********
        String baseURL = "https://georgel8.wixsite.com/ait-ht";
        driver.get(baseURL);
    }

    //Go to StartPage
    public void goToShop (){
        click(clickShopBy);
    }

    public void selectGlasses (){
        click(premiumGlasses);
    }

    public void chooseWarmHoodie (){
        click(warmHoodie);
    }

    public void selectSize(){
        driver.findElement(sizeDropdown).click();
        driver.findElement(smallSize).click();
    }

    public void selectColor(){
        driver.findElement(greyColor).click();
    }


    public void addProductToCart (){
        click(addToCartBtn);
    }


    public void removeProduct () {
        driver.switchTo().frame(0);
        //Actions action = new Actions(driver);
        //WebElement element = driver.findElement(By.xpath("//*[@data-hook='cart-widget-item']"));
        //action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeIcon));
        //wait.until(ExpectedConditions.elementToBeClickable(removeIcon));
        //WebElement imageLink = driver.findElements(By.tagName("a")).get(1);
        //imageLink.click();
        //wait.until(ExpectedConditions.elementToBeClickable(removeIcon));
        click(removeIcon);
    }

    public void openCartPage (){
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        click(viewCartButton);
        //driver.switchTo().defaultContent();
    }

    public void minimizeCart (){
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(minimizeIcon));
        click(minimizeIcon);
    }

    public void openStores (){
        click(storesCategory);
    }

    public void increaseQty (){
        wait.until(ExpectedConditions.elementToBeClickable(qtyField));
        WebElement qty = driver.findElement(qtyField);
        qty.click();
        qty.sendKeys("3");
    }

    public void deleteProduct() {
        driver.switchTo().defaultContent();
        //driver.switchTo().frame(0);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(removeInCartButton).click();

    }

}
