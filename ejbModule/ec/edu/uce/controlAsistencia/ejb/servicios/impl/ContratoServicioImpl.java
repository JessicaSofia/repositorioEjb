package ec.edu.uce.controlAsistencia.ejb.servicios.impl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.ejb.datos.AccionPersonalDto;
import ec.edu.uce.controlAsistencia.ejb.datos.ContratoDto;
import ec.edu.uce.controlAsistencia.ejb.datos.PersonaDto;
import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.ContratoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Contrato;
import ec.edu.uce.controlAsistencia.jpa.entidades.FichaEmpleado;

@Stateless
public class ContratoServicioImpl implements ContratoServicio {

	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
    
	
	// aplicacion
	@Override
	public Contrato obtenerporDetallePuestoId(int dtpsId) {
	Contrato retorno=null;
	try {
	
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	return retorno;
	}


	@Override
	public ContratoDto obtenerPorId(int id) {
	       
		List<Object[]> retorno = new ArrayList<>();
    	ContratoDto contrato=null;
    	
    	
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select cnt.cntId, cnt.cntEstado, cnt.cntFechaFin, cnt.cntFechaInicio ");
		sbsql.append(" from Contrato cnt  ");
		sbsql.append(" where cnt.cntEstado =1 and  cnt.cntId= :id");
		 
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("id", id);
		retorno = q.getResultList();
		
		Iterator itr = retorno.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
           contrato=new ContratoDto();
           contrato.setCntId(Integer.parseInt(String.valueOf(obj[0])));
           contrato.setCntEstado(Integer.parseInt(String.valueOf(obj[1])));
           System.out.println(" fechas "+ String.valueOf(obj[2]));
           contrato.setCntFechaFin(Date.valueOf(String.valueOf(obj[2]).trim()));
           contrato.setCntFechaInicio(Date.valueOf(String.valueOf(obj[3]).trim()));
   
        }
		}catch(Exception  e){
			e.printStackTrace();
			return null;
		}
		return contrato;

		
	}


	@Override
	public AccionPersonalDto obtenerAccionPersonal(int dtpsId) {
		List<Object[]> retorno = new ArrayList<>();
    	AccionPersonalDto nombramiento=null;
    	
    	
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select acp.acprId, acp.acprEstado, acp.acprFecha, acp.acprFechaPosesion, acp.tipoAccion ");
		sbsql.append(" from AccionPersonal acp  ");
		sbsql.append(" where acp.acprEstado =1 and  acp.detallePuesto.dtpsId= :dtpsId");
		 
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("dtpsId", dtpsId);
		retorno = q.getResultList();
		
		Iterator itr = retorno.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            nombramiento=new AccionPersonalDto();
            nombramiento.setAcprId(Integer.parseInt(String.valueOf(obj[0])));
            nombramiento.setAcprEstado(Integer.parseInt(String.valueOf(obj[1])));
            nombramiento.setAcprFecha(Date.valueOf(String.valueOf(obj[2]).trim()));
            nombramiento.setAcprFechaPosesion(Date.valueOf(String.valueOf(obj[3]).trim()));
            nombramiento.setTipoAccion(Integer.parseInt(String.valueOf(obj[4])));
   
        }
		}catch(Exception  e){
			e.printStackTrace();
			return null;
		}
		return nombramiento;


	}
	
	

}
