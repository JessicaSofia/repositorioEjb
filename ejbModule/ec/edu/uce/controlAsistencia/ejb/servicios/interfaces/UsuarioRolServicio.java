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
   
 ARCHIVO:     UsuarioRolServicio.java      
 DESCRIPCIÓN: Interfase que define las operaciones sobre la tabla UsuarioRol.  
 *************************************************************************
                               MODIFICACIONES
                            
 FECHA                      AUTOR                              COMENTARIOS
 05-MAY-2016            Dennis Collaguazo                  Emisión Inicial
 ***************************************************************************/
package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;


import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.UsuarioRol;




/**
 * Interface UsuarioRolServicio
 * Interfase que define las operaciones sobre la tabla UsuarioRol.
 * @author dcollaguazo
 * @version 1.0
 */
public interface UsuarioRolServicio {
	/**
	 * Busca una entidad UsuarioRol por su id
	 * @param id - del UsuarioRol a buscar
	 * @return UsuarioRol con el id solicitado
	 * @throws UsuarioRolNoEncontradoException - Excepcion lanzada cuando no se encuentra un UsuarioRol con el id solicitado
	 * @throws UsuarioRolException - Excepcion general
	 */
	public UsuarioRol buscarPorId(Integer id);
	
	/**
	 * Lista todas las entidades UsuarioRol existentes en la BD
	 * @return lista de todas las entidades UsuarioRol existentes en la BD
	 */
	public List<UsuarioRol> listarTodos();
	
	/**
	 * Lista todos los roles de los usuarios existentes en la BD
	 * @param usrId -  usrId id del usuario a consultar
	 * @return - retorna la lista de todos los roles de los usuarios existentes en la BD
	 */
	public List<UsuarioRol> buscarXUsuario(int usrId);
	

	
	
}