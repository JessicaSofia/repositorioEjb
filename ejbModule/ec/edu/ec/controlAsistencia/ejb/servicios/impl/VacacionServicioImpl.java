package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.VacacionServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.SaldoVacacion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Vacacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RegistroVacaionesServicioImpl
 */
@Stateless
public class VacacionServicioImpl implements  VacacionServicio {

	/**
	 * 
	 */
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public VacacionServicioImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void VacionInsertar(Vacacion vacacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacacion> ListaVacacionesPorDetallePuestoId(int detallePuestoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void VacacionActualizar(Vacacion vacacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SaldoVacacion> listSaldoVacacionPorDetallePuestoId(int DetallePuestoId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
    
    

}
