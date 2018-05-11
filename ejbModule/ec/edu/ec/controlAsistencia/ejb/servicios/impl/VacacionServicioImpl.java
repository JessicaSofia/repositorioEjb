package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.VacacionServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuesto;
import ec.edu.uce.controlAsistencia.jpa.entidades.SaldoVacacion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Vacacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.mail.handlers.text_html;

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
	public void VacionInsertar(Vacacion vacacion) {
		try {
			em.persist(vacacion);
			
		}catch(Exception  e){
			throw e;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vacacion> ListaVacacionesPorDetallePuestoId(int detallePuestoId) {

		List<Vacacion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select vc from Vacacion vc where");
		sbsql.append(" vc.DetallePuesto.dtpsId =: detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		retorno = (List<Vacacion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}
	

	@Override
	public void VacacionActualizar(Vacacion vacacion) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaldoVacacion> listSaldoVacacionPorDetallePuestoId(int detallePuestoId) {
		
		List<SaldoVacacion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select svc from SaldoVacacion svc where");
		sbsql.append(" svc.DetallePuesto.dtpsId =: detallePuestoId");
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
				sbsql.append(" select Max(vc.vccNumAutorizacion) from Vacacion  vc");
				sbsql.append(" WHERE  day(vc.vccFechaEmision) =: anioActual)");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("AnioActual",anioactual);
				numMaxima = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return numMaxima;
	}

	

	
	
    
    

}
