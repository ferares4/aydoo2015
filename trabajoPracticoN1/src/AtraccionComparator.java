import java.util.Comparator;

public class AtraccionComparator implements Comparator<Atraccion>{
	
	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		
			if (o1.getCosto()>o2.getCosto()){
			
				return 1;
		
			}
		
			else if  (o1.getCosto()<o2.getCosto()){
			
				return -1;
			
			}
		
			else {
				
				return 0;
			
			}
		
		}	
		
	}
