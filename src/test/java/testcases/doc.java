package testcases;

import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;

public class doc {
    @Test
    public void document() throws IOException {
        System.out.println(BasePage.geteid());
    }
}
