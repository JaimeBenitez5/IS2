package negocio;

public class DTOtRol {
	private int _idRol;
	private String _nombreRol;
	private double _salario;
	
	public DTOtRol(final int idRol, final String nombreRol,final double salario) {
		_idRol = idRol;
		_nombreRol = nombreRol;
		_salario = salario;
	}
	
	public DTOtRol(final String nombreRol) {
		_idRol = castIdRol(nombreRol);
		_nombreRol = nombreRol;
		_salario = 0;
	}
	
	private int castIdRol(final String nombreRol) {
		int idRol = 0; 
		
		if(nombreRol == "MANTENIMIENTO") {
			idRol = 1;
		}
		else if(nombreRol == "MONITOR") {
			idRol = 2;
		}
		else if(nombreRol == "NUTRICIONISTA") {
			idRol = 3;
		}
		else if(nombreRol == "RECEPCION") {
			idRol = 4;
		}
		return idRol;
	}
	
	public int getIdRol() {
		return _idRol;
	}

	public String getNombreRol() {
		return _nombreRol;
	}
	
	public double getSalario() {
		return _salario;
	}

	public void setIdRol(final int idRol) {
		_idRol = idRol;
	}
	
	public void setNombreRol(final String nombreRol) {
		_nombreRol = nombreRol;
	}
	
	public void setSalario(final double salario) {
		_salario = salario;
	}   
	
	public String toString() {
        return  _idRol + " " + _nombreRol + " " + _salario;
    }
}
