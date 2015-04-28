import java.util.LinkedList;
import java.util.List;

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
	
	@Test
	public void calcularTiempoDeViaje(){
		
		Usuario miUsuario = new Usuario();
		miUsuario.setVelocidadDeTraslado(7);
		
		Assert.assertEquals(2, miUsuario.calcularTiempoDeViaje(0,0,10,10));
		
	}
	
	@Test
	public void buscarAtraccionMasCercana(){
		
		Usuario miUsuario = new Usuario();
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Atraccion atraccionTemporal = new Atraccion();
		
		atraccionTemporal.setTipo("Gondor");
		atraccionTemporal.setTiempoNecesarioParaVisita(10);
		atraccionTemporal.setCoordenadaX(10);
		atraccionTemporal.setCoordenadaY(15);
		listaDeAtracciones.add(atraccionTemporal);
		
		atraccionTemporal.setTipo("Mordor");
		atraccionTemporal.setTiempoNecesarioParaVisita(20);
		atraccionTemporal.setCoordenadaX(20);
		atraccionTemporal.setCoordenadaY(30);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo("La Comarca");
		atraccionTemporal.setTiempoNecesarioParaVisita(40);
		atraccionTemporal.setCoordenadaX(35);
		atraccionTemporal.setCoordenadaY(10);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo("Bosque Encantado");
		atraccionTemporal.setTiempoNecesarioParaVisita(5);
		atraccionTemporal.setCoordenadaX(40);
		atraccionTemporal.setCoordenadaY(20);
		listaDeAtracciones.add(atraccionTemporal);
		
		Assert.assertEquals(listaDeAtracciones.get(0), miUsuario.buscarAtraccionMasCercana(0,0,listaDeAtracciones));
		
	}
	


}
