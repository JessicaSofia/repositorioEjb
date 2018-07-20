package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.RegimenServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Regimen;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class RegimenServicioImpl
 */
@Stateless
public class RegimenServicioImpl implements RegimenServicio {

	
	

    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
  	private EntityManager em;
    
    /**
     * Default constructor. 
     */
    public RegimenServicioImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see RegimenServicio#BuscarPorId(int)
     */
    public Regimen BuscarPorId(int id) {
       Regimen regimen=null;
       try {
    	   regimen=em.find(Regimen.class,id);
       }catch (Exception e) {
		throw e;
	}
       return regimen;
			
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Regimen> ObtenerLstTodos() {
		List<Regimen> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select rg from Regimen rg");
		Query q = em.createQuery(sbsql.toString());
	
		retorno = (List<Regimen>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}

}
