package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.jpa.entidades.TipoLicencia;

@Stateless
public class TipoLicenciaServImpl
		implements ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.TipoLicenciaServicio {

	@PersistenceContext(unitName = "ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	@Override
	public List<TipoLicencia> listarTipoLicencia() {
		List<TipoLicencia> listaTipoLicencias = null;
		try {
			StringBuffer sbsql = new StringBuffer();
			sbsql.append("select tp from TipoLicencia tp");
			Query q = em.createQuery(sbsql.toString());
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

}
