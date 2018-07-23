package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.SancionesServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.CategoriaFalta;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Falta;
import ec.edu.uce.controlAsistencia.jpa.entidades.Permiso;
import ec.edu.uce.controlAsistencia.jpa.entidades.Sancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.TipoSancion;


@Stateless
public class SancionesServicioImpl implements SancionesServicio {

	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
    
	@Override
	public boolean insertaSancion(DetallePuestoSancion dtSancion) {
		boolean retorno =false;
		try {
			
			em.persist(dtSancion);
		}catch (Exception e) {
			retorno=true;
			throw e;
		}
		return retorno;
	}

	@Override
	public DetallePuestoSancion actualizarSancion(DetallePuestoSancion dtSancion) {
		DetallePuestoSancion retorno=null;
		try {
			
			em.merge(dtSancion);
		}catch (Exception e) {
			throw e;
		}
		return retorno;
	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarSancionPorDetallePuestoId(int dtpsId) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps where");
		sbsql.append(" dps.detallePuesto.dtpsId = :detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",dtpsId);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sancion> listarSancion() {
		List<Sancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select sn from Sancion sn");
		Query q = em.createQuery(sbsql.toString());
		retorno = (List<Sancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Falta> listarFalta() {
		
		List<Falta> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select fl from Falta fl");
		Query q = em.createQuery(sbsql.toString());
		retorno = ((List<Falta>)q.getResultList());
	
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaFalta> listarcategoriaFaltaPorCategoriaIdFaltaId(int ctgId, int ftId) {
		
		List<CategoriaFalta> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select ctf from CategoriaFalta ctf where");
		sbsql.append(" ctf.categoria.ctgId= :ctgId");
		sbsql.append(" and ctf.falta.flId= :flId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("ctgId",ctgId);
		q.setParameter("flId",ftId);
		retorno = (List<CategoriaFalta>)q.getResultList();
	
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
				sbsql.append(" select  case when Max(dtpssn.dtpssnNumaccion) is null then 0 else Max(dtpssn.dtpssnNumaccion)  end from DetallePuestoSancion  dtpssn");
				sbsql.append(" WHERE   year(dtpssn.dtpssnFechaEmision) = :anioActual)");
				sbsql.append(" AND dtpssn.dtpssnEstado=1");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("anioActual",anioactual);
				numMaxima = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return numMaxima;
	
	}

	@Override
	public Falta ObtenerFaltaPorI(int flId) {
		Falta retorno=null;
		try {
			retorno =  em.find(Falta.class, flId);
		}catch (Exception e) {
			throw e;
		}
		return retorno;
	}

	@Override
	public Sancion ObtenerSancionPorId(int snId) {

		Sancion retorno=null;
		try {
			retorno =  em.find(Sancion.class, snId);
		}catch (Exception e) {
			throw e;
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sancion> ObtenerLstSancionPorTipoSancionId(int tpSnId) {
		List<Sancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select sn from Sancion sn  where");
		sbsql.append(" sn.tipoSancion.tpsnId= :tpSnId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("tpSnId",  tpSnId);
		retorno = (List<Sancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSancion> ObtenerLstTipoSancionTodo() {
	
		List<TipoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select tp from TipoSancion tp");
		Query q = em.createQuery(sbsql.toString());
		retorno = (List<TipoSancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarDtSancionTodos() {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps ");
		Query q = em.createQuery(sbsql.toString());
	
		retorno = (List<DetallePuestoSancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarDtSancionPorAnioMes(int anio, int mes) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dts from DetallePuestoSancion dts where");
		sbsql.append("  dts.dtpssnAno = :anio ");
		sbsql.append("  and dts.dtpssnMes= :mes");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}
		
	

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesRegimenId(int anio, int mes, int rgmId) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dts from DetallePuestoSancion dts where");
		sbsql.append(" dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.detallePuesto.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("rgmId",rgmId);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int anio, int mes, int rgmId,
			int tpsnId) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dts from DetallePuestoSancion dts where");
		sbsql.append(" dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.detallePuesto.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("rgmId",rgmId);
		q.setParameter("tpsnId",tpsnId);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesTipoSancionId(int anio, int mes, int tpsnId) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dts from DetallePuestoSancion dts where");
		sbsql.append(" dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("tpsnId",tpsnId);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;

	}

}
