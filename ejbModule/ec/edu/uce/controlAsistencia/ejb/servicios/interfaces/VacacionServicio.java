package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.SaldoVacacion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Sancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Vacacion;

public interface VacacionServicio  {

	/**
	 * Inserta un  nuevo Objeto de Tipo Vacacion 
	 * @param vacacion 
	 */
	public boolean  VacionInsertar(Vacacion vacacion);
	
	/**
	 * 
	 * @param detallePuestoId
	 * @return
	 */
	public List<Vacacion> ListaVacacionesPorDetallePuestoId(int  detallePuestoId );
	
	/**
	 *  Actualiza un Objeto de Tipo vacacion
	 * @param vacacion
	 */
	public Vacacion VacacionActualizar(Vacacion  vacacion);
	
	/**
	 * Obtiene  una lista de Todos los saldos de Vacaciones de Periodos Activos
	 * @param DetallePuestoId
	 * @return
	 */
	public List<SaldoVacacion> listSaldoVacacionPorDetallePuestoId(int DetallePuestoId);
	
	/**
	 * Obtiene el registro con  el mumero Maximo de Autorizacion 
	 * @return
	 */
	public int  MaximaNumAutorizacion();
	
	/**
	 * obtiene un objeto de Tipo saldo   Vacacion Por periodo y por detallePuestoId
	 * @param periodo
	 */
	public SaldoVacacion  ObtenerSaldoVacacionPorPeriodo( int periodo, int dtpsId);
	
	/**
	 * Actualiza un objeto de tipo SaldoVacacion
	 * @param saldoVacacion
	 * @return
	 */
	 public SaldoVacacion  ActualizarSaldoVacacion(SaldoVacacion saldoVacacion); 
	 
	 /**
	  * Insercion de de un objeto de tipo Saldo Vacacion 
	  * @param saldoVacacion
	  * @return
	  */
	 public boolean SaldoVacacionInsertar(SaldoVacacion  saldoVacacion );
	 
	 /**
	  * Obtiene el numero de registro de la tabla saldo vacacion asociado un funcionario
	  */
	 
	 public int contarRegistros(int dtpsId);
	 
	
	/**
	 * Obtiene una  lista de Vacaciones filtrado por Mes y Año
	 * @param mes
	 * @param anio
	 * @return
	 */
	 public List<Vacacion> ObtenerLstPorAnioMes(int mes, int anio);
	
}
  