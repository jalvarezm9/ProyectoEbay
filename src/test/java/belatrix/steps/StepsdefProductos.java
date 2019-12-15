package belatrix.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import belatrix.entity.Producto;
import belatrix.manager.DriverManager;
import belatrix.pages.CategoryPage;
import belatrix.pages.HomePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class StepsdefProductos {

	private WebDriver driver;
	private HomePage homePage;
	private CategoryPage categoryPage;
	private List<Producto> productos;

	public StepsdefProductos() {
		driver = DriverManager.getDriver();
		homePage = new HomePage(driver);
		categoryPage = new CategoryPage(driver);
		productos = new ArrayList<>();
	}

	@Dado("^que me encuentro en la pagina inicial de ebay$")
	public void que_me_encuentro_en_la_pagina_inicial_de_ebay()
			throws Throwable {
		driver.get("https://www.ebay.com/");
	}

	@Cuando("^ingreso el filtro por categoria (.*)$")
	public void ingreso_el_filtro_por_categoria(String categoria)
			throws InterruptedException {
		homePage.ingresarCategoria(categoria);
		homePage.btnbuscarProducto();
	}

	@Y("^selecciono la marca (.*)$")
	public void selecciono_la_marca(String marca) throws InterruptedException {
		categoryPage.seleccionarMarca(marca);
	}

	@Y("^selecciono la talla (\\d+)$")
	public void selecciono_la_talla(double talla) throws InterruptedException {
		categoryPage.seleccionarTalla(talla);
	}

	@Entonces("^imprimir el numero de resultados$")
	public void imprimir_el_numero_de_resultados() throws Throwable {
		System.out.println(" \n==================== Cantidad de Productos =================== \n");
		System.out.println(categoryPage.mostrarCantidadResultados());
		
	}

	@Y("^ordenar por precio ascendente$")
	public void ordenar_por_precio_ascendente() throws Throwable {
		categoryPage.ordenarMayorPrecio();
	}

	@Entonces("^Tome los primeros (\\d+) productos con sus precios e imprímalos en la consola$")
	public void tome_los_primeros_productos_con_sus_precios_e_imprímalos_en_la_consola(
			int cant) throws Throwable {
		for (int i = 1; i <= cant; i++) {
			productos.add(categoryPage.obtenerProductoLista(i));
		}

		System.out.println(" \n==================== 5 primeros Productos =================== \n");
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}

	}

	@Entonces("^Ordene e imprima los productos por nombre ascendente$")
	public void ordene_e_imprima_los_productos_por_nombre_ascendente()
			throws Throwable {

		Collections.sort(productos, new Comparator<Producto>() {
			public int compare(Producto o1, Producto o2) {
				return o1.getTitulo().compareTo(o2.getTitulo());
			}
		});

		System.out
				.println(" \n ============ 5 primeros Productos Ordenados por titulo Ascendente ===========\n");
		for (Producto elemento : productos) {
			System.out.println(elemento);
		}

	}

	@Entonces("^Ordene e imprima los productos por precio en modo descendiente$")
	public void ordene_e_imprima_los_productos_por_precio_en_modo_descendiente()
			throws Throwable {
		
    	Collections.sort(productos, new Comparator<Producto>() {
			public int compare(Producto o1, Producto o2) {
				return Double.compare(o2.getPrecio(), o1.getPrecio());
			}
    	});
    	
    	System.out.println(" \n ============ 5 primeros Productos Ordenados por Precio Descendente ===========\n");
    	for(Producto elemento:productos){
    		System.out.println(elemento);
    	}

	}

}
