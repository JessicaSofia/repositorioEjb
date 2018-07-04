package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.PuestoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Puesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PuestoServicioImpl
 */
@Stateless
public class PuestoServicioImpl implements PuestoServicio {
	
	
	

    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
  	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PuestoServicioImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PuestoServicio#BuscarPorId(int)
     */
    public Puesto BuscarPorId(int id) {
    	
    	Puesto puesto=null;
    	try{
    		puesto=em.find(Puesto.class,id);
    	}catch(Exception e) {
    		throw e;
    	}
    	
		return puesto;	
    }

}
