package ec.edu.uce.controlAsistencia.ejb.servicios.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.jpa.entidades.Licencia;
import ec.edu.uce.controlAsistencia.jpa.entidades.TipoLicencia;

@Stateless
public class TipoLicenciaServImpl
		implements ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.TipoLicenciaServicio {

	public TipoLicenciaServImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext(unitName = "ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoLicencia> listarTipoLicencia( int id_regimen) {
		List<TipoLicencia> listaTipoLicencias = null;
		try {
			StringBuffer sbsql = new StringBuffer();
			sbsql.append("select tp from TipoLicencia tp where tp.tipoLicencia is null and tp.regimen.rgmId = :id_regimen");
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("id_regimen",id_regimen);
			listaTipoLicencias = (List<TipoLicencia>) q.getResultList();
		} catch (Exception e) {
			throw e;
		}
		return listaTipoLicencias;
	}

	@Override
	public TipoLicencia buscarTipoLicenciaPorId(int id_tipo_licencia) {
		TipoLicencia tipoLicencia = null;
		try {
			tipoLicencia = em.find(TipoLicencia.class, id_tipo_licencia);
		} catch (Exception e) {
			throw e;
		}
		return tipoLicencia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoLicencia> buscarTipoLicenciaPorPadre(int id_padre) {
		List<TipoLicencia> listaTipoLicencia = null;
		try{
			StringBuffer sbsql = new StringBuffer();
			sbsql.append("select tp from TipoLicencia tp where");
			sbsql.append(" tp.tipoLicencia.tplcId = :id_padre");
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("id_padre",id_padre);
			listaTipoLicencia = (List<TipoLicencia>)q.getResultList();
		}catch (Exception e) {
			throw e;
		}
		return listaTipoLicencia;
	}


}
