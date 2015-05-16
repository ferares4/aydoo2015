
import org.junit.Assert;
import org.junit.Test;


public class AtraccionComparatorTest {
	
	@Test
	public void compararUnaAtraccionDeMayorCostoQueOtra(){
		
		
		Atraccion atraccionMayorCosto = new Atraccion();
		Atraccion atraccionMenorCosto = new Atraccion();
		AtraccionComparator comparador = new AtraccionComparator(Atributos.COSTO);
		
		atraccionMayorCosto.setCosto(100);
		atraccionMenorCosto.setCosto(50);
		
		Assert.assertEquals(1, comparador.compare(atraccionMayorCosto, atraccionMenorCosto));
		
	}
	
	@Test
	public void compararUnaAtraccionDeMenorCostoQueOtra(){
		
		
		Atraccion atraccionMayorCosto = new Atraccion();
		Atraccion atraccionMenorCosto = new Atraccion();
		AtraccionComparator comparador = new AtraccionComparator(Atributos.COSTO);
		
		atraccionMayorCosto.setCosto(100);
		atraccionMenorCosto.setCosto(50);
		
		Assert.assertEquals(-1, comparador.compare(atraccionMenorCosto,atraccionMayorCosto));
		
	}
	
	@Test
	public void compararUnaAtraccionDeIgualCostoQueOtra(){
		
		
		Atraccion atraccionMayorCosto = new Atraccion();
		Atraccion atraccionMenorCosto = new Atraccion();
		AtraccionComparator comparador = new AtraccionComparator(Atributos.COSTO);
		
		atraccionMayorCosto.setCosto(100);
		atraccionMenorCosto.setCosto(100);
		
		Assert.assertEquals(0, comparador.compare(atraccionMenorCosto,atraccionMayorCosto));
		
	}

}
