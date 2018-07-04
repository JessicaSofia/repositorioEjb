package ec.edu.uce.controlAsistencia.ejb.datos;

public enum Estados {

	Activo(1),
	Anulado(2),
	Eliminado(3);
			
	private int id;
	
	

	private Estados(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
