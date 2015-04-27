import org.junit.Assert;
import org.junit.Test;


public class AtraccionTest {
	
	@Test
	public void getAtraccionTest(){
		
		Atraccion miAtraccion = new Atraccion();
		miAtraccion.setCoordenadaX(192);
		miAtraccion.setCoordenadaY(192);
		miAtraccion.setCosto(10);
		miAtraccion.setTiempoNecesarioParaVisita(8);
		miAtraccion.setCupoDeIntegrantesDiarios(400);
		miAtraccion.setTipo("Paisaje de Aventura");
				
		Assert.assertEquals(192, miAtraccion.getCoordenadaX());
		Assert.assertEquals(192, miAtraccion.getCoordenadaY());
		Assert.assertEquals(10,0, miAtraccion.getCosto());
		Assert.assertEquals(8, miAtraccion.getTiempoNecesarioParaVisita());
		Assert.assertEquals(400, miAtraccion.getCupoDeIntegrantesDiarios());
		Assert.assertEquals("Paisaje de Aventura", miAtraccion.getTipo());
		
		
	}
	

}
