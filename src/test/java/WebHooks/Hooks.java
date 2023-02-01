package WebHooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class Hooks {
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println("Test passed: " + description.getMethodName());
        }


        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Test failed: " + description.getMethodName());
        }
    };

    @Before
    public void setUp() {
        System.out.println("Starting test...");
    }

    @After
    public void tearDown() {
        closeWebDriver();
        System.out.println("Test completed.");
    }
}
