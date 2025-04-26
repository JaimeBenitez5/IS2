package presentacion;

public class Evento {
	public static final int VISTA_MENU_PRINCIPAL = 000;
	// Eventos Cliente
	//Eventos de Vistas
	public static final int VISTA_CLIENTES = 101;
	public static final int VISTA_ALTA_CLIENTE = 102;
	public static final int VISTA_ELIMINAR_CLIENTE = 103;
	public static final int VISTA_MOSTRAR_CLIENTES = 104;
	public static final int VISTA_MOSTRAR_CLIENTE = 105;
	public static final int VISTA_MODIFICAR_CLIENTE = 106;
	//Eventos de Negocio
	public static final int ALTA_CLIENTE = 110;
	public static final int ELIMINAR_CLIENTE = 111;
	public static final int MOSTRAR_CLIENTES = 112;
	public static final int MODIFICAR_CLIENTE = 113;
	public static final int MOSTRAR_CLIENTE = 114;
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

	public static final int RES_MOSTRAR_CLIENTE_OK = 130;
	public static final int RES_MOSTRAR_CLIENTE_KO = 131;

	// Eventos Facturas
	//Eventos de Vistas
	public static final int VISTA_FACTURAS = 201;
	public static final int VISTA_ALTA_FACTURA = 202;
	public static final int VISTA_ELIMINAR_FACTURA = 203;
	public static final int VISTA_MOSTRAR_FACTURAS = 204;
	public static final int VISTA_MOSTRAR_FACTURA = 205;
	public static final int VISTA_MODIFICAR_FACTURA = 206;
	public static final int VISTA_MOSTRAR_FACTURAS_CLIENTE = 207;
	//Eventos de Negocio
	public static final int ALTA_FACTURA = 210;
	public static final int ELIMINAR_FACTURA = 211;
	public static final int MOSTRAR_FACTURA = 212;
	public static final int MODIFICAR_FACTURA = 213;
	public static final int MOSTRAR_FACTURAS = 214;
	public static final int MOSTRAR_FACTURAS_CLIENTE = 216;
	//Eventos de Respuesta
	public static final int RES_ALTA_FACTURA_OK = 220;
	public static final int RES_ALTA_FACTURA_KO = 221;

	public static final int RES_ELIMINAR_FACTURA_OK = 222;
	public static final int RES_ELIMINAR_FACTURA_KO = 223;

	public static final int RES_MODIFICAR_FACTURA_OK = 226;
	public static final int RES_MODIFICAR_FACTURA_KO = 227;

	public static final int RES_MOSTRAR_FACTURA_OK = 228;
	public static final int RES_MOSTRAR_FACTURA_KO = 229;

	public static final int RES_MOSTRAR_FACTURAS_OK = 230;
	public static final int RES_MOSTRAR_FACTURAS_KO = 231;
	
	public static final int RES_MOSTRAR_FACTURAS_CLIENTE_OK = 232;
	public static final int RES_MOSTRAR_FACTURAS_CLIENTE_KO = 233;

	// Eventos Salas
	//Eventos de Vistas
	public static final int VISTA_SALAS = 301;
	public static final int VISTA_ANADIR_SALAS = 302;
	public static final int VISTA_ELIMINAR_SALA = 303;
	public static final int VISTA_MOSTRAR_SALAS = 304;
	public static final int VISTA_MOSTRAR_SALA = 305;
	public static final int VISTA_MODIFICAR_SALA = 306;
	//Eventos de Negocio
	public static final int ALTA_SALA = 310;
	public static final int ELIMINAR_SALA = 311;
	public static final int MOSTRAR_SALAS = 312;
	public static final int MODIFICAR_SALA = 313;
	public static final int MOSTRAR_SALA = 314;
	public static final int BUSCAR_SALA = 315;
	//Eventos de Respuesta
	public static final int RES_ALTA_SALA_OK = 320;
	public static final int RES_ALTA_SALA_KO = 321;

	public static final int RES_ELIMINAR_SALA_OK = 322;
	public static final int RES_ELIMINAR_SALA_KO = 323;

	public static final int RES_BUSCAR_SALA_OK = 324;
	public static final int RES_BUSCAR_SALA_KO = 325;

	public static final int RES_MODIFICAR_SALA_OK = 326;
	public static final int RES_MODIFICAR_SALA_KO = 327;

	public static final int RES_MOSTRAR_SALAS_OK = 328;
	public static final int RES_MOSTRAR_SALAS_KO = 329;

	public static final int RES_MOSTRAR_SALA_OK = 330;
	public static final int RES_MOSTRAR_SALA_KO = 331;

	// Eventos Actividad
	//Eventos de Vistas
	public static final int VISTA_ACTIVIDADES = 401;
	public static final int VISTA_ANADIR_ACTIVIDAD = 402;
	public static final int VISTA_ELIMINAR_ACTIVIDAD = 403;
	public static final int VISTA_MOSTRAR_ACTIVIDADES = 404;
	public static final int VISTA_MOSTRAR_ACTIVIDAD = 405;
	public static final int VISTA_MODIFICAR_ACTIVIDAD = 406;
	//Eventos de Negocio
	public static final int ALTA_ACTIVIDAD = 410;
	public static final int ELIMINAR_ACTIVIDAD = 411;
	public static final int MOSTRAR_ACTIVIDADES = 412;
	public static final int MODIFICAR_ACTIVIDAD = 413;
	public static final int MOSTRAR_ACTIVIDAD = 414;
	public static final int BUSCAR_ACTIVIDAD = 415;
	//Eventos de Respuesta
	public static final int RES_ALTA_ACTIVIDAD_OK = 420;
	public static final int RES_ALTA_ACTIVIDAD_KO = 421;

	public static final int RES_ELIMINAR_ACTIVIDAD_OK = 422;
	public static final int RES_ELIMINAR_ACTIVIDAD_KO = 423;

	public static final int RES_BUSCAR_ACTIVIDAD_OK = 424;
	public static final int RES_BUSCAR_ACTIVIDAD_KO = 425;

	public static final int RES_MODIFICAR_ACTIVIDAD_OK = 426;
	public static final int RES_MODIFICAR_ACTIVIDAD_KO = 427;

	public static final int RES_MOSTRAR_ACTIVIDADES_OK = 428;
	public static final int RES_MOSTRAR_ACTIVIDADES_KO = 429;

	public static final int RES_MOSTRAR_ACTIVIDAD_OK = 430;
	public static final int RES_MOSTRAR_ACTIVIDAD_KO = 431;
	
	// Eventos Catálogos
	//Eventos de Vistas
	public static final int VISTA_CATALOGOS = 501;
	public static final int VISTA_ANADIR_CATALOGO = 502;
	public static final int VISTA_ELIMINAR_CATALOGO = 503;
	public static final int VISTA_MOSTRAR_CATALOGOS = 504;
	public static final int VISTA_MOSTRAR_CATALOGO = 505;
	public static final int VISTA_MODIFICAR_CATALOGO = 506;
	//Eventos de Negocio
	public static final int ALTA_CATALOGO = 510;
	public static final int ELIMINAR_CATALOGO = 511;
	public static final int MOSTRAR_CATALOGOS = 512;
	public static final int MODIFICAR_CATALOGO = 513;
	public static final int MOSTRAR_CATALOGO = 514;
	public static final int BUSCAR_CATALOGO = 515;
	//Eventos de Respuesta
	public static final int RES_ALTA_CATALOGO_OK = 520;
	public static final int RES_ALTA_CATALOGO_KO = 521;

	public static final int RES_ELIMINAR_CATALOGO_OK = 522;
	public static final int RES_ELIMINAR_CATALOGO_KO = 523;

	public static final int RES_BUSCAR_CATALOGO_OK = 524;
	public static final int RES_BUSCAR_CATALOGO_KO = 525;

	public static final int RES_MODIFICAR_CATALOGO_OK = 526;
	public static final int RES_MODIFICAR_CATALOGO_KO = 527;

	public static final int RES_MOSTRAR_CATALOGOS_OK = 528;
	public static final int RES_MOSTRAR_CATALOGOS_KO = 529;

	public static final int RES_MOSTRAR_CATALOGO_OK = 530;
	public static final int RES_MOSTRAR_CATALOGO_KO = 531;

	// Eventos Empleados
	//Eventos de Vistas
	public static final int VISTA_EMPLEADOS = 601;
	public static final int VISTA_ANADIR_EMPLEADO = 602;
	public static final int VISTA_ELIMINAR_EMPLEADO = 603;
	public static final int VISTA_MOSTRAR_EMPLEADOS = 604;
	public static final int VISTA_MOSTRAR_EMPLEADO = 605;
	public static final int VISTA_MODIFICAR_EMPLEADO = 606;
	//Eventos de Negocio
	public static final int ALTA_EMPLEADO = 610;
	public static final int ELIMINAR_EMPLEADO = 611;
	public static final int MOSTRAR_EMPLEADOS = 612;
	public static final int MODIFICAR_EMPLEADO = 613;
	public static final int MOSTRAR_EMPLEADO = 614;
	public static final int BUSCAR_EMPLEADO = 615;
	//Eventos de Respuesta
	public static final int RES_ALTA_EMPLEADO_OK = 620;
	public static final int RES_ALTA_EMPLEADO_KO = 621;

	public static final int RES_ELIMINAR_EMPLEADO_OK = 622;
	public static final int RES_ELIMINAR_EMPLEADO_KO = 623;

	public static final int RES_BUSCAR_EMPLEADO_OK = 624;
	public static final int RES_BUSCAR_EMPLEADO_KO = 625;

	public static final int RES_MODIFICAR_EMPLEADO_OK = 626;
	public static final int RES_MODIFICAR_EMPLEADO_KO = 627;

	public static final int RES_MOSTRAR_EMPLEADOS_OK = 628;
	public static final int RES_MOSTRAR_EMPLEADOS_KO = 629;

	public static final int RES_MOSTRAR_EMPLEADO_OK = 630;
	public static final int RES_MOSTRAR_EMPLEADO_KO = 631;
	
	// Eventos Suscripciones
	//Eventos de Vistas
	public static final int VISTA_SUSCRIPCIONES = 701;
	public static final int VISTA_ANADIR_SUSCRIPCION = 702;
	public static final int VISTA_ELIMINAR_SUSCRIPCION = 703;
	public static final int VISTA_MOSTRAR_SUSCRIPCION = 704;
	public static final int VISTA_MOSTRAR_SUSCRIPCIONES = 705;
	public static final int VISTA_MODIFICAR_SUSCRIPCION = 706;
	//Eventos de Negocio
	public static final int ALTA_SUSCRIPCION = 710;
	public static final int ELIMINAR_SUSCRIPCION = 711;
	public static final int MOSTRAR_SUSCRIPCION = 712;
	public static final int MODIFICAR_SUSCRIPCION = 713;
	public static final int MOSTRAR_SUSCRIPCIONES = 714;
	public static final int BUSCAR_SUSCRIPCION = 715;
	//Eventos de Respuesta
	public static final int RES_ALTA_SUSCRIPCION_OK = 720;
	public static final int RES_ALTA_SUSCRIPCION_KO = 721;

	public static final int RES_ELIMINAR_SUSCRIPCION_OK = 722;
	public static final int RES_ELIMINAR_SUSCRIPCION_KO = 723;

	public static final int RES_BUSCAR_SUSCRIPCION_OK = 724;
	public static final int RES_BUSCAR_SUSCRIPCION_KO = 725;

	public static final int RES_MODIFICAR_SUSCRIPCION_OK = 726;
	public static final int RES_MODIFICAR_SUSCRIPCION_KO = 727;

	public static final int RES_MOSTRAR_SUSCRIPCION_OK = 728;
	public static final int RES_MOSTRAR_SUSCRIPCION_KO = 729;

	public static final int RES_MOSTRAR_SUSCRIPCIONES_OK = 730;
	public static final int RES_MOSTRAR_SUSCRIPCIONES_KO = 731;

}
