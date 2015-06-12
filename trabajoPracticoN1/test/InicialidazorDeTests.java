
public class InicialidazorDeTests {
	
	public Usuario usuario;
	public Atraccion[] vectorDeAtracciones;
	public Paquete paquete;
	
	public InicialidazorDeTests(){
	
		usuario = new Usuario();
		paquete = new Paquete();
		paquete.setUsuarioDelPaquete(usuario);
		vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};
	
		usuario.setDireccionX(0);
		usuario.setDireccionY(0);
		usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.GONDOR);
		usuario.setPresupuesto(4000);
		usuario.setTiempoDisponibleParaVisitas(168);
		usuario.setVelocidadDeTraslado(10);
		
		vectorDeAtracciones[0].setTipo(TipoDeAtraccion.GONDOR);
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(100);
		vectorDeAtracciones[0].setCoordenadaY(200);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo(TipoDeAtraccion.MORDOR);
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(200);
		vectorDeAtracciones[1].setCoordenadaY(300);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo(TipoDeAtraccion.LA_COMARCA);
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(400);
		vectorDeAtracciones[2].setCoordenadaY(600);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[3].setTipo(TipoDeAtraccion.BOSQUE_ENCANTADO);
		vectorDeAtracciones[3].setCosto(700);
		vectorDeAtracciones[3].setTiempoNecesarioParaVisita(5);
		vectorDeAtracciones[3].setCoordenadaX(150);
		vectorDeAtracciones[3].setCoordenadaY(300);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[4].setTipo(TipoDeAtraccion.PASEO_DE_AVENTURA);
		vectorDeAtracciones[4].setCosto(800);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(30);
		vectorDeAtracciones[4].setCoordenadaX(250);
		vectorDeAtracciones[4].setCoordenadaY(100);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[5].setTipo(TipoDeAtraccion.MINAS_TIRITH);
		vectorDeAtracciones[5].setCosto(1500);
		vectorDeAtracciones[5].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[5].setCoordenadaX(400);
		vectorDeAtracciones[5].setCoordenadaY(350);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[6].setTipo(TipoDeAtraccion.TORRE);
		vectorDeAtracciones[6].setCosto(350);
		vectorDeAtracciones[6].setTiempoNecesarioParaVisita(15);
		vectorDeAtracciones[6].setCoordenadaX(500);
		vectorDeAtracciones[6].setCoordenadaY(100);
		
		//Se agregan todas las promociones disponibles al paquete
		paquete.agregarPromocionDisponible(new PromocionPorcentual(30, 10));
		paquete.agregarPromocionDisponible(new PromocionAbsoluta(30, (double) 200));
		paquete.agregarPromocionDisponible(new PromocionAxB(30));
		paquete.agregarPromocionDisponible(new PromocionFamiliar(30));
		paquete.agregarPromocionDisponible(new PromocionExtranjero(30));

		//Agrego 1 atraccion al tipo Promocion por porcentaje
		paquete.getListaDePromocionesDisponibles().get(0).addAtraccion(vectorDeAtracciones[1]);
				
		//Agrego varias atracciones al tipo de Promo Promocion Absoluta
		paquete.getListaDePromocionesDisponibles().get(1).addAtraccion(vectorDeAtracciones[1]);
		paquete.getListaDePromocionesDisponibles().get(1).addAtraccion(vectorDeAtracciones[4]);
		paquete.getListaDePromocionesDisponibles().get(1).addAtraccion(vectorDeAtracciones[5]);
		
		//Agrego 4 atracciones al tipo AxB
		paquete.getListaDePromocionesDisponibles().get(2).addAtraccion(vectorDeAtracciones[0]);
		paquete.getListaDePromocionesDisponibles().get(2).addAtraccion(vectorDeAtracciones[1]);
		paquete.getListaDePromocionesDisponibles().get(2).addAtraccion(vectorDeAtracciones[4]);
		paquete.getListaDePromocionesDisponibles().get(2).addAtraccion(vectorDeAtracciones[5]);
		
		
	}
	
	// Getters & Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public Atraccion[] getVectorDeAtracciones() {
		return vectorDeAtracciones;
	}

	public Paquete getPaquete() {
		return paquete;
	}

}
