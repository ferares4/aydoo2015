import java.util.Comparator;

enum Atributos{COSTO,TIEMPO}

public class AtraccionComparator implements Comparator<Atraccion>{

	private Atributos miAtributo;
	
	public AtraccionComparator(Atributos miAtributo){
		
		this.miAtributo = miAtributo;
		
	}
	
	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		
		switch(miAtributo){
		
		case COSTO:
		
			if (o1.getCosto()>o2.getCosto()){
			
				return 1;
		
			}
		
			else if  (o1.getCosto()<o2.getCosto()){
			
				return -1;
			
			}
		
			else {
				return 0;
			}
		
		
		case TIEMPO:
			
				if (o1.getTiempoNecesarioParaVisita()>o2.getTiempoNecesarioParaVisita()){
				
					return 1;
			
				}
			
				else if  (o1.getTiempoNecesarioParaVisita()<o2.getTiempoNecesarioParaVisita()){
				
					return -1;
				
				}
			
				else {
					return 0;
				}
			
		default: return 0;
		}	
		
	}
		
	
}
