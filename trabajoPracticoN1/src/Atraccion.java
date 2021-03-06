
public class Atraccion{
	
	private int coordenadaX;
	private int coordenadaY;
	private double costo;
	private int cupoDeIntegrantesDiarios;
	private int tiempoNecesarioParaVisita;
	private TipoDeAtraccion tipo;
	
	public Atraccion(){}
	
	// Getters & Setters
	
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
	public int getTiempoNecesarioParaVisita() {
		return tiempoNecesarioParaVisita;
	}
	public void setTiempoNecesarioParaVisita(int tiempoNecesarioParaVisita) {
		this.tiempoNecesarioParaVisita = tiempoNecesarioParaVisita;
	}
	public TipoDeAtraccion getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeAtraccion tipoAtraccion) {
		this.tipo = tipoAtraccion;
	}
		
}
