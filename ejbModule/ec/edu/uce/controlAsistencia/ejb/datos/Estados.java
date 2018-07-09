package ec.edu.uce.controlAsistencia.ejb.datos;

public enum Estados {

	Activo(1),
	DesActivo(0),
	Anulado(3),
	Eliminado(4);
			
	private final int id;
	
	
	 Estados(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	
	
}
