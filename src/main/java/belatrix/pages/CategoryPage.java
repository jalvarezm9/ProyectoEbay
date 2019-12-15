package belatrix.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import belatrix.entity.Producto;

public class CategoryPage {
	
	private WebDriverWait wait;
	private Actions action;
	private Producto objProducto;
	
	//Constructor
	public CategoryPage(WebDriver driver){
		PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
        this.action = new Actions(driver);

	}
	
	//Locators
	@FindBy(xpath="//h3[contains(text(),'Categorías')]")
	private WebElement tituloCategoria;
	
	@FindBy(xpath="//div[@id='x-refine__group_1__0']//span[starts-with(@class,'cb')]")
	private List<WebElement> listaTalla;
	
	@FindBy(xpath="//div[@id='x-refine__group_1__1']//span[starts-with(@class,'cb')]")
	private List<WebElement> listaMarca;
	
	@FindBy(xpath="//h1[@class='srp-controls__count-heading']/span[1]")
	private WebElement resultadosFiltro;
	
	@FindBy(id="w9")
	private WebElement mejorResultado;
	
	@FindBy(xpath="//span[contains(text(),'Precio + Envío: más bajo primero')]")
	private WebElement opcionPrecioMasAlto;
	
	@FindBy(css="li.s-item")
	private List<WebElement> listaProductos;
	
	//Method
	public void validarSeccionCategoria(){
		wait.until(ExpectedConditions.visibilityOf(tituloCategoria));	
	}
	
	public void seleccionarMarca(String marca){
		validarSeccionCategoria();
		for (WebElement e : listaMarca) {
			if (e.getText().equals(marca)) {
				wait.until(ExpectedConditions.elementToBeClickable(e)).click();
				break;
			}
		}
	}
	
	public void seleccionarTalla(double talla){
		validarSeccionCategoria();
		for (WebElement e : listaTalla) {
			if(Double.parseDouble(e.getText())==talla){
				wait.until(ExpectedConditions.elementToBeClickable(e)).click();
				break;
			}	
		}
	}
	
	public String mostrarCantidadResultados(){
		wait.until(ExpectedConditions.visibilityOf(resultadosFiltro));		
		return resultadosFiltro.getText();
	}
	
	public void ordenarMayorPrecio(){
		validarSeccionCategoria();
		action.moveToElement(mejorResultado).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(opcionPrecioMasAlto)).click();
	}
	
	public Producto obtenerProductoLista(int pos){
		validarSeccionCategoria();
		objProducto = new Producto(); //Cada ves que se invoca al metodo desde el Steps se debe instanciar, por eso no va en el constructor.
		objProducto.setIndice(pos);
		objProducto.setTitulo(listaProductos.get(pos).findElement(By.cssSelector("h3.s-item__title")).getText());
		objProducto.setPrecio(Double.parseDouble(listaProductos.get(pos).findElement(By.cssSelector("span.s-item__price")).getText().replace("S/. ", "")));
		
		return objProducto;
	}

}
