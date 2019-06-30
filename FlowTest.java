package tests;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;

public class FlowTest extends BaseTest {

    @Test
    public  void userFlow() {
        HomePage homePage = new HomePage(driver);

        //open main page
        homePage.goToWix();

        //Step 1: Go to the Shop
        homePage.goToShop();

        //Step 2: Select product "Premium Glasses" from the gallery shown
        homePage.selectGlasses();

        //Step 3: Add item to Cart
        homePage.addProductToCart();

        //check number of iframes
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        int numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //Step 4: Remove item from Cart
        homePage.removeProduct();

        //Step 5: Minimize the Cart
        homePage.minimizeCart();

        //Step 6: Add product to Cart again
        homePage.addProductToCart();

        //Step 7: Minimize the Cart
        homePage.minimizeCart();

        //Step 8: Go back to the main store gallery
        homePage.openStores();

        //Step 9: Select the product "Warm Hoodie" from the gallery shown
        homePage.chooseWarmHoodie();

        /*Step 10: Add item to Cart
        specify options for product before add to cart because it is configurable one*/
        homePage.selectSize();
        homePage.selectColor();
        homePage.addProductToCart();

        //Step 11: Go to Cart View
        homePage.openCartPage();

        //Step 12:Change the quantity to 3
        homePage.increaseQty();

        //Step 13: Remove the product from the Cart View
        homePage.deleteProduct();

    }

}
