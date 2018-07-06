package ec.edu.uce.controlAsistencia.ejb.datos;

public enum ParametrosVacacion {

	NumDiasxAño(1),
	NumDiasConFinSemana(2),
	AñoAcumulador(3);
	
	
	private final int id;

	ParametrosVacacion(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}

	
}
