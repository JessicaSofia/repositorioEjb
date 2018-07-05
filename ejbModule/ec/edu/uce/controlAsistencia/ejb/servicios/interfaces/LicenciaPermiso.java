package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.LicenciaYPermiso;


public interface LicenciaPermiso { 
	
	
	/***
	 * Inserta un objeto de Tipo LicenciaYPermiso
	 * @param licenciaPermiso
	 * @return
	 */
	public boolean  LicenciaPermisoInsertar(LicenciaYPermiso licenciaPermiso);
	
	/***
	 * Obtiene una lista de Tipo LicenciaPermiso Por DetallePuestoId
	 * @param detallePuestoId
	 * @return
	 */
	public List<LicenciaYPermiso > ListaLicenciaYPermisoPorDetallePuestoId(int  detallePuestoId );
	
	/***
	 * Actualiza un objet de Tipo licenciaYPermiso
	 * @param licenciaYPermiso
	 * @return
	 */
	public LicenciaYPermiso LicenciaYPermisoActualizar(LicenciaYPermiso licenciaYPermiso );
	
	 /***
	  * Obtiene el Numero de Autorizacion de una licenciaYPermio
	  * @return
	  */
	public int  MaximaNumAutorizacion();

}
