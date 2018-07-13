package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.Permiso;

public interface PermisoServicio {
	
	/***
	 * Obtiene una lista de Tipo LicenciaPermiso Por DetallePuestoId
	 * @param detallePuestoId
	 * @return
	 */
	public List<Permiso> ListaPermisoPorDetallePuestoId(int  detallePuestoId );
	
	

}
