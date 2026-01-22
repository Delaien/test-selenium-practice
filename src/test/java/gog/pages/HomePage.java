package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String HOME_URL = "https://www.gog.com/fr/";
    private final By searchButton = By.cssSelector("a[hook-test='menuSearch']");
    private final By searchInput = By.cssSelector("input[hook-test='menuSearchInput']");
    private final By searchFirstResult = By.cssSelector(".menu-search__results .menu-search__result a.menu-product__link");
    private final By homeLink = By.cssSelector("a.menu__logo");
    private final By sliderLeftButton = By.cssSelector("[selenium-id='bigSpotSliderOverlayLeft'], [selenium-id='SliderArrowPrev']");
    private final By sliderBullets = By.cssSelector(".swiper-pagination .swiper-pagination-bullet");
    private final By firstFeaturedGameLink = By.cssSelector("[selenium-id='productTile']");
    private final By aboutMenu = By.cssSelector(".js-menu-about");
    private final By joinTeamLink = By.cssSelector("[hook-test='aboutMenu-join-the-team'] a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(HOME_URL);
        dismissCookieBannerIfPresent();
        return this;
    }

    public SearchResultsPage searchGame(String gameName) {
        dismissCookieBannerIfPresent();
        waitClick(searchButton);
        type(searchInput, gameName);
        waitUntil(searchInput).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public GamePage goToGame(String gameName) {
        dismissCookieBannerIfPresent();
        waitClick(searchButton);
        type(searchInput, gameName);
        String slug = toSlug(gameName);
        By resultBySlug = By.cssSelector(".menu-search__results a.menu-product__link[href*='" + slug + "']");
        wait.until(d -> !d.findElements(resultBySlug).isEmpty() || !d.findElements(searchFirstResult).isEmpty());
        if (!driver.findElements(resultBySlug).isEmpty()) {
            waitClick(resultBySlug);
        } else {
            waitClick(searchFirstResult);
        }
        return new GamePage(driver);
    }

    public GamePage goToFirstFeaturedGame() {
        dismissCookieBannerIfPresent();
        waitClick(firstFeaturedGameLink);
        return new GamePage(driver);
    }

    public WorkPage goToJobOfferPage() {
        dismissCookieBannerIfPresent();
        boolean aboutVisible = false;
        var menus = driver.findElements(aboutMenu);
        for (var menu : menus) {
            if (menu.isDisplayed()) {
                aboutVisible = true;
                break;
            }
        }
        if (!aboutVisible) {
            driver.get("https://www.gog.com/fr/work");
            return new WorkPage(driver);
        }
        hover(aboutMenu);
        waitClick(joinTeamLink);
        return new WorkPage(driver);
    }

    public void clickSliderLeft() {
        dismissCookieBannerIfPresent();
        waitClick(sliderLeftButton);
    }

    public void clickLastSliderBullet() {
        dismissCookieBannerIfPresent();
        var bullets = driver.findElements(sliderBullets);
        if (bullets.isEmpty()) {
            return;
        }
        var lastBullet = bullets.get(bullets.size() - 1);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                lastBullet
        );
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                lastBullet
        );
    }

    public int getActiveSliderBulletIndex() {
        var bullets = driver.findElements(sliderBullets);
        for (int i = 0; i < bullets.size(); i++) {
            String className = bullets.get(i).getAttribute("class");
            if (className != null && className.contains("swiper-pagination-bullet-active")) {
                return i;
            }
        }
        return -1;
    }

    public void waitForSliderBulletChange(int previousIndex) {
        wait.until(d -> getActiveSliderBulletIndex() != previousIndex);
    }

    public boolean isDisplayed() {
        return waitUntil(homeLink).isDisplayed();
    }

    public boolean isHomeLinkDisplayed() {
        return waitUntil(homeLink).isDisplayed();
    }

    public HomePage changeLanguage(String locale) {
        driver.get("https://www.gog.com/" + locale + "/");
        dismissCookieBannerIfPresent();
        return this;
    }

    private String toSlug(String value) {
        return value.toLowerCase()
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
    }
}
