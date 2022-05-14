package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class test {
    private WebDriver driver = Hooks.getDriver();

    @Given("^ingreso a la pagina de login de la aplicacion web swaglabs$")
    public void ingresoALaPaginaDeLoginDeLaAplicacionWebSwaglabs() throws Throwable {
        String titleLoginPage = "Swag Labs";
        Assert.assertEquals(titleLoginPage, driver.getTitle());

    }

    @When("^se ingresa el nombre de usuario \"([^\"]*)\"$")
    public void seIngresaElNombreDeUsuario(String arg1) throws Throwable {
        driver.findElement(By.id("user-name")).sendKeys(arg1);
    }

    @When("^se ingresa el password \"([^\"]*)\"$")
    public void seIngresaElPassword(String arg1) throws Throwable {

        driver.findElement(By.id("password")).sendKeys(arg1);
    }

    @When("^clic en boton login$")
    public void clicEnBotonLogin() throws Throwable {

        driver.findElement(By.id("login-button")).click();
    }

    @Then("^ingresa a la pagina de productos$")
    public void ingresaALaPaginaDeProductos() throws Throwable {

        driver.findElement(By.className("app_logo")).isDisplayed();


    }

    @When("^se ingresa nombre de usuario no valido \"([^\"]*)\"$")
    public void seIngresaNombreDeUsuarioNoValido(String arg1) throws Throwable {

        driver.findElement(By.id("user-name")).sendKeys("Harold_Espana");

    }

    @When("^se ingresa password no valido \"([^\"]*)\"$")
    public void seIngresaPasswordNoValido(String arg1) throws Throwable {

        driver.findElement(By.id("password")).sendKeys("123456");
    }

    @Then("^muestra mensaje de error de usuario con el texto:$")
    public void muestraMensajeDeErrorDeUsuarioConElTexto(String arg1) throws Throwable {

        WebElement messageErrorLocator = driver.findElement(By.tagName("h3"));
        Assert.assertTrue("no muestra mensaje de error",messageErrorLocator.isDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", messageErrorLocator.getText());


    }

    @When("^se ingresa password \"([^\"]*)\"$")
    public void seIngresaPassword(String arg1) throws Throwable {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("^muestra mensaje de error usuario requerido con el texto:$")
    public void muestraMensajeDeErrorUsuarioRequeridoConElTexto(String arg1) throws Throwable {

        WebElement messageErrorLocator = driver.findElement(By.tagName("h3"));
        Assert.assertTrue("no muestra mensaje de error",messageErrorLocator.isDisplayed());
        Assert.assertEquals("Epic sadface: Username is required", messageErrorLocator.getText());

    }

    @When("^se ingresa nombre de usuario \"([^\"]*)\"$")
    public void seIngresaNombreDeUsuario(String arg1) throws Throwable {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @Then("^muestra mensaje de error password requerido con el texto:$")
    public void muestraMensajeDeErrorPasswordRequeridoConElTexto(String arg1) throws Throwable {

        WebElement messageErrorLocator = driver.findElement(By.tagName("h3"));
        Assert.assertTrue("no muestra mensaje de error",messageErrorLocator.isDisplayed());
        Assert.assertEquals("Epic sadface: Password is required", messageErrorLocator.getText());

    }

    @Given("^se ha mostrado un mensaje de error$")
    public void seHaMostradoUnMensajeDeError() throws Throwable {
        driver.findElement(By.tagName("h3")).isDisplayed();

    }

    @When("^hago clic en el boton con la x del mensaje$")
    public void hagoClicEnElBotonConLaXDelMensaje() throws Throwable {
        driver.findElement(By.className("error-button")).click();
    }

    @Then("^se oculta el mensaje de error$")
    public void seOcultaElMensajeDeError() throws Throwable {


    }





}
