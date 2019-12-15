package belatrix.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(id="gh-logo")
	private WebElement logo;
	
	@FindBy(id="gh-ac")
	private WebElement filtroBusqueda;
	
	@FindBy(id="gh-btn")
	private WebElement btnBuscar;
	
	
	public void valida_pagina_home(){
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void ingresarCategoria(String categoria){
		filtroBusqueda.clear();
		filtroBusqueda.sendKeys(categoria);
	}
	
	public void btnbuscarProducto(){
		wait.until(ExpectedConditions.elementToBeClickable(btnBuscar)).click();
	}
	
}
