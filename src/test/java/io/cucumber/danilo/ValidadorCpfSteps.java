package io.cucumber.danilo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		WebElement input = browser.findElement(By.xpath("//*[@id="app"]/div/div[1]/div[2]/div/div[4]/div[3]/div/span"));
		assertEquals(string, input.getText());
		browser.quit();
	}

}