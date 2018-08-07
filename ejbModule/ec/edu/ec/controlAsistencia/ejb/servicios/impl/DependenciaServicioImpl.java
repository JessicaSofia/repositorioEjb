package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.DependenciaServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Dependencia;


import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class DependenciaServicioImpl
 */
@Stateless
public class DependenciaServicioImpl implements DependenciaServicio {

    /**
     * Default constructor. 
     */
    public DependenciaServicioImpl() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
  	private EntityManager em;

	/**
     * @see DependenciaServicio#ObtenerPorId()
     */
    public Dependencia ObtenerPorId(int id) {
    	Dependencia dependencia=null;
    	try{
    		dependencia = em.find(Dependencia.class, id);                  
    		
    	}catch(Exception e){
    		throw e;
    	}
    	return dependencia;
			
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Dependencia> obtenerListTodo() {
		List<Dependencia> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dp from Dependencia dp");
		Query q = em.createQuery(sbsql.toString());
	
		retorno = (List<Dependencia>)q.getResultList();
		
		}catch(Exception  e){
			throw  e; 
		}
		
		return retorno;
	}

	@Override
	public String obtenerNombreDependenciaporDetallePuestoId(int dpstId) {
		String retorno="";
		try{
			StringBuffer sbsql = new StringBuffer();
			sbsql.append(" select dts.dependencia.dpnDescripcion");
			sbsql.append(" from DetallePuesto dts");
			sbsql.append(" where dts.dtpsId = :dtpsId");
			 
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("dtpsId", dpstId);
			retorno = (String) q.getSingleResult();
			    
			}catch(Exception  e){
				e.printStackTrace();
				retorno="";
			}
			
			return retorno;

	}

}
