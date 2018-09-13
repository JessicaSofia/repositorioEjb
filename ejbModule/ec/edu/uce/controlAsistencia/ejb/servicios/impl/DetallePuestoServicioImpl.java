package ec.edu.uce.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.datos.DetallePuestoDto;
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
	public List<DetallePuesto> BuscarLstPorApellidos(String apellidos) {
		
		List<DetallePuesto> retorno = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select dtlp from DetallePuesto dtpl where");
		sbsql.append(" dtpl.Persona.PrsPrimerApellido LIKE :apellidos");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("apellidos","%"+apellidos+"%");
		retorno = (List<DetallePuesto>)q.getResultList();
		
		}catch(Exception  e){
			e.printStackTrace();
			retorno=null;
		}
		
		return retorno;

	}


		@Override
		public DetallePuestoDto BuscarPorId(int id) {
			DetallePuestoDto detallePuesto = null;
			
			try{
				StringBuffer sbsql = new StringBuffer();
				sbsql.append(" Select dtps.dtpsId, dtps.contrato.cntId, dtps.dependencia.dpnId, dtps.fichaEmpleado.fcemId, dtps.puesto.pstId, dtps.relacionLaboral.rllbId, dtps.dtpsEstado from DetallePuesto dtps ");
				sbsql.append(" where dtps.dtpsId = :id ");
				
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("id", id);
				 Object[] obj = (Object[]) q.getSingleResult();
				 detallePuesto=new DetallePuestoDto(Integer.parseInt(String.valueOf(obj[0])), Integer.parseInt(String.valueOf(obj[1])), Integer.parseInt(String.valueOf(obj[2])), Integer.parseInt(String.valueOf(obj[3])),Integer.parseInt(String.valueOf(obj[4])), Integer.parseInt(String.valueOf(obj[5])), Integer.parseInt(String.valueOf(obj[6])));
				 
				
			}catch(Exception  e){
				throw e;
			}
			
			return detallePuesto;
		}


		@Override
		public DetallePuesto DetallePuestoBuscarPorId(int id) {
			DetallePuesto  detallePuesto=null;
			try {
				
				detallePuesto=em.find(DetallePuesto.class, id);
			}catch (Exception e) {
				
			}
			return detallePuesto;  
		}

}
