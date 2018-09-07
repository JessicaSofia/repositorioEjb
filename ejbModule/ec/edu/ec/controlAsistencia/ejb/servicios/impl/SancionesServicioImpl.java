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
			retorno = true;
		}catch (Exception e) {
			retorno=false;
			throw e;
		}
		return retorno;
	}

	@Override
	public DetallePuestoSancion actualizarSancion(DetallePuestoSancion dtSancion) {
		DetallePuestoSancion retorno=null;
		try {
			
			retorno=em.merge(dtSancion);
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
		sbsql.append(" dps.dtpsId = :detallePuestoId");
		sbsql.append(" order by dps.dtpssnId desc");
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
	public int MaximaNumAutorizacion(int tpSanId) {
		 int  numMaxima=0;
		 try{
			 
			 Calendar fechaFinal = Calendar.getInstance();
			 int anioactual=fechaFinal.get(Calendar.YEAR);
				StringBuffer sbsql = new StringBuffer();
				sbsql.append(" select case when Max(dtpssn.dtpssnNumaccion) is null then 0 else Max(dtpssn.dtpssnNumaccion)  end from DetallePuestoSancion  dtpssn ");
				sbsql.append(" WHERE year(dtpssn.dtpssnFechaEmision) = :anioActual ");
				sbsql.append(" AND dtpssn.sancion.tipoSancion.tpsnId = :tpSnId ");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("anioActual",anioactual);
				q.setParameter("tpSnId",tpSanId);
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
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int anio, int mes, int rgmId, int tpsnId) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dtssn.dtpsId, dts.fichaEmpleado.persona.prsIdentificacion, dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido, SUM(dtssn.dtpssnValor), dts.puesto.pstDenominacion, dts.dependencia.dpnDescripcion ");
		sbsql.append(" from DetallePuestoSancion dtssn, DetallePuesto dts ");
		sbsql.append(" where dtssn.dtpssnAno = :anio ");
		sbsql.append(" and dtssn.dtpssnMes= :mes");
		sbsql.append(" and dtssn.dtpsId= dts.dtpsId");
		sbsql.append(" and dts.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dtssn.sancion.tipoSancion.tpsnId = :tpsnId");
		sbsql.append(" group by dtssn.dtpsId, dts.fichaEmpleado.persona.prsIdentificacion, dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido, dts.puesto.pstDenominacion, dts.dependencia.dpnDescripcion  ");
		
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
	public List<ReporteSancion> listarDtSancionAnualPorAnioMes(int anioInicio, int mesInicio, int  anioFin, int mesFin) {
	
		   
		return  null;
		

	}

	

	@Override
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionIdNoAgrupado(int anio, int mes, int rgmId,
			int tpsnId) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
    	ReporteSancion p= null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select  dtssn.dtpsId, dts.fichaEmpleado.persona.prsIdentificacion, dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido, SUM(dtssn.dtpssnValor), dts.puesto.pstDenominacion, dts.dependencia.dpnDescripcion ");
		sbsql.append(" from DetallePuestoSancion dtssn, DetallePuesto dts ");
		sbsql.append(" where dtssn.dtpssnAno = :anio ");
		sbsql.append(" and dtssn.dtpssnMes= :mes");
		sbsql.append(" and dtssn.dtpsId= dts.dtpsId");
		sbsql.append(" and dts.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
		sbsql.append(" and dtssn.sancion.tipoSancion.tpsnId = :tpsnId");
			
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
		sbsql.append(" and dts.categoriaFalta.sancion.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" and dts.categoriaFalta.falta.flId = :flId ");
		sbsql.append(" and  dts.dtpsId = :dtpsId ");
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
	public DetallePuestoSancion  obtenerUltimaSancion( int dtpsId, int tpsnId, int anio, int mes) {
		DetallePuestoSancion retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps ");
		sbsql.append(" where  dps.dtpssnId = ( select max(dps1.dtpssnId) from  DetallePuestoSancion dps1  where dps1.dtpsId= :dtpsId and dps1.sancion.tipoSancion.tpsnId= :tpsnId  ");
		sbsql.append(" and to_date('' || dps1.dtpssnAno || '/' ||dps1.dtpssnMes||'/'||1,'yyyy/mm/dd' ) < to_date(''|| :anio ||'/'|| :mes ||'/'||1, 'yyyy/mm/dd') ");
		sbsql.append("  and dps.dtpssnEstado=1 )");
		Query q = em.createQuery(sbsql.toString(),DetallePuestoSancion.class);
		q.setParameter("dtpsId", dtpsId);
		q.setParameter("tpsnId", tpsnId);

		q.setParameter("anio", anio);

		q.setParameter("mes", mes);
	
		retorno = (DetallePuestoSancion)q.getSingleResult();
	
		}catch(Exception  e){
			e.printStackTrace();
		 return null; 
		}
		
		return retorno;

	}

	@Override
	public DetallePuestoSancion obtenerSancionPorMesAnio(int dtpsId, int ctgflId, int mes, int anio, int snId) {
		DetallePuestoSancion retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps ");
		sbsql.append(" where  dps.dtpsId= :dtpsId and dps.categoriaFalta.ctgflId= :ctgflId and dps.sancion.tipoSancion.tpsnId= :snId ");
		sbsql.append(" and  dps.dtpssnMes= :mes and dps.dtpssnAno= :anio ");
		Query q = em.createQuery(sbsql.toString(),DetallePuestoSancion.class);
		q.setParameter("dtpsId", dtpsId);
		q.setParameter("ctgflId", ctgflId);
		q.setParameter("mes", mes);
		q.setParameter("anio", anio);
		q.setParameter("snId", snId);
		
		retorno = (DetallePuestoSancion)q.getSingleResult();
	
		}catch(Exception  e){
		 return null; 
		}
		
		return retorno;

	}
	
	@Override
	public int ObtnerSueldoPorDetallePuestoId(int dtpsId) {
		 int  sueldo=0;;
		 try{
			 
			 	StringBuffer sbsql = new StringBuffer();
				sbsql.append(" select case when  dtps.dtpsRmu is null then 0 else dtps.dtpsRmu  end from DetallePuesto dtps ");
				sbsql.append(" where dtps.dtpsId= :dtpsId ");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("dtpsId", dtpsId);
				sueldo = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return sueldo;
	}

	@Override
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesRegimenIdTipoSancionId(int anioInicio, int mesInicio, int rgmId, int tpSnId, int anioFin,int mesFin) {
		List<Object[]> resultado= new ArrayList<>();
    	List<ReporteSancion> retorno=new ArrayList<>();
		ReporteSancion p= null;
		try {
			
			StringBuffer sbsql = new StringBuffer();
			sbsql.append(" Select  dtssn.dtpsId, dts.fichaEmpleado.persona.prsIdentificacion, dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido, COUNT(dtssn), dts.puesto.pstDenominacion, dts.dependencia.dpnDescripcion ");
			sbsql.append(" from DetallePuestoSancion dtssn, DetallePuesto dts ");
			sbsql.append(" where   to_date(''|| :anioInicio ||'/'|| :mesInicio ||'/'||1, 'yyyy/mm/dd') <= to_date('' || dtssn.dtpssnAno || '/' ||dtssn.dtpssnMes||'/'||1,'yyyy/mm/dd' ) ");
			sbsql.append(" and to_date('' || dtssn.dtpssnAno || '/' ||dtssn.dtpssnMes||'/'||1,'yyyy/mm/dd' ) <= to_date(''|| :anioFin ||'/'|| :mesFin ||'/'||1, 'yyyy/mm/dd') ");
			sbsql.append(" and dtssn.dtpsId= dts.dtpsId");
			sbsql.append(" and dts.puesto.grupoOcupacional.regimen.rgmId = :rgmId");
			sbsql.append(" and dtssn.sancion.tipoSancion.tpsnId = :tpsnId");
			sbsql.append(" group by dtssn.dtpsId, dts.fichaEmpleado.persona.prsIdentificacion, dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido, dts.puesto.pstDenominacion, dts.dependencia.dpnDescripcion  ");
			
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("anioInicio",anioInicio);
			q.setParameter("mesInicio",mesInicio);
			q.setParameter("anioFin",anioFin);
			q.setParameter("mesFin",mesFin);
		
			q.setParameter("rgmId",rgmId);
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
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public DetallePuestoSancion obtenerUltimaSancionPorTpSancionFaltaId(int dtpsId, int tpsnId, int fltId) {
		DetallePuestoSancion retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps ");
		sbsql.append(" where  dps.dtpssnId = ( select max(dps1.dtpssnId) from  DetallePuestoSancion dps1  where dps1.dtpsId= :dtpsId and dps1.sancion.tipoSancion.tpsnId= :tpsnId and dps1.categoriaFalta.falta.flId= :flId) ");
		Query q = em.createQuery(sbsql.toString(),DetallePuestoSancion.class);
		q.setParameter("dtpsId", dtpsId);
		q.setParameter("tpsnId", tpsnId);
		q.setParameter("flId", fltId);
	
		retorno = (DetallePuestoSancion)q.getSingleResult();
	
		}catch(Exception  e){
		 return null; 
		}
		
		return retorno;

	}

	@Override
	public Sancion obtenerSancionPorNivelPorTipoSancion(int nivel, int tpSnId) {
		Sancion retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select sn from Sancion sn");
		sbsql.append(" where sn.snNivel= :nivel and sn.tipoSancion.tpsnId= :tpsnId ");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("nivel", nivel);
		q.setParameter("tpsnId", tpSnId);
		retorno = (Sancion)q.getSingleResult();
	
		}catch(Exception  e){
			 e.printStackTrace();
			return null;
		}
		
		return retorno;
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuestoSancion> listarSancionMultasPorDetallePuestoId(int dtpsId, int dtpssnMes, int dtpssnAno) {
		List<DetallePuestoSancion> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dps from DetallePuestoSancion dps where");
		sbsql.append(" dps.dtpsId = :detallePuestoId and dps.sancion.snId = 1");
		sbsql.append(" and dps.dtpssnMes = :dtpssnMes and dps.dtpssnAno = :dtpssnAno");
		sbsql.append(" order by dps.dtpssnId desc");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",dtpsId);
		q.setParameter("dtpssnMes",dtpssnMes);
		q.setParameter("dtpssnAno",dtpssnAno);
		retorno = (List<DetallePuestoSancion>)q.getResultList();
	
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	
	}

	@Override
	public List<String> listarfaltasPorDtPuestoIdMesAnioTipoSancion(int dtpsId, int mes, int anio, int tpSnId) {
		List<String> retorno=null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select  dts.categoriaFalta.falta.flNombre  from  DetallePuestoSancion dts ");
		sbsql.append(" where dts.dtpssnAno = :anio ");
		sbsql.append(" and dts.dtpssnMes= :mes");
		sbsql.append(" and dts.sancion.tipoSancion.tpsnId = :tpsnId ");
		sbsql.append(" and  dts.dtpsId = :dtpsId ");
		Query q = em.createQuery(sbsql.toString());
		
		q.setParameter("anio",anio);
		q.setParameter("mes",mes);
		q.setParameter("tpsnId",tpSnId);
		q.setParameter("dtpsId",dtpsId);
		retorno = (List<String>)q.getResultList();
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		return retorno;	
	
	}

	@Override
	public String obtenerPartidaPresupuestariaPorDetallePuestoId(int dtpsId) {
		
		String partidaPresupuestaria="";
		try {
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select case when  prti.pridPresupuestaria is null then '' else prti.pridPresupuestaria  end ");
		sbsql.append(" from DetallePuesto dtps, PartidaIndividual prti ");
		sbsql.append(" where dtps.dtpsId= :dtpsId  ");
		sbsql.append(" and dtps.partidaIndividual.pridId= prti.pridId ");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("dtpsId", dtpsId);
		partidaPresupuestaria = (String) q.getSingleResult();
		
		}catch(Exception  e){
			throw  e; 
		}

 		return partidaPresupuestaria;
	}

	@Override
	public String obtenerPartidaIndividualPorDetallePuestoId(int dtpsId) {
		
		String partidaIndividual="";
		try {
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select case when  prti.pridIndividual is null then '' else prti.pridIndividual  end ");
		sbsql.append(" from DetallePuesto dtps, PartidaIndividual prti ");
		sbsql.append(" where dtps.dtpsId= :dtpsId  ");
		sbsql.append(" and dtps.partidaIndividual.pridId= prti.pridId ");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("dtpsId", dtpsId);
		partidaIndividual = (String) q.getSingleResult();
		
		}catch(Exception  e){
			throw  e; 
		}

 		return partidaIndividual;
	}
}


