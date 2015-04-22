import org.junit.Assert;


public class AtraccionTest {
	
	@Test
	public void getAtraccionTest(){
		
		Atraccion miAtraccion = new Atraccion();
		Assert.assertEquals("192", miAtraccion.getCoordenadas());
		Assert.assertEquals("10", miAtraccion.getCosto());
		Assert.assertEquals("8", miAtraccion.getTiempoNecesarioParaVisita());
		Assert.assertEquals("400", miAtraccion.getCupoDeIntegrantesDiarios());
		Assert.assertEquals("Paisaje de Aventura", miAtraccion.Tipo());
		
		
	}
	

}
