import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Test;


public class SugerenteDeVisitasTest {
	
	@Test
	public void sugerirVisita(){
		
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Usuario miUsuario = new Usuario();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Usuario de Prueba
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitas(180);
		
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Gondor");
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo("Paisaje De Aventura");
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo("Paseo de Tarde");
		vectorDeAtracciones[4].setCosto(150);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(150);
		
		Assert.assertTrue(listaDeAtracciones.isEmpty());
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones,null);
		listaDeAtracciones = miSugerente.sugerirVisita(miUsuario);
		
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
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitas(180);
				
		//Configuracion de atracciones
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Gondor");
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo("Paisaje De Aventura");
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo("Paseo de Tarde");
		vectorDeAtracciones[4].setCosto(150);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de promocion de ejemplo
		Promocion promocion1 = new Promocion(tipoDePromocion.PROMOCION_PORCENTUAL, 10);
		promocion1.setAtracciones(vectorDeAtracciones[1]);
		
		//Configuracion del sugerente de visitas
		Promocion[] vectorDePromocionesParaSugerenteDeVisitas = new Promocion[]{promocion1};
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones,vectorDePromocionesParaSugerenteDeVisitas);
				
		Assert.assertEquals(promocion1, miSugerente.buscarAtraccionEnPromocionesVigentes(vectorDeAtracciones[1]));
		Assert.assertEquals(null, vectorDeAtracciones[1].getPromocionesAplicables());
		
		miSugerente.sugerirVisita(miUsuario);
		Assert.assertTrue(vectorDeAtracciones[1].getPromocionesAplicables().contains(promocion1));
		
		
		
		
		
	}
	
	@Test
	public void sugerirItinerarios(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
				
		//Configuracion de atracciones
		List<Atraccion> ListaDeAtracciones;
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[0].setTipo("Gondor");
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Mordor");
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo("La Comarca");
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[3].setTipo("Bosque Encantado");
		vectorDeAtracciones[3].setCosto(700);
		vectorDeAtracciones[3].setTiempoNecesarioParaVisita(5);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[4].setTipo("Paseo de Aventura");
		vectorDeAtracciones[4].setCosto(800);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(30);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[5].setTipo("Minas Tirith");
		vectorDeAtracciones[5].setCosto(1500);
		vectorDeAtracciones[5].setTiempoNecesarioParaVisita(10);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[6].setTipo("Torre");
		vectorDeAtracciones[6].setCosto(350);
		vectorDeAtracciones[6].setTiempoNecesarioParaVisita(15);
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones,null);
		
		miSugerente.sugerirVisita(miUsuario);
		miSugerente.sugerirItinerarioPorCosto(miUsuario);
		
		
		ListaDeAtracciones = miSugerente.sugerirItinerarioPorCosto(miUsuario);
		
//		Iterator<Atraccion> iterador = ListaDeAtracciones.iterator();
//		while (iterador.hasNext()){System.out.println(iterador.next().getTipo());}

		ListaDeAtracciones = miSugerente.sugerirItinerarioPorTiempo(miUsuario);

//		Iterator<Atraccion> iterador2 = ListaDeAtracciones.iterator();
//		while (iterador2.hasNext()){System.out.println(iterador2.next().getTipo());}		
		
		
		
	}

}
