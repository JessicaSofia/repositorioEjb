package ec.edu.uce.controlAsistencia.ejb.servicios.impl;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.ParametroVacacionesServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.ParametroVacacionRegimen;

@Stateless
public class ParametroVacacionesServicioImpl implements ParametroVacacionesServicio {

	   @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
		private EntityManager em;
	
	@Override
	public ParametroVacacionRegimen buscarPorId(int prvcId, int rgmId) {
		ParametroVacacionRegimen  retorno=null;
		Object result = new Object();
		try {
			
			StringBuffer sbsql = new StringBuffer();
			
			sbsql.append("select pvr from ParametroVacacionRegimen pvr where ");
			sbsql.append(" pvr.parametroVacacione.prvcId = :prvcId ");
			sbsql.append(" and pvr.regimen.rgmId = :rgmId ");
			Query q = em.createQuery(sbsql.toString(),ParametroVacacionRegimen.class );
			q.setParameter("prvcId",prvcId);
			q.setParameter("rgmId", rgmId);
			retorno =(ParametroVacacionRegimen) q.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

}
