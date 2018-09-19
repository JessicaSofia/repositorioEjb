package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.ejb.datos.ReporteSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.CategoriaFalta;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Falta;
import ec.edu.uce.controlAsistencia.jpa.entidades.Sancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.TipoSancion;

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
	
	public Sancion obtenerSancionPorNivelPorTipoSancion(int nivel, int tpSnId);
	
	/**
	 * Obtiene una lista de las faltas
	 * @return
	 */
	public List<Falta> listarFalta();
	
	public Falta ObtenerFaltaPorNombre(String Nombre);
	
	
	/**
	 * Lista todos por parametros por CategoriaId y  faltaId
	 * @param ctgId
	 * @param ftId
	 * @return
	 */
	public List<CategoriaFalta> listarcategoriaFaltaPorCategoriaIdFaltaId(int ctgId, int ftId);
	
	/**
	 * Obtiene parametros de sanciones por rgmId y FaltaId
	 * @param rgmId
	 * @param ftId
	 * @return
	 */
	public List<CategoriaFalta> listarcategoriaFaltaPorRgmIdFaltaId(int rgmId, int ftId);
	
	
	
	/**
	 * Genera el  numero de Accion 
	 * @return
	 */
	public int MaximaNumAutorizacion(int tpSanId);
	
	/**
	 * Obtine la entidad falta por FaltaId
	 * @param flId
	 * @return
	 */
	public Falta  ObtenerFaltaPorI(int flId);
	
	/**
	 * Obtiene una entidad de tipo Sancion por SancionId
	 * @param snId
	 * @return
	 */
	public Sancion ObtenerSancionPorId(int snId);
	
	/**
	 *Obtiene una lista de sanciones por el TipoSancionId 
	 * @param tpSnId
	 * @return
	 */
	public List<Sancion>  ObtenerLstSancionPorTipoSancionId(int tpSnId);
	
	
	/**
	 * Obtine una lista de todas los tipos de sanciones
	 * @return
	 */
	public List<TipoSancion> ObtenerLstTipoSancionTodo();
	
	/**
	 * Obtine un Lista de Sanciones
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionTodos();
	
	
	
	/**
	 * Obtiene una Lista de DetallePuestoSancion Filtrado  por Año, Mes, Regimen y Tipo de Sancion 
	 * @param anio
	 * @param mes
	 * @param rgmId
	 * @param tpsnId
	 * @return
	 */
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int  anio, int mes, int  rgmId, int  tpsnId);
	
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionIdNoAgrupado(int  anio, int mes, int  rgmId, int  tpsnId);
	
	
	public String DiasSancionPorTpSancionIdFaltaId(int tpSnId, int flId, int dtpsId, int anio, int mes);
	
	public List<ReporteSancion> listarDtSancionAnualPorAnioMes(int anioInicio, int mesInicio, int  anioFin, int mesFin);
	
	
	 
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesRegimenIdTipoSancionId(int anioInicio, int mesInicio, int rgmId, int tpSnId, int anioFin, int mesFin);
	       

	/**
	 * Obtiene  un objeto de tipo sancion siendo este el ultimo aplicado por detallePuestoId
	 * @param tpSn
	 * @return
	 */
	public DetallePuestoSancion obtenerUltimaSancion(int dtpsId, int tpsnId, int anio, int mes );
	
	/**
	 * Obtiene un objeto de tipo DetallePuestoSancion por tpSancion y Falta
	 * @param dtpsId
	 * @param tpsnId
	 * @param fltId
	 * @return
	 */
	public DetallePuestoSancion obtenerUltimaSancionPorTpSancionFaltaId(int dtpsId, int tpsnId, int fltId );
	
	/**
	 * Obtine un entidad dee tipo DetallePuestoSancion por Mes, anio, categoriaFalta y detallePuesto Id
	 * @param dtpsId
	 * @param ctgflId
	 * @param mes
	 * @param anio
	 * @return
	 */
	public DetallePuestoSancion obtenerSancionPorMesAnio(int dtpsId,int ctgflId, int mes,int anio, int snId);
	
	/**
	 * Obtner sueldo por dtpsId
	 * @param dtpsId
	 * @return
	 */
	public  int ObtnerSueldoPorDetallePuestoId(int dtpsId);
	

	/***
	 * Obtiene una lista  todas las multas por DetallePuesto Id
	 * @param dtpsId
	 * @return
	 */
	public List<DetallePuestoSancion> listarSancionMultasPorDetallePuestoId(int dtpsId, int dtpssnMes, int dtpssnAno);
	
	
	/***
	 * 
	 * @param dtpsId
	 * @param mes
	 * @param anio
	 * @param tpSnId
	 * @return
	 */
	public List<String>  listarfaltasPorDtPuestoIdMesAnioTipoSancion(int dtpsId, int mes, int  anio, int tpSnId);
	
	/***
	 * Obtiene la partida presupuestaria de un empleado por DetallePuestoId
	 * @param dtpsId
	 * @return
	 */
	public  String obtenerPartidaPresupuestariaPorDetallePuestoId(int dtpsId);
	
	/**
	 * Obtiene la partida Individual de un empleado por DetalllePuestoId
	 * @param dtpsId
	 * @return
	 */
	public String obtenerPartidaIndividualPorDetallePuestoId(int dtpsId);
	
}
