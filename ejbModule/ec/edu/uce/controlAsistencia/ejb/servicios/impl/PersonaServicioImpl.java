package ec.edu.uce.controlAsistencia.ejb.servicios.impl;

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
		sbsql.append(" Select prs.prsId, prs.prsNombres, prs.prsIdentificacion, prs.prsPrimerApellido, prs.prsSegundoApellido, ");
		sbsql.append(" fch.fcemId, dtlp.dtpsId, d.dpnId,  d.dpnDescripcion, p.pstId, p.pstDenominacion, rgm.rgmId, rgm.rgmDescripcion, ");
		sbsql.append(" fch.categoria.ctgId, dtlp.contrato.cntId ");
		sbsql.append(" from DetallePuesto dtlp  left join  dtlp.fichaEmpleado fch ");
		sbsql.append( " left join dtlp.puesto p " );
		sbsql.append( " left join p.grupoOcupacional groc "  );
		sbsql.append( " left join groc.regimen rgm "  );
		sbsql.append( " left join dtlp.dependencia d " );
		sbsql.append( " left join fch.persona  prs " );
		sbsql.append(" where prs.prsPrimerApellido LIKE upper(:nombres) ");
		 
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("nombres","%"+nombres+"%");
		retorno = q.getResultList();
		
		Iterator itr = retorno.iterator();
        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            p=new PersonaDto();
             p.setPrsId(Integer.parseInt(String.valueOf(obj[0])));
            p.setPrsNombres(String.valueOf(obj[1]));
            p.setPrsIdentificacion(String.valueOf(obj[2]).trim());
            p.setPrsPrimerApellido(String.valueOf(obj[3]));
            p.setPrsSegundoApellido(String.valueOf(obj[4]));
            
            p.setFcemId(Integer.parseInt(String.valueOf(obj[5])));
            p.setDtpsId(Integer.parseInt(String.valueOf(obj[6])));
            p.setDpnId(Integer.parseInt(String.valueOf(obj[7])));
            p.setDpnNombre(String.valueOf(obj[8]));
   
            p.setPstId(Integer.parseInt(String.valueOf(obj[9])));
            p.setPstNombre(String.valueOf(obj[10]));
            p.setRgmId(Integer.parseInt(String.valueOf(obj[11])));
            p.setRgmNombre(String.valueOf(obj[12]));
            int valor=0;
            if(!String.valueOf(obj[13]).equals("null")) {
            	valor=Integer.parseInt(String.valueOf(obj[13]));
            }
            p.setCtgId(valor);
            p.setCtnId(Integer.parseInt(String.valueOf(obj[14])));
          
            persona.add(p);
        }
		}catch(Exception  e){
			e.printStackTrace();
			retorno=null;
		}
		
		return persona;
       }

	@Override
	public String obtenerNombrePersonaporDetallePuestoId(int dpstId) {
		String retorno="";
		try{
			StringBuffer sbsql = new StringBuffer();
			sbsql.append(" select dts.fichaEmpleado.persona.prsNombres||' '||dts.fichaEmpleado.persona.prsPrimerApellido||' '||dts.fichaEmpleado.persona.prsSegundoApellido ");
			sbsql.append(" from DetallePuesto dts ");
			sbsql.append(" where dts.dtpsId = :dtpsId");
			 
			Query q = em.createQuery(sbsql.toString());
			q.setParameter("dtpsId",dpstId);
			retorno = (String) q.getSingleResult();
			    
			}catch(Exception  e){
				e.printStackTrace();
				retorno="";
			}
			
			return retorno;

	}

}
