package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import ec.edu.uce.controlAsistencia.jpa.entidades.Puesto;

public interface PuestoServicio {

	/****
	 * Busca un objeto de tipo Puesto por id
	 * @param id
	 * @return
	 */
	public Puesto BuscarPorId(int id);
}
