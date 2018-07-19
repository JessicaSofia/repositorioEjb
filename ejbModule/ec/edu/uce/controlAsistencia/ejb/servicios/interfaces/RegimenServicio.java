package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.Regimen;

public interface RegimenServicio {

	/***
	 * Obtiene un Objeto de Tipo Regimen por id;
	 * @param id
	 * @return
	 */
	public Regimen BuscarPorId(int id);
	
	public List<Regimen> ObtenerLstTodos();
}
