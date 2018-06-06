package ec.edu.ec.controlAsistencia.ejb.servicios.impl;

import ec.edu.uce.controlAsistencia.ejb.datos.PersonaDto;
import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.PersonaServicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

/**
 * Session Bean implementation class PersonaServicioImpl
 */
@Stateless
@Local(PersonaServicio.class)
@LocalBean
public class PersonaServicioImpl implements PersonaServicio {

    /**
     * Default constructor. 
     */
    public PersonaServicioImpl() {
        // TODO Auto-generated constructor stub
    }
    
     
    
    @PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	/**
     * @see PersonaServicio#BuscartPorNombres(String)
     */
    @SuppressWarnings("unchecked")
	public List<PersonaDto> BuscarPorNombres(String nombres) {
    	
    	List<Object[]> retorno = new ArrayList<>();
    	List<PersonaDto> persona=new ArrayList<>();
    	PersonaDto  p= null;
    	
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select prs.prsId, prs.prsNombres, prs.prsIdentificacion, prs.prsPrimerApellido, prs.prsSegundoApellido, fch.fcemId, dtlp.dtpsId, dtlp.dependencia.dpnId  ");
		sbsql.append(" from Persona prs, FichaEmpleado fch, DetallePuesto dtlp where ");
		sbsql.append(" prs.prsNombres LIKE :nombres ");
		sbsql.append(" and fch.persona.prsId=prs.prsId");
		sbsql.append(" and dtlp.fichaEmpleado.fcemId=fch.fcemId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("nombres","%"+nombres+"%");
		retorno = q.getResultList();
		
		Iterator itr = retorno.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p = new PersonaDto(Integer.parseInt(String.valueOf(obj[0])),String.valueOf(obj[1]),String.valueOf(obj[2]),String.valueOf(obj[3]),String.valueOf(obj[4]),
            Integer.parseInt(String.valueOf(obj[5])),Integer.parseInt(String.valueOf(obj[6])),Integer.parseInt(String.valueOf(obj[7])));
            persona.add(p);
        }
		}catch(Exception  e){
			e.printStackTrace();
			retorno=null;
		}
		
		return persona;
       }

}
