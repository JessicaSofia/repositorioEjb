package ec.edu.uce.controlAsistencia.ejb.datos;

public enum ParametrosVacacion {

	NumDiasxAño(1),
	NumFinesSemana(3),
	NumDiasLaborables(4),
	AñoAcumulador(5),
	NumMaxDiasAnticipados(6);
	
	private final int id;

	ParametrosVacacion(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}

	
}
