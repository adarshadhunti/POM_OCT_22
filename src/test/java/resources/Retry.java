package resources;

import org.testng.*;

public class Retry implements IRetryAnalyzer {
    int count=0;
    int max_count=1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<max_count)
        {
            count++;
            return true;
        }
        return false;
    }
}
