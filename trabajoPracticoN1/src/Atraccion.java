import java.util.LinkedList;
import java.util.List;


//enum tiposDeAtracciones {Museo, ParqueDeDiversiones};

public class Atraccion {
	
	private int coordenadaX;
	private int coordenadaY;
	private double costo;
	private int cupoDeIntegrantesDiarios;
	private int tiempoNecesarioParaVisitaEnMinutos;
	private String tipo;
	private List<Promocion> promocionesAplicables = null;
	

	public Atraccion(){}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCupoDeIntegrantesDiarios() {
		return cupoDeIntegrantesDiarios;
	}
	public void setCupoDeIntegrantesDiarios(int cupoDeIntegrantesDiarios) {
		this.cupoDeIntegrantesDiarios = cupoDeIntegrantesDiarios;
	}
	public int getTiempoNecesarioParaVisitaEnMinutos() {
		return tiempoNecesarioParaVisitaEnMinutos;
	}
	public void setTiempoNecesarioParaVisitaEnMinutos(int tiempoNecesarioParaVisitaEnMinutos) {
		this.tiempoNecesarioParaVisitaEnMinutos = tiempoNecesarioParaVisitaEnMinutos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipoAtraccion) {
		this.tipo = tipoAtraccion;
	}
	
	public List<Promocion> getPromocionesAplicables() {
		return promocionesAplicables;
	}
	
	public void addPromocionAplicable(Promocion promocion){
		
		promocionesAplicables = new LinkedList<Promocion>();
		this.promocionesAplicables.add(promocion);
		
	} 

	public void setPromocionesAplicables(List<Promocion> promocionesAplicables) {
		
		promocionesAplicables = new LinkedList<Promocion>();
		this.promocionesAplicables = promocionesAplicables;
	}
	
}
