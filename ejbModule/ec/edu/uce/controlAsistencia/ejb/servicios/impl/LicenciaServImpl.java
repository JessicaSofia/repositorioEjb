package ec.edu.uce.controlAsistencia.ejb.servicios.impl;


import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.jpa.entidades.Licencia;
import ec.edu.uce.controlAsistencia.jpa.entidades.Vacacion;

@Stateless
public class LicenciaServImpl implements ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.LicenciaServicio {
	
	public LicenciaServImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	/*@Resource(lookup = "java:/talentoHumanoDS")
	private DataSource ds;
	/*variables*/
	
	
	
	
	@Override
	public boolean LicenciaInsertar(Licencia licencia) {
		
		boolean retorno = false;
		try {
			em.persist(licencia);
			retorno= true;
			
		}catch(Exception  e){
			throw e;
			                                        
		}
		return retorno;
	}
	

	@Override
	public Licencia LicenciaActualizar(Licencia licencia) {
		Licencia retorno=null;
		try{
			
			retorno=em.merge(licencia);
		}catch(Exception e ) {
			throw e;
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
				sbsql.append(" select  case when Max(lp.lcnNumLicencia) is null then 0 else Max(lp.lcnNumLicencia)  end from Licencia lp");
				sbsql.append(" WHERE   year(lp.lcnFechaEmision) = :anioActual)");
				sbsql.append(" AND lp.lcnEstado=1");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("anioActual",anioactual);
				numMaxima = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return numMaxima;
	}


	@SuppressWarnings("unchecked")
 	public List<Licencia> ListaLicenciaPorDetallePuestoId(int detallePuestoId) {
		List<Licencia> listaLicencia = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("Select lp from Licencia lp where");
		sbsql.append(" lp.dtpsId = :detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		listaLicencia = (List<Licencia>)q.getResultList();

		}catch(Exception  e){
			throw  e; 
		}
		return listaLicencia;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Licencia> ObtenerLstPorAnioMes(int anio, int mes) {
		List<Licencia> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select lc from Licencia lc where");
		sbsql.append(" year(lc.lcnFechaInicio) = :anio ");
		sbsql.append(" and month(lc.lcnFechaInicio)= :mes");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		retorno = (List<Licencia>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
	}

}
