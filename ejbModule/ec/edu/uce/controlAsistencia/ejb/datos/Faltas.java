package ec.edu.uce.controlAsistencia.ejb.datos;

public enum Faltas {

	Atrasos(1),
	AbandonodeTrabajo(2),
	SalidaAntesdeHorario(3);
	
	
	
	Faltas(int id) {
		this.id = id;
	}

	private int  id;

	public int getId() {
		return id;
	}

	
	
}
