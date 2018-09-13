package ec.edu.uce.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.FichaEmpleadoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.FichaEmpleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class FichaEmpleadoServicioImpl
 */
@Stateless
public class FichaEmpleadoServicioImpl implements FichaEmpleadoServicio {

    /**
     * Default constructor. 
     */
    public FichaEmpleadoServicioImpl() {
        // TODO Auto-generated constructor stub
    }

    
    
    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
  	private EntityManager em;

    
	/**
     * @see FichaEmpleadoServicio#BuscarPorid(int)
     */
    public FichaEmpleado BuscarPorid(int id) {
       
    	FichaEmpleado fichaEmpleado=null;
    	try{
    		fichaEmpleado = em.find(FichaEmpleado.class, id);                  
    		
    	}catch(Exception e){
    		throw e;
    	}
    	return fichaEmpleado;
			
    }

}
