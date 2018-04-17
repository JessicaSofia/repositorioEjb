package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.DetallePuestoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuesto;
import javax.persistence.Query;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class DetallePuestoServicioImpl
 */
@Stateless
public class DetallePuestoServicioImpl implements DetallePuestoServicio {
	
	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public DetallePuestoServicioImpl() {
        // TODO Auto-generated constructor stub
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuesto> BuscarLstPorNombres(String nombres) {
		List<DetallePuesto> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dtlp from DetallePuesto dtpl where");
		sbsql.append(" dtpl.Persona.PrsNombres LIKE :nombres");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("nombres","%"+nombres+"%");
		retorno = (List<DetallePuesto>)q.getResultList();
		
		}catch(Exception  e){
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuesto> BuscarLstPorApellidos(String apellidos) {
		
		List<DetallePuesto> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dtlp from DetallePuesto dtpl where");
		sbsql.append(" dtpl.Persona.PrsPrimerApellido LIKE :apellidos");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter(apellidos,"%"+apellidos+"%");
		retorno = (List<DetallePuesto>)q.getResultList();
		
		}catch(Exception  e){
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;

	}

}
