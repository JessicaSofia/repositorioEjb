package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.VacacionServicio;

import ec.edu.uce.controlAsistencia.jpa.entidades.SaldoVacacion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Vacacion;

import java.util.Calendar;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Session Bean implementation class RegistroVacaionesServicioImpl
 */
@Stateless
public class VacacionServicioImpl implements  VacacionServicio {

	/**
	 * 
	 */
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public VacacionServicioImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean VacionInsertar(Vacacion vacacion) {
		boolean retorno = false;
		try {
			em.persist(vacacion);
			retorno= true;
			
		}catch(Exception  e){
			return false;
			                                        
		}
		return retorno;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vacacion> ListaVacacionesPorDetallePuestoId(int detallePuestoId) {

		List<Vacacion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select vc from Vacacion vc where");
		sbsql.append(" vc.dtpsId = :detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		retorno = (List<Vacacion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}
	

	@Override
	public Vacacion VacacionActualizar(Vacacion vacacion) {
		Vacacion retorno=null;
		try{
			
			retorno=em.merge(vacacion);
		}catch(Exception e ) {
			throw e;
		}
		return retorno;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaldoVacacion> listSaldoVacacionPorDetallePuestoId(int detallePuestoId) {
		
		List<SaldoVacacion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select svc from SaldoVacacion svc where");
		sbsql.append(" svc.dtpsId =  :detallePuestoId  and svc.slvcEstado != 0");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		retorno = (List<SaldoVacacion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}

	@Override
	public int MaximaNumAutorizacion() {
		 int  numMaxima=0;
		 try{
			 
			 Calendar fechaFinal = Calendar.getInstance();
			 int anioactual=fechaFinal.get(Calendar.YEAR);
				StringBuffer sbsql = new StringBuffer();
				sbsql.append(" select  case when Max(vc.vccNumAutorizacion) is null then 0 else Max(vc.vccNumAutorizacion)  end from Vacacion  vc");
				sbsql.append(" WHERE   year(vc.vccFechaEmision) = :anioActual)");
				sbsql.append(" AND vc.vccEstado=1");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("anioActual",anioactual);
				numMaxima = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return numMaxima;
	}

	@Override
	public SaldoVacacion  ObtenerSaldoVacacionPorPeriodo(int periodo, int dtpsId) {
		SaldoVacacion saldoVacacionPeriodo=null;
			   try{
				   StringBuffer sbsql = new StringBuffer();
					sbsql.append(" select svc from SaldoVacacion  svc");
					sbsql.append(" WHERE  svc.slvcPeriodo = :periodo and svc.detallePuesto.dtpsId= :dtpsId)");
					sbsql.append(" AND  svc.slvcEstado = 1)");
					Query q = em.createQuery(sbsql.toString(), SaldoVacacion.class);
					q.setParameter("periodo",periodo);
					q.setParameter("dtpsId", dtpsId);
					saldoVacacionPeriodo=(SaldoVacacion) q.getSingleResult();
						
					
				}catch(Exception e){
					return null;      
					
				}
		 return saldoVacacionPeriodo;
		
	}

	@Override
	public SaldoVacacion ActualizarSaldoVacacion(SaldoVacacion saldoVacacion) {
		SaldoVacacion retorno= null;
		try {
			 retorno=em.merge(saldoVacacion);
			 
		}catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	@Override
	public boolean SaldoVacacionInsertar(SaldoVacacion saldoVacacion) {
		boolean retorno = false;
		try {
			em.persist(saldoVacacion);
			retorno= true;
		}catch (Exception e) {
			throw e;
	
		}
		return retorno;
	}

	@Override
	public int contarRegistros(int dtpsId) {
		int resultado=0;
		 try{
			   StringBuffer sbsql = new StringBuffer();
				sbsql.append(" select count(svc) from SaldoVacacion  svc");
				sbsql.append(" WHERE svc.dtpsId= :dtpsId)");
				sbsql.append(" AND  svc.slvcEstado = 1)");
				Query q = em.createQuery(sbsql.toString(), SaldoVacacion.class);
				q.setParameter("dtpsId", dtpsId);
				resultado = (int) q.getSingleResult();
				
			}catch(Exception e){
				  
				throw  e; 
			}
		
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vacacion> ObtenerLstPorAnioMes(int mes, int anio) {
		List<Vacacion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select vc from Vacacion vc where");
		sbsql.append(" year(vc.vccFechaInicio) = :anio ");
		sbsql.append(" and month(vc.vccFechaInicio)= :mes");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		retorno = (List<Vacacion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
	}

}
