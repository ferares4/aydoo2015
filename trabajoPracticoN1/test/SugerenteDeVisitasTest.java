import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class SugerenteDeVisitasTest {
	
	@Test
	public void sugerirVisita(){
		
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Usuario miUsuario = new Usuario();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Usuario de Prueba
		miUsuario.setTipoDeAtraccionPreferida("Museo");
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitasEnMinutos(180);
		
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Museo");
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo("Paisaje De Aventura");
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo("Paseo de Tarde");
		vectorDeAtracciones[4].setCosto(150);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		Assert.assertTrue(listaDeAtracciones.isEmpty());
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(miUsuario,vectorDeAtracciones,null);
		listaDeAtracciones = miSugerente.sugerirVisita();
		
		Assert.assertFalse(listaDeAtracciones.isEmpty());
		
		Iterator<Atraccion> iteradorDeLista = listaDeAtracciones.iterator();
		Assert.assertTrue(iteradorDeLista.hasNext());		
		
		/*
		while (iteradorDeLista.hasNext()){
			
			System.out.println(iteradorDeLista.next().getTipo());
			
			
		}
		*/
		
	}
	
	@Test
	public void sugerirVisitaConPromocionPorcentual(){
		
				
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Museo");
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitasEnMinutos(180);
				
		//Configuracion de atracciones
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Museo");
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo("Paisaje De Aventura");
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo("Paseo de Tarde");
		vectorDeAtracciones[4].setCosto(150);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisitaEnMinutos(150);
		
		//Configuracion de promocion de ejemplo
		Promocion promocion1 = new Promocion(tipoDePromocion.PROMOCION_PORCENTUAL, 10);
		promocion1.setAtracciones(vectorDeAtracciones[1]);
		
		//Configuracion del sugerente de visitas
		Promocion[] vectorDePromocionesParaSugerenteDeVisitas = new Promocion[]{promocion1};
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(miUsuario,vectorDeAtracciones,vectorDePromocionesParaSugerenteDeVisitas);
				
		Assert.assertEquals(promocion1, miSugerente.buscarAtraccionEnPromocionesVigentes(vectorDeAtracciones[1]));
		Assert.assertEquals(null, vectorDeAtracciones[1].getPromocionesAplicables());
		
		miSugerente.sugerirVisita();
		Assert.assertTrue(vectorDeAtracciones[1].getPromocionesAplicables().contains(promocion1));
		
		
		
		
		
	}

}
