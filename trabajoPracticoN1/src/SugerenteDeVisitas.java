import java.util.LinkedList;
import java.util.List;


public class SugerenteDeVisitas {
	
	Usuario usuario;
	Paquete paqueteFinal;
	Atraccion [] vectorDeAtracciones;
	Promocion [] vectorDePromociones;
	
	
	
	public SugerenteDeVisitas(Usuario usuario, Atraccion[] vectorDeAtracciones,
			Promocion[] vectorDePromociones) {
		super();
		this.usuario = usuario;
		this.vectorDeAtracciones = vectorDeAtracciones;
		this.vectorDePromociones = vectorDePromociones;
	
	}

	public List<Atraccion> sugerirVisita(){
		
		Promocion promocionAplicable;
			
		List<Atraccion> listaDeAtraccionesParaUsuario = new LinkedList<Atraccion>();
		
		for (int i=0;i<vectorDeAtracciones.length;i++){
			
			if (atraccionSugeridaParaUsuario(usuario,vectorDeAtracciones[i])){
				
					if (buscarAtraccionEnPromocionesVigentes(vectorDeAtracciones[i])!=null){
				
						vectorDeAtracciones[i].addPromocionAplicable(buscarAtraccionEnPromocionesVigentes(vectorDeAtracciones[i]));	
						listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);
					}
						
					else {
							
							listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);
						
					}
				
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
	
	
	public Promocion buscarAtraccionEnPromocionesVigentes(Atraccion atraccion){
		
		if (vectorDePromociones != null){
			
			for(int i=0;i<vectorDePromociones.length;i++){
				
				if (vectorDePromociones[i].getListaDeAtracciones().contains(atraccion)){
					
					return vectorDePromociones[i];
					
				}
				
				else {
					
					i++;
					
				}
				
			}
			
			
			
		}
		
		
		return null;
	}
	
	
}
