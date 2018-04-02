package ec.edu.uce.controlAsistencia.ejb.servicios;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import ec.edu.uce.controlAsistencia.jpa.entidades.Usuario;

/**
 * Session Bean implementation class ServicioUsuarioEjb
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class ServicioUsuarioEjb {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;
	
	protected EntityManager getEntityManager() {
        return em;
    }
	
    public ServicioUsuarioEjb() {
        // TODO Auto-generated constructor stub
    }
// Medoto para obtener una Entidad Usuario Por Id     
    public  Usuario UsuarioIbtenerEntPorId(int idUsuario){
    	Usuario usuario=null;
    	try{
    		
        usuario= em.find(Usuario.class,idUsuario);
       // em.close();
    	}catch(Exception e  )
    	{
    		throw e;
    		}
    	return usuario;
    	}
    
    

}
