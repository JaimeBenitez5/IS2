package presentacion;

public class Evento {

	public static final int VISTA_MENU_PRINCIPAL = 000;
	// Eventos Cliente

	//Eventos de Vistas
	public static final int VISTA_CLIENTE = 101;
	public static final int VISTA_ALTA_CLIENTE = 102;
	public static final int VISTA_ELIMINAR_CLIENTE = 103;
	public static final int VISTA_MOSTRAR_CLIENTES = 104;
	public static final int VISTA_MOSTRAR_CLIENTE = 105;
	public static final int VISTA_MODIFICAR_CLIENTE = 106;
	
	// Eventos de Negocio
	public static final int ALTA_CLIENTE = 110;
	public static final int ELIMINAR_CLIENTE = 111;
	public static final int MOSTRAR_CLIENTES = 112;
	public static final int MODIFICAR_CLIENTE = 13;
	public static final int MOSTRAR_CLIENTE = 114;
	public static final int BUSCAR_CLIENTE = 114;
	
	//Eventos de Respuesta
	public static final int RES_ALTA_CLIENTE_OK = 120;
	public static final int RES_ALTA_CLIENTE_KO = 121;
	
	public static final int RES_ELIMINAR_CLIENTE_OK = 122;
	public static final int RES_ELIMINAR_CLIENTE_KO = 123;
	
	public static final int RES_BUSCAR_CLIENTE_OK = 124;
	public static final int RES_BUSCAR_CLIENTE_KO = 125;
	
	public static final int RES_MODIFICAR_CLIENTE_OK = 126;
	public static final int RES_MODIFICAR_CLIENTE_KO = 127;
	
	public static final int RES_MOSTRAR_CLIENTES_OK = 128;
	public static final int RES_MOSTRAR_CLIENTES_KO = 129;
	
	
	
	// Evento Producto
	public static final int ALTA_PRODUCTO = 105;
	// ..
	public static final int RES_ALTA_PRODUCTO_OK = 402;
	public static final int RES_ALTA_PRODUCTO_KO = 403;
	// ..
	public static final int RES_ELIMINAR_PRODUCTO_OK = 502;
	// .. 

}
