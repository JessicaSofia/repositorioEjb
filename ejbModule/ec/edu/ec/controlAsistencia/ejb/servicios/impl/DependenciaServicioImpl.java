package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.datos.DependenciaDto;
import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.DependenciaServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Dependencia;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
