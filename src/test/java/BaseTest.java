import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


import static java.time.temporal.ChronoUnit.SECONDS;
import static org.example.driver.WebDriverCreator.createWebDriver;

public class BaseTest {
    protected WebDriver driver;



    @Before
    public void run() {
        driver = createWebDriver();
        //Ожидаем прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }

    }
}

