import java.util.Iterator;
import java.util.List;


public class Usuario {
	
	private double presupuesto;
	private int tiempoDisponibleParaVisitas;
	private int velocidadDeTraslado;
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private int direccionX;
	private int direccionY;
	
	/** Calcula un tiempo de viaje teniendo en cuenta la velocidad de traslado entre 2 coordenadas genericas */
	public int calcularTiempoDeViaje(int xInicial, int yInicial, int xfinal, int yFinal){

		return (int) Math.round((Math.sqrt((Math.pow(xfinal-xInicial,2)+Math.pow((yFinal-yInicial), 2)))/velocidadDeTraslado));

	}

	/** Calcula la distancia entre 2 coordenadas genericas */
	public int calcularDistanciaDeViaje(int xInicial, int yInicial, int xfinal, int yFinal){
		
		return (int) Math.round((Math.sqrt((Math.pow(xfinal-xInicial,2)+Math.pow((yFinal-yInicial), 2)))));
	}
	
	/** Devuelve la atraccion mas cercana de acuerdo a la posicion actual */
	public Atraccion buscarAtraccionMasCercana(int x, int y, List<Atraccion> listaDeAtracciones){

		int tiempoDeLlegada;
		Iterator<Atraccion> iterador = listaDeAtracciones.iterator();
		Atraccion atraccionTemporal=null;

		while(iterador.hasNext()){

			atraccionTemporal = iterador.next();	
			tiempoDeLlegada = this.calcularTiempoDeViaje(x, y, atraccionTemporal.getCoordenadaX(), atraccionTemporal.getCoordenadaY());

			while(iterador.hasNext()){

				Atraccion atraccionTemporal2 = iterador.next();	
				if (tiempoDeLlegada >= this.calcularTiempoDeViaje(x, y, atraccionTemporal2.getCoordenadaX(), atraccionTemporal2.getCoordenadaY())){

					tiempoDeLlegada = this.calcularTiempoDeViaje(x, y, atraccionTemporal2.getCoordenadaX(), atraccionTemporal2.getCoordenadaY());
					atraccionTemporal = atraccionTemporal2;

				}

			}


		}

		return atraccionTemporal;

	}
	
	// Getters & Setters
	
	
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

	public TipoDeAtraccion getTipoDeAtraccionPreferida() {
		return tipoDeAtraccionPreferida;
	}

	public void setTipoDeAtraccionPreferida(TipoDeAtraccion tipoDeAtraccionPreferida) {
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}

	public int getDireccionX() {
		return direccionX;
	}

	public void setDireccionX(int direccionX) {
		this.direccionX = direccionX;
	}

	public int getDireccionY() {
		return direccionY;
	}

	public void setDireccionY(int direccionY) {
		this.direccionY = direccionY;
	}

}
