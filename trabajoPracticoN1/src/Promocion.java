import java.util.LinkedList;
import java.util.List;


enum tipoDePromocion {PROMOCION_PORCENTUAL,PROMOCION_POR_PAQUETE,PROMOCIONAXB}

public class Promocion{
	
	private tipoDePromocion tipo;
	private int periodoDeVigenciaEnDias;
	private List<Atraccion> listaDeAtracciones;
	
	public Promocion(tipoDePromocion tipo, int periodo){
		
		this.tipo = tipo;
		this.periodoDeVigenciaEnDias = periodo;
		listaDeAtracciones = new LinkedList<Atraccion>();
		
	}
	
	public void addAtraccion(Atraccion atraccion) {
		
		if (!listaDeAtracciones.contains(atraccion)){
		listaDeAtracciones.add(atraccion);			
		}
		
    }
	
	
	// Getters & Setters 
	
	public tipoDePromocion getTipo() {
		return tipo;
	}

	public void setTipo(tipoDePromocion tipo) {
		this.tipo = tipo;
	}

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
