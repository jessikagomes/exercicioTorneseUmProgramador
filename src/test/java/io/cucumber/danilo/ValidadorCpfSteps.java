package io.cucumber.danilo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.By;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ValidadorCpfSteps {

	public ValidadorCpfSteps() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		browser = new ChromeDriver();
	}

	public WebDriver browser;
	//String siteacademy, sitecurso;

	@Dado("que eu estou no site da gama academy {string}")
	public void que_eu_estou_no_site_da_gama_academy(String siteacademy) {
		browser.get(siteacademy);
	}

	@Quando("clico na opcao {string}")
	public void clico_na_opcao(String quemsomosString) {
		WebElement quemsomos = browser.findElement(By.cssSelector(".nav-link"));
		quemsomos.click();
	}

	@Entao("deve ver o item do {string}")
	public void deve_ver_o_item_do(String string) {
		WebElement input = browser.findElement(By.cssSelector(".manifesto h1.heading.lado"));
		assertEquals(string, input.getText());
		browser.quit();
	}

	@Dado("que eu estou no site da gama academy {}")
	public void que_eu_estou_no_site_da_gama_academy(String sitecurso) {
		browser.get(sitecurso);
	}

	@Quando("clico na opcao quero ir para o proximo nivel")
	public void clico_na_opcao_quero_ir_para_o_proximo_nivel() { 
		WebElement botao = browser.findElement(By.xpath("//*[@id='lp-pom-button-849']"));
		botao.click();
	}

	@Entao("devo ver o valor e o botao comprar agora")
	public void devo_ver_o_valor_e_o_botao_comprar_agora() {
		String valorEsperado, botaoComprarEsperado;
		valorEsperado = "R$ 1.529,00";
		botaoComprarEsperado = "Próximo passo";
		WebElement botaoProximoPasso = browser.findElement(By.id("button#saveUserData"));
		WebElement valorHotmart = browser.findElement(By.cssSelector("span[class='product-part product-price--single']"));
		assertEquals(valorEsperado, valorHotmart.getText());
		assertEquals(botaoComprarEsperado, botaoProximoPasso.getText());
		browser.quit();
		/*
		 * String botaoQueroMeMatricular = "QUERO ME MATRICULAR"; WebElement
		 * identificandoSiteGama =
		 * browser.findElement(By.xpath("//*[@id='lp-pom-button-849']")); WebElement
		 * identificandoSiteHotmart =
		 * browser.findElement(By.xpath("//*[@id='__layout']"));
		 * browser.get("https://pages.gama.academy/curso-de-product-management/");
		 * 
		 * 
		 * if () { WebElement valorHotmart =
		 * browser.findElement(By.cssSelector(".product-price")); WebElement
		 * botaoProximoPasso = browser.findElement(By.cssSelector("saveUserData"));
		 * assertEquals(valorEsperado, valorHotmart.getText());
		 * assertEquals(botaoComprarEsperado, botaoProximoPasso.getText());
		 * browser.quit();
		 * 
		 * } else if (browser) { WebElement valor = browser.findElement(By.
		 * cssSelector("div:nth-of-type(90) > div:nth-of-type(2) > p > span > span > span > span"
		 * )); WebElement matricular =
		 * browser.findElement(By.cssSelector("a[id='lp-pom-button-883']"));
		 * assertEquals(valorEsperado, valor.getText());
		 * assertEquals(botaoQueroMeMatricular, matricular.getText()); browser.quit(); }
		 */

	}

}