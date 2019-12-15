package belatrix.entity;

public class Producto implements Comparable<Producto> {
	
	private int id;
	private String titulo;
	private double precio;
		
	public Producto() {
	}
	
	public int getIndice() {
		return id;
	}

	public void setIndice(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [indice=" + id + ", titulo=" + titulo
				+ ", precio=" + precio + "]";
	}

	public int compareTo(Producto arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
