package ec.edu.uce.controlAsistencia.ejb.datos;

public enum ParametrosVacacion {

	NumDiasxAnio(1),
	NumFinesSemana(3),
	NumDiasLaborables(4),
	AniooAcumulador(5),
	NumMaxDiasAnticipados(6);
	
	private final int id;


	ParametrosVacacion(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	

	
}
