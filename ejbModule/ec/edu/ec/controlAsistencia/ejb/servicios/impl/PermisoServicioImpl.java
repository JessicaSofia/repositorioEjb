package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.PermisoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Permiso;

@Stateless
public class PermisoServicioImpl implements PermisoServicio {

	
	public PermisoServicioImpl(){
		
	}
	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Permiso> ListaPermisoPorDetallePuestoId(int detallePuestoId) {
		System.out.println(detallePuestoId);
		List<Permiso> listaPermiso = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("Select lp from Permiso lp where");
		sbsql.append(" lp.detallePuesto.dtpsId = :detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		listaPermiso = (List<Permiso>)q.getResultList();

		}catch(Exception  e){
			throw  e; 
		}
		return listaPermiso;
	}

	
}
