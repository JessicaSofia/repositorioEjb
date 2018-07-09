package ec.edu.ec.controlAsistencia.ejb.servicios.impl;


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
		try {
			
			StringBuffer sbsql = new StringBuffer();
//			sbsql.append(" Select pvr.parametroVacaciones.prvcId, pvr.regimen.rgmId, pvr.prvcrgValor   from ParametroVacacionRegimen pvr");
//			sbsql.append(" where pvr.parametroVacaciones.prvcId= :prvcId");
//			sbsql.append(" pvr.regimen.rgmId= :rgmId");
			
			sbsql.append("Select pvr from ParametroVacacionRegimen pvr  ");
			sbsql.append(" where pvr.parametroVacaciones.prvcId= :prvcId");
			sbsql.append("and pvr.regimen.rgmId= :rgmId");
			
			 
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("prvcId",prvcId);
			q.setParameter("rgmId", rgmId);
			retorno =(ParametroVacacionRegimen) q.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

}
