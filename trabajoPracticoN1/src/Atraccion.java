
public class Atraccion{
	
	private int coordenadaX;
	private int coordenadaY;
	private double costo;
	private int cupoDeIntegrantesDiarios;
	private int tiempoNecesarioParaVisita;
	private String tipo;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipoAtraccion) {
		this.tipo = tipoAtraccion;
	}
		
	//To DELETE
	/*
	public List<Promocion> buscarPromocionesVigentes(Promocion[] vectorDePromociones){
		
		List <Promocion> promocionesVigentes = new LinkedList<Promocion>();
		
		for (int i=0;i<vectorDePromociones.length;i++){
			
			if (vectorDePromociones[i].tienePromocion(this)){
				
				promocionesVigentes.add(vectorDePromociones[i]);
				
			}
			
		}
		
		return promocionesVigentes;		
		
	}
	*/
}
