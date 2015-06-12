import java.util.LinkedList;
import java.util.List;

public class Promocion{
	
	private int periodoDeVigenciaEnDias;
	private List<Atraccion> listaDeAtracciones;
	
	public Promocion(int periodo){
		
		this.periodoDeVigenciaEnDias = periodo;
		listaDeAtracciones = new LinkedList<Atraccion>();
		
	}
	
	public void addAtraccion(Atraccion atraccion) {
		
		if (!listaDeAtracciones.contains(atraccion)){
		listaDeAtracciones.add(atraccion);			
		}
		
    }
	
	public double calcularDescuento(Paquete paquete) {
		// TODO Auto-generated method stub
		return 0;
	}
		
	
	// Getters & Setters 

	public int getPeriodoDeVigenciaEnDias() {
		return periodoDeVigenciaEnDias;
	}

	public void setPeriodoDeVigenciaEnDias(int periodoDeVigenciaEnDias) {
		this.periodoDeVigenciaEnDias = periodoDeVigenciaEnDias;
	}

	public List<Atraccion> getListaDeAtracciones() {
		return listaDeAtracciones;
	}

	public void setListaDeAtracciones(List<Atraccion> listaDeAtracciones) {
		this.listaDeAtracciones = listaDeAtracciones;
	}


	

}
