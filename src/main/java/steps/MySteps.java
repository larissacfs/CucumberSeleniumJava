package steps;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.BasePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import utils.TakeScreenshotUtils;

public class MySteps {

	String scenarioName;
	BasePage basePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;

	@Before
	public void setup(Scenario scenarioName) {
		getDriver();
		this.scenarioName = scenarioName.getName();
		loginPage = new LoginPage();
		basePage = new BasePage();
		secureAreaPage = new SecureAreaPage();
	}

	@After
	public void tearDown() {
		killDriver();
	}

	@Dado("^que eu acedi a página de login$")
	public void que_eu_acedi_a_pagina_de_login() throws Throwable {
		loginPage.accessLoginPage();
		TakeScreenshotUtils.TakeScreenshot("que_eu_acedi_a_pagina_de_login", scenarioName);
	}
	
	@Quando("^eu insiro credenciais válidas$")
	public void euInsiroCredenciaisValidas() throws Throwable {
		loginPage.insertUsername("tomsmith");
		loginPage.insertPassword("SuperSecretPassword!");
		TakeScreenshotUtils.TakeScreenshot("euInsiroCredenciaisValidas", scenarioName);
	}

	@Quando("^eu clico no botão de login$")
	public void euClicoNoBotaoDeLogin() throws Throwable {
		loginPage.clickLogin();
		TakeScreenshotUtils.TakeScreenshot("euClicoNoBotaoDeLogin", scenarioName);
	}

	@Então("^eu devo ser redirecionado a Secure Area$")
	public void euDevoSerRedirecionadoASecureArea() throws Throwable {
		secureAreaPage.confirmInSecureArea();
		TakeScreenshotUtils.TakeScreenshot("euDevoSerRedirecionadoASecureArea", scenarioName);
	}
	
	@Quando("^eu insiro credenciais inválidas$")
	public void euInsiroCredenciaisInválidas() throws Throwable {
		loginPage.insertUsername("aaaa");
		loginPage.insertPassword("aaaa");
		TakeScreenshotUtils.TakeScreenshot("euInsiroCredenciaisInválidas", scenarioName);
	}

	@Então("^eu não devo ser redirecionado a Secure Area$")
	public void euNãoDevoSerRedirecionadoASecureArea() throws Throwable {
		if (!loginPage.compareUrlToLoginPage()) {
			throw new Exception("User nao esta na login page");
		}
		TakeScreenshotUtils.TakeScreenshot("euInsiroCredenciaisInválidas", scenarioName);
	}

	@Então("^devo permanecer na página de login$")
	public void devoPermanecerNaPáginaDeLogin() throws Throwable {
		loginPage.errorLogin();
		TakeScreenshotUtils.TakeScreenshot("devoPermanecerNaPáginaDeLogin", scenarioName);
	}
	
	@Quando("^eu insiro \"([^\"]*)\" no campo de username$")
	public void euInsiroNoCampoDeUsername(String arg1) throws Throwable {
		loginPage.insertUsername(arg1);
		TakeScreenshotUtils.TakeScreenshot("euInsiroNoCampoDeUsername", scenarioName);
	}

	@Quando("^eu insiro \"([^\"]*)\" no campo de password$")
	public void euInsiroNoCampoDePassword(String arg1) throws Throwable {
		loginPage.insertPassword(arg1);
		TakeScreenshotUtils.TakeScreenshot("euInsiroNoCampoDePassword", scenarioName);
	}

}
