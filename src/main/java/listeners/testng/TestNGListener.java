package listeners.testng;

import DriverFactory.Driver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.AllureReportHelper;
import utilities.ScreenShotManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import static utilities.PropertiesManager.initializeProperties;
import static utilities.PropertiesManager.webConfig;

public class TestNGListener implements IExecutionListener , ITestListener {

    @Override
    public void onExecutionStart() {
        System.out.println("**************** Welcome to Selenium Framework *****************");
        initializeProperties();
        if(webConfig.getProperty("cleanAllureReport").equalsIgnoreCase("true")) {
            System.out.println("Cleaning Allure Report....");
            AllureReportHelper.cleanAllureReport();
        }
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Generating Report......");

        if(webConfig.getProperty("openAllureReportAfterExecution").equalsIgnoreCase("true")) {
            try {
                System.out.println("Opening Allure Report");
                Runtime.getRuntime().exec("reportGeneration.bat");
            } catch (IOException e) {
                System.out.println("Unable to Generate Allure Report, may be there's an issue in the batch file/commands");
            }
        }
        System.out.println("********************* End of Execution *********************");
    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*************************Starting test: " + result.getName() + " **************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*************************Success of test: " + result.getName() + " **************************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed...");
        System.out.println("Taking Screenshot......");

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for(Field field: fields){
                if(field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }

                if(field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
        } catch (IllegalAccessException exception) {
            System.out.println("Unable to get field, Field Should be public");
        }
        assert driver != null;

        String fullPath = ScreenShotManager.captureScreenshot(driver.get(), result.getName());
        System.out.println(fullPath);

        try {
            Allure.addAttachment(result.getMethod().getConstructorOrMethod().getName(),
                    FileUtils.openInputStream(new File(fullPath)));
        } catch (IOException e) {
            System.out.println("Attachment isn't Found");
        }
    }
}
