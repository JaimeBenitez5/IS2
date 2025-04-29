package presentacion;

public class Comprobaciones {
	public static boolean esDNIValido(String dni) {
	    if (dni == null || dni.length() != 9) return false;
	    String numeros = dni.substring(0, 8);
	    char letra = dni.charAt(8);
	    return numeros.matches("\\d{8}") && Character.isLetter(letra);
	}
}
