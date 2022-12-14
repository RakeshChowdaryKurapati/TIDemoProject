package com.seleniumframework.report;

import com.seleniumframework.constants.IConstants;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.seleniumframework.base.BaseClass.driver;

public class CucumberExtentReport {

    public static void cucumberReports() {

        File reportOutputDirectory = new File(System.getProperty("user.dir")+"\\target\\screenshots");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/MyReports/cucumber.json");

        String buildNumber ="";
        String projectName = "";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        configuration.addClassifications("Browser", ((RemoteWebDriver)driver).getCapabilities().getBrowserName());
//        configuration.addClassifications("Branch", prop.getProperty("Branch"));
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//        configuration.setQualifier("sample", "Chrome 80, mobile");

        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

//        configuration.addCustomCssFiles(Collections.singletonList("src/test/resources/css/stackoverflow-light.min.css"));
//        configuration.addCustomJsFiles(Arrays.asList("src/test/resources/js/enable-highlighting.js", "src/test/resources/js/highlight.min.js"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
