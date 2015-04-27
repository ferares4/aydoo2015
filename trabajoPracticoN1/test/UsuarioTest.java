import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {
	
	
	
	@Test
	public void getUsuario(){
		
		Usuario miUsuario = new Usuario();
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitas(6);
		miUsuario.setTipoDeAtraccionPreferida("Museo");
		miUsuario.setVelocidadDeTraslado(20);
		
		Assert.assertEquals(100,0, miUsuario.getPresupuesto());
		Assert.assertEquals(6, miUsuario.getTiempoDisponibleParaVisitas());
		Assert.assertEquals("Museo", miUsuario.getTipoDeAtraccionPreferida());
		Assert.assertEquals(20, miUsuario.getVelocidadDeTraslado());
		
		
	}
	


}
