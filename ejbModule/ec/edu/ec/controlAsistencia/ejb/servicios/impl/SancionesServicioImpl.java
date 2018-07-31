package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.uce.controlAsistencia.ejb.datos.ReporteSancion;
import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.SancionesServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.CategoriaFalta;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Falta;
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
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int anio, int mes, int rgmId,
			int tpsnId) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, SUM(dts.dtpssnValor), dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion from DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.detallePuesto.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId");
		sbsql.append(" group by dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion  ");
		
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("rgmId",rgmId);
		q.setParameter("tpsnId",tpsnId);
		resultado = q.getResultList();
		
		Iterator itr = resultado.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new ReporteSancion(Integer.parseInt(String.valueOf(obj[0])),
            		String.valueOf(obj[1])
            		,String.valueOf(obj[2])
            		,Float.valueOf(String.valueOf(obj[3]))
            		, String.valueOf(obj[4])
            		, String.valueOf(obj[5])
            		);
              
            retorno.add(p);
         
        };
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;

	}             

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSancion> listarDtSancionPorAnioMesTipoSancionId(int anio, int mes, int tpsnId) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, SUM(dts.dtpssnValor), dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion from DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.detallePuesto.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" group by dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion  ");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("tpsnId",tpsnId);
		resultado = q.getResultList();
		
		Iterator itr = resultado.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new ReporteSancion(Integer.parseInt(String.valueOf(obj[0])),
            		String.valueOf(obj[1])
            		,String.valueOf(obj[2])
            		,Float.valueOf(String.valueOf(obj[3]))
            		, String.valueOf(obj[4])
            		, String.valueOf(obj[5])
            		);
            retorno.add(p);
         
        };
		

		}catch(Exception  e){
			
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;
       }

	
	@Override
	public List<ReporteSancion> listarDtSancionAnualPorAnioMes(int anioInicio, int mesInicio, int  anioFin, int mesFin) {
	
		   
		return  null;
		

	}

	@Override
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesRegimenId(int anio, int mes, int rgmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesRegimenIdTipoSancionId(int anio, int mes, int rgmId, int tpSnId, int mesFin) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, count(dts), dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion from DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio  ");
		sbsql.append(" and dts.dtpssnMes >= :mes and dts.dtpssnMes <= :mesFin ");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" group by dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("mesFin",mesFin);
		q.setParameter("tpsnId",tpSnId);
		resultado = q.getResultList();
		
		Iterator itr = resultado.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new ReporteSancion(Integer.parseInt(String.valueOf(obj[0])),
            		String.valueOf(obj[1])
            		,String.valueOf(obj[2])
            		,Integer.parseInt(String.valueOf(obj[3]))
            		, String.valueOf(obj[4])
            		, String.valueOf(obj[5])
            		);
            retorno.add(p);
         
        };
		

		}catch(Exception  e){
			
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;

		
	
	}

	@Override
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesTipoSancionId(int anio, int mes, int topSnId) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSancion> listarDiasSancionesPorTpSancionIdFaltaId(int tpSnId, int flId, int anio, int mes) {

		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select  dts.dtpssnDias, ct.falta.flNombre  from  DetallePuestoSancion dts ");
		sbsql.append(" right outer join dts.categoriaFalta ct ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and ct.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" and  dts.detallePuesto.dtpsId = :dtpsId ");
		Query q = em.createQuery(sbsql.toString());
		
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("tpsnId",tpSnId);
		q.setParameter("dtpsId",flId);
		resultado = q.getResultList();

		
		Iterator itr = resultado.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new ReporteSancion(String.valueOf(obj[1]),
            		String.valueOf(obj[0])
            		
            		);
            retorno.add(p);
         
        };
		

		}catch(Exception  e){
			
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;
		
	}

	@Override
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionIdNoAgrupado(int anio, int mes, int rgmId,
			int tpsnId) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dts.detallePuesto.dtpsId, dts.detallePuesto.fichaEmpleado.persona.prsIdentificacion, dts.detallePuesto.fichaEmpleado.persona.prsNombres||' '||dts.detallePuesto.fichaEmpleado.persona.prsPrimerApellido||' '||dts.detallePuesto.fichaEmpleado.persona.prsSegundoApellido, dts.dtpssnValor, dts.detallePuesto.puesto.pstDenominacion, dts.detallePuesto.dependencia.dpnDescripcion from DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.detallePuesto.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId");
			
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("rgmId",rgmId);
		q.setParameter("tpsnId",tpsnId);
		resultado = q.getResultList();
		
		Iterator itr = resultado.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new ReporteSancion(Integer.parseInt(String.valueOf(obj[0])),
            		String.valueOf(obj[1])
            		,String.valueOf(obj[2])
            		,Float.valueOf(String.valueOf(obj[3]))
            		, String.valueOf(obj[4])
            		, String.valueOf(obj[5])
            		);
              
            retorno.add(p);
         
        };
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;


	}

	@Override
	public String DiasSancionPorTpSancionIdFaltaId(int tpSnId, int flId,int dtpsId, int anio, int mes) {
    	
    	String retorno="";
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select  dts.dtpssnDias  from  DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.categoriaFalta.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" and dts.categoriaFalta.falta.flId = :flId ");
		sbsql.append(" and  dts.detallePuesto.dtpsId = :dtpsId ");
		Query q = em.createQuery(sbsql.toString());
		
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("tpsnId",tpSnId);
		q.setParameter("flId",flId);
		q.setParameter("dtpsId",dtpsId);
		retorno = (String) q.getSingleResult();

		
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		return retorno;	
}

	@Override
	public Falta ObtenerFaltaPorNombre(String Nombre) {
		Falta retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select fl from Falta fl");
		sbsql.append(" where fl.flNombre = :nombre");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("nombre", Nombre);
		retorno = (Falta)q.getSingleResult();
	
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
	
	}

	@Override
	public DetallePuestoSancion  ObtenerUltimaSancion( int dtpsId,int ctgflId) {
		DetallePuestoSancion retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps ");
		sbsql.append(" where  dps.dtpssnId = ( select max(dps1.dtpssnId) from  DetallePuestoSancion dps1  where dps1.detallePuesto.dtpsId= :dtpsId and dps1.categoriaFalta.ctgflId= :ctgflId) ");
		Query q = em.createQuery(sbsql.toString(),DetallePuestoSancion.class);
		q.setParameter("dtpsId", dtpsId);
		q.setParameter("ctgflId", ctgflId);
	
		retorno = (DetallePuestoSancion)q.getSingleResult();
	
		}catch(Exception  e){
		 return null; 
		}
		
		return retorno;

	}
	
	
	
}


