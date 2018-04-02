/**************************************************************************
 *                (c) Copyright UNIVERSIDAD CENTRAL DEL ECUADOR. 
 *                            www.uce.edu.ec

 * Este programa de computador es propiedad de la UNIVERSIDAD CENTRAL DEL ECUADOR
 * y está protegido por las leyes y tratados internacionales de derechos de 
 * autor. El uso, reproducción o distribución no autorizada de este programa, 
 * o cualquier porción de él, puede dar lugar a sanciones criminales y 
 * civiles severas, y serán procesadas con el grado máximo contemplado 
 * por la ley.
 
 ************************************************************************* 
   
 ARCHIVO:     UsuarioServicio.java      
 DESCRIPCIÓN: Interfase que define las operaciones sobre la tabla Usuario.  
 *************************************************************************
                               MODIFICACIONES
                            
 FECHA                      AUTOR                              COMENTARIOS
 05-MAY-2016            Dennis Collaguazo                  Emisión Inicial
 ***************************************************************************/
package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;


import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.Usuario;



/**
 * Interface UsuarioServicio
 * Interfase que define las operaciones sobre la tabla Usuario.
 * @author dcollaguazo
 * @version 1.0
 */
public interface UsuarioServicio {
	/**
	 * Busca una entidad Usuario por su id
	 * @param id - del Usuario a buscar
	 * @return Usuario con el id solicitado
	 * @throws UsuarioNoEncontradoException - Excepcion lanzada cuando no se encuentra un Usuario con el id solicitado
	 * @throws UsuarioException - Excepcion general
	 */
	public Usuario buscarPorId(Integer id);
	
	/**
	 * Lista todas las entidades Usuario existentes en la BD
	 * @return lista de todas las entidades Usuario existentes en la BD
	 */
	public List<Usuario> listarTodos();
	
	/**
	 * Busca a un usuario por su nick
	 * @param nickName - nick con el que se va a buscar
	 * @return usuario con el nick solicitado
	 * @throws UsuarioNoEncontradoException, UsuarioException 
	 */
	public Usuario buscarPorNick(String nickName);
	
	/**
	 * Busca a un usuario por su Identificación
	 * @param identificacion - identificacion con la que se va a buscar
	 * @return usuario con la identificacion solicitado 
	 */
	public List<Usuario> buscarPorIndentificacion(String identificacion);
	
	
	/**
	 * Busca a un usuario por su Identificación
	 * @param identificacion - identificacion con la que se va a buscar
	 * @return usuario con la identificacion solicitado 
	 */
	public Usuario buscarIndentificacion(String identificacion);
	
	/**
	 * Busca a un usuario por su correo
	 * @param correo - correo con el que se va a buscar
	 * @return usuario con el correo solicitado
	 * @throws UsuarioNoEncontradoException 
	 * @throws UsuarioException 
	 */
	public Usuario buscarPorCorreo(String correo);


}
