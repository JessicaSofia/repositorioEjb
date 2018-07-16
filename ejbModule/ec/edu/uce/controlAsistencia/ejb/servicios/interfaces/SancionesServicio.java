package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.CategoriaFalta;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Falta;
import ec.edu.uce.controlAsistencia.jpa.entidades.Sancion;

public interface SancionesServicio {
	
	/**
	 * Inserta un Objeto de Tipo Sancion
	 * @param sancion
	 * @return
	 */
	public  boolean insertaSancion(DetallePuestoSancion  dtSancion);
	
	/**
	 * Actualiza un objeto de tipo Sancion
	 * @param sancion
	 * @return
	 */
	public DetallePuestoSancion actualizarSancion(DetallePuestoSancion  dtSancion);
	
	/***
	 * Obtiene una lista  de Tipo Sancion por DetallePuesto Id
	 * @param dtpsId
	 * @return
	 */
	public List<DetallePuestoSancion> listarSancionPorDetallePuestoId(int dtpsId);
	
/**
 * obtiene una lista de las Sanciones 
 * @return
 */
	public List<Sancion> listarSancion();
	
	/**
	 * Obtiene una lista de las faltas
	 * @return
	 */
	public List<Falta> listarFalta();
	
	
	public List<CategoriaFalta> listarcategoriaFaltaPorCategoriaIdFaltaId(int ctgId, int ftId);
	
	
	
}
