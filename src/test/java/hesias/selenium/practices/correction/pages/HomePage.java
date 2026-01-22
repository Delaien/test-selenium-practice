package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By linkHome = By.cssSelector("a.menu__logo");

    private final By searchBtn = By.cssSelector("a[hook-test='menuSearch']");
    private final By searchInput = By.cssSelector("input[hook-test='menuSearchInput']");

    private final By sliderLeftArrow = By.cssSelector("div[selenium-id='SliderArrowPrev']");
    private final By lastSpanSwiper = By.xpath("//swiper[@selenium-id='bigSpotSlider']//.//span[last()]");

    private final By itemSliderContainer = By.cssSelector("item-slider[selenium-id='productsSectionSlider']");
    private final By firstItemSlider = By.cssSelector("a[selenium-id='productTile']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        goTo(ROOT_URL);
        refuseCookies();
        return this;
    }

    public SearchResultsPage searchGame(String gameName) {
        open();
        waitClick(searchBtn).click();
        type(searchInput, gameName);
        keyDown(searchInput, Keys.ENTER);

        return new SearchResultsPage(driver);
    }

    public HomePage changeLanguage(String locale) {
        goTo(ROOT_URL.replace("fr",  locale));
        refuseCookies();
        return this;
    }

    public boolean clickSliderLeftArrow() {
        waitClick(sliderLeftArrow).click();
        return waitClick(lastSpanSwiper).getAttribute("aria-current").contains("true");
    }

    public GamePage clickFirstItemSlider() {
        scrollToElement(itemSliderContainer);
        waitClick(firstItemSlider).click();
        return new GamePage(driver);
    }

    public boolean isDisplayed() {
        try {
            waitUntil(linkHome);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
