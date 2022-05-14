package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = CAMELCASE
)

public class testrunner {

    @AfterClass
    public static void finish(){
        try{

            String[] cmd = {"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("reporte generado");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
