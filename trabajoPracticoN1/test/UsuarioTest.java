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
		miUsuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.GONDOR);
		miUsuario.setVelocidadDeTraslado(20);
		miUsuario.setDireccionX(30);
		miUsuario.setDireccionY(15);
		
		Assert.assertEquals(100,0, miUsuario.getPresupuesto());
		Assert.assertEquals(6, miUsuario.getTiempoDisponibleParaVisitas());
		Assert.assertEquals(TipoDeAtraccion.GONDOR, miUsuario.getTipoDeAtraccionPreferida());
		Assert.assertEquals(20, miUsuario.getVelocidadDeTraslado());
		Assert.assertEquals(30, miUsuario.getDireccionX());
		Assert.assertEquals(15, miUsuario.getDireccionY());
		
	}
	
	@Test
	public void calcularTiempoDeViaje(){
		
		Usuario miUsuario = new Usuario();
		miUsuario.setVelocidadDeTraslado(7);
		
		Assert.assertEquals(2, miUsuario.calcularTiempoDeViaje(0,0,10,10));
		
	}
	
	@Test
	public void calcularDistanciaDeViajeAAtraccion(){
		
		Usuario miUsuario = new Usuario();
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
		Atraccion atraccionTemporal = new Atraccion();
		
		atraccionTemporal.setTipo(TipoDeAtraccion.GONDOR);
		atraccionTemporal.setTiempoNecesarioParaVisita(10);
		atraccionTemporal.setCoordenadaX(10);
		atraccionTemporal.setCoordenadaY(15);
				
		Assert.assertEquals(18, miUsuario.calcularDistanciaDeViaje(miUsuario.getDireccionX(),miUsuario.getDireccionY(),atraccionTemporal.getCoordenadaX(),atraccionTemporal.getCoordenadaY()));
		
	}
	
	@Test
	public void buscarAtraccionMasCercanaDesdeElCeroCero(){
		
		Usuario miUsuario = new Usuario();
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Atraccion atraccionTemporal = new Atraccion();
		
		atraccionTemporal.setTipo(TipoDeAtraccion.GONDOR);
		atraccionTemporal.setTiempoNecesarioParaVisita(10);
		atraccionTemporal.setCoordenadaX(10);
		atraccionTemporal.setCoordenadaY(15);
		listaDeAtracciones.add(atraccionTemporal);
		
		atraccionTemporal.setTipo(TipoDeAtraccion.MORDOR);
		atraccionTemporal.setTiempoNecesarioParaVisita(20);
		atraccionTemporal.setCoordenadaX(20);
		atraccionTemporal.setCoordenadaY(30);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo(TipoDeAtraccion.LA_COMARCA);
		atraccionTemporal.setTiempoNecesarioParaVisita(40);
		atraccionTemporal.setCoordenadaX(35);
		atraccionTemporal.setCoordenadaY(10);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo(TipoDeAtraccion.BOSQUE_ENCANTADO);
		atraccionTemporal.setTiempoNecesarioParaVisita(5);
		atraccionTemporal.setCoordenadaX(40);
		atraccionTemporal.setCoordenadaY(20);
		listaDeAtracciones.add(atraccionTemporal);
		
		Assert.assertEquals(listaDeAtracciones.get(0), miUsuario.buscarAtraccionMasCercana(0,0,listaDeAtracciones));
		
	}
	
	@Test 
	public void buscarAtraccionMasCercanaDesdeLaDireccionDelUsuario(){
		
		Usuario miUsuario = new Usuario();
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Atraccion atraccionTemporal = new Atraccion();
		
		atraccionTemporal.setTipo(TipoDeAtraccion.GONDOR);
		atraccionTemporal.setTiempoNecesarioParaVisita(10);
		atraccionTemporal.setCoordenadaX(10);
		atraccionTemporal.setCoordenadaY(15);
		listaDeAtracciones.add(atraccionTemporal);
		
		atraccionTemporal.setTipo(TipoDeAtraccion.MORDOR);
		atraccionTemporal.setTiempoNecesarioParaVisita(20);
		atraccionTemporal.setCoordenadaX(20);
		atraccionTemporal.setCoordenadaY(30);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo(TipoDeAtraccion.LA_COMARCA);
		atraccionTemporal.setTiempoNecesarioParaVisita(40);
		atraccionTemporal.setCoordenadaX(35);
		atraccionTemporal.setCoordenadaY(10);
		listaDeAtracciones.add(atraccionTemporal);

		atraccionTemporal.setTipo(TipoDeAtraccion.BOSQUE_ENCANTADO);
		atraccionTemporal.setTiempoNecesarioParaVisita(5);
		atraccionTemporal.setCoordenadaX(40);
		atraccionTemporal.setCoordenadaY(20);
		listaDeAtracciones.add(atraccionTemporal);
		
		Assert.assertEquals(listaDeAtracciones.get(0), miUsuario.buscarAtraccionMasCercana(miUsuario.getDireccionX(),miUsuario.getDireccionY(),listaDeAtracciones));
		
	} 
	


}
