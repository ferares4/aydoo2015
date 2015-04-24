import java.util.LinkedList;
import java.util.List;


enum tipoDePromocion {PROMOCION_PORCENTUAL,PROMOCION_POR_PAQUETE,PROMOCIONAXB}

public class Promocion {
	
	private tipoDePromocion tipo;
	private int periodoDeVigenciaEnDias;
	private List<Atraccion> listaDeAtracciones;
	
	public Promocion(tipoDePromocion tipo, int periodo){
		
		this.tipo = tipo;
		this.periodoDeVigenciaEnDias = periodo;
		listaDeAtracciones = new LinkedList<Atraccion>();
		
	}

	public tipoDePromocion getNombre() {
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

	public void setAtracciones(Atraccion atraccion) {
		
			listaDeAtracciones.add(atraccion);			
			
	}
		
		
	public void setAtracciones(Atraccion[] vectorDeAtracciones) {
		
		for (int i=0;i<vectorDeAtracciones.length;i++){
		
			listaDeAtracciones.add(vectorDeAtracciones[i]);
			
		}
	}

	public List<Atraccion> getListaDeAtracciones() {
		return listaDeAtracciones;
	}

	public void setListaDeAtracciones(List<Atraccion> listaDeAtracciones) {
		this.listaDeAtracciones = listaDeAtracciones;
	}

	public tipoDePromocion getTipo() {
		return tipo;
	}
	

}
