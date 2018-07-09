package ec.edu.ec.controlAsistencia.ejb.servicios.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.ContratoServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Contrato;

@Stateless
public class ContratoServicioImpl implements ContratoServicio {

	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
    
	
	
	@Override
	public Contrato obtenerporDetallePuestoId(int dtpsId) {
	Contrato retorno=null;
	try {
	
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	return retorno;
	}

}
