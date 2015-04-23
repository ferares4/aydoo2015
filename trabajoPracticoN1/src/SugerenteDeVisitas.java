import java.util.LinkedList;
import java.util.List;


public class SugerenteDeVisitas {
	
	Usuario usuario;
	Atraccion [] vectorDeAtracciones;
	
	public List<Atraccion> sugerirVisita(Usuario usuario, Atraccion[] vectorDeAtracciones){
		
		List<Atraccion> listaDeAtraccionesParaUsuario = new LinkedList<Atraccion>();
		
		for (int i=0;i<vectorDeAtracciones.length;i++){
			
			if (atraccionSugeridaParaUsuario(usuario,vectorDeAtracciones[i])){
				
				listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);
				
			}
			
			
		}
		
		return listaDeAtraccionesParaUsuario;
		
	}
	
	public boolean atraccionSugeridaParaUsuario(Usuario usuario, Atraccion atraccion){
		
		if (
			
			   atraccion.getTipo() != null	
			&& usuario.getTipoDeAtraccionPreferida().equals(atraccion.getTipo())
			&& usuario.getPresupuesto() > atraccion.getCosto()	
			&& usuario.getTiempoDisponibleParaVisitasEnMinutos() > atraccion.getTiempoNecesarioParaVisitaEnMinutos()
			
			) 
		
		
		{
			
			return true;
			
		}
		
		else if (
						atraccion.getTipo() != null			
					&&  usuario.getPresupuesto() > atraccion.getCosto()	
					&&  usuario.getTiempoDisponibleParaVisitasEnMinutos() > atraccion.getTiempoNecesarioParaVisitaEnMinutos()
					
				)
		{
			
			
			return true;
			
		}
		
		else {
			
				
			return false;
		
		}

	}

	
	
}
