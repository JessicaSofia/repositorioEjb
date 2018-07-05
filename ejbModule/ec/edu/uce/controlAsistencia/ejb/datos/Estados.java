package ec.edu.uce.controlAsistencia.ejb.datos;

public enum Estados {

	Activo(1),
	Anulado(2),
	Eliminado(0);
			
	private final int id;
	
	
	 Estados(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	
	
}
