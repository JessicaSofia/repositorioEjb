package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;


import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.Dependencia;

public interface DependenciaServicio {

	
	public Dependencia ObtenerPorId(int i);
	
	public List<Dependencia> obtenerListTodo();
	

	public String obtenerNombreDependenciaporDetallePuestoId(int dpstId);
}
