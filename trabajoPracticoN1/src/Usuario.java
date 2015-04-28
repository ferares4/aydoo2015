import java.util.Iterator;
import java.util.List;


public class Usuario {
	
	private double presupuesto;
	private int tiempoDisponibleParaVisitas;
	private int velocidadDeTraslado;
	private String tipoDeAtraccionPreferida;
	
	
	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getTiempoDisponibleParaVisitas() {
		return tiempoDisponibleParaVisitas;
	}

	public void setTiempoDisponibleParaVisitas(int tiempoDisponibleParaVisitas) {
		this.tiempoDisponibleParaVisitas = tiempoDisponibleParaVisitas;
	}

	public int getVelocidadDeTraslado() {
		return velocidadDeTraslado;
	}

	public void setVelocidadDeTraslado(int velocidadDeTraslado) {
		this.velocidadDeTraslado = velocidadDeTraslado;
	}

	public String getTipoDeAtraccionPreferida() {
		return tipoDeAtraccionPreferida;
	}

	public void setTipoDeAtraccionPreferida(String tipoDeAtraccionPreferida) {
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}
	
	public int calcularTiempoDeViaje(int xInicial, int yInicial, int xfinal, int yFinal){
		
		
		return (int) Math.round((Math.sqrt((Math.pow(xfinal-xInicial,2)+Math.pow((yFinal-yInicial), 2)))/velocidadDeTraslado));
		
	}
	
	public Atraccion buscarAtraccionMasCercana(int x, int y, List<Atraccion> listaDeAtracciones){
		
		int tiempoDeLlegada;
		Iterator<Atraccion> iterador = listaDeAtracciones.iterator();
		Atraccion atraccionTemporal=null;
				
		while(iterador.hasNext()){
			
		atraccionTemporal = iterador.next();	
		tiempoDeLlegada = this.calcularTiempoDeViaje(x, y, atraccionTemporal.getCoordenadaX(), atraccionTemporal.getCoordenadaY());
			
			while(iterador.hasNext()){
		
				Atraccion atraccionTemporal2 = iterador.next();	
				if (tiempoDeLlegada < this.calcularTiempoDeViaje(x, y, atraccionTemporal2.getCoordenadaX(), atraccionTemporal2.getCoordenadaY())){
					
					
					
				}
				
				else{
					
					tiempoDeLlegada = this.calcularTiempoDeViaje(x, y, atraccionTemporal2.getCoordenadaX(), atraccionTemporal2.getCoordenadaY());
					atraccionTemporal = atraccionTemporal2;
					
				}
		
			}
		
		
		}
		
		return atraccionTemporal;
		
	}

}
