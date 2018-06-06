package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.GrupoOcupacionalServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.GrupoOcupacional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class GrupoOcupacionalServicioImpl
 */
@Stateless
public class GrupoOcupacionalServicioImpl implements GrupoOcupacionalServicio {

	

    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
  	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GrupoOcupacionalServicioImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see GrupoOcupacionalServicio#BuscarPorId(int)
     */
    public GrupoOcupacional BuscarPorId(int id) {
        // TODO Auto-generated method stub
			return null;
    }

}
