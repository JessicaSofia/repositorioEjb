package ec.edu.uce.controlAsistencia.ejb.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.controlAsistencia.jpa.entidades.Usuario;
import ec.edu.uce.controlAsistencia.jpa.entidades.UsuarioRol;

/**
 * Session Bean implementation class ServicioUsuarioRolEjb
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class ServicioUsuarioRolEjb {
	
	
	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ServicioUsuarioRolEjb() {
        // TODO Auto-generated constructor stub
    }

 // Medoto para obtener una Entidad UsuarioRol Por Id  para prueba Spring  Security   
    public UsuarioRol  UsuarioRolIbtenerEntPorId(int idUsuarioRol){
    	UsuarioRol usuarioRol=null;
    	try{
    		
        usuarioRol= em.find(UsuarioRol.class,idUsuarioRol);
       // em.close();
    	}catch(Exception e  )
    	{
    		throw e;
    		}
    	return usuarioRol;
    
    	}
    
    

    
    
}
