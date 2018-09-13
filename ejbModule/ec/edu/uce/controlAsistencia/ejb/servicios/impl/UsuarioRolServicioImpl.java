/**************************************************************************
 *                (c) Copyright UNIVERSIDAD CENTRAL DEL ECUADOR. 
 *                            www.uce.edu.ec

 * Este programa de computador es propiedad de la UNIVERSIDAD CENTRAL DEL ECUADOR
 * y esta protegido por las leyes y tratados internacionales de derechos de 
 * autor. El uso, reproducción distribución no autorizada de este programa, 
 * o cualquier porción de  él, puede dar lugar a sanciones criminales y 
 * civiles severas, y serán  procesadas con el grado  máximo contemplado 
 * por la ley.
 
 ************************************************************************* 
   
 ARCHIVO:     UsuarioRolServicioImpl.java      
 DESCRIPCION: Bean sin estado encargado de gestionar las operaciones sobre la tabla UsuarioRol. 
 *************************************************************************
                               MODIFICACIONES
                            
 FECHA                      AUTOR                              COMENTARIOS
 05-MAY-2016           Dennis Collaguazo                   Emisión Inicial
 ***************************************************************************/

package ec.edu.uce.controlAsistencia.ejb.servicios.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.UsuarioRolServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.UsuarioRol;


@Stateless
public class UsuarioRolServicioImpl implements UsuarioRolServicio{

	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	/**
	 * Busca una entidad UsuarioRol por su id
	 * @param id - del UsuarioRol a buscar
	 * @return UsuarioRol con el id solicitado
	 * @throws UsuarioRolNoEncontradoException - Excepcion lanzada cuando no se encuentra un UsuarioRol con el id solicitado
	 * @throws UsuarioRolException - Excepcion general
	 */
	@Override
	public UsuarioRol buscarPorId(Integer id) {
		UsuarioRol retorno = null;
		if (id != null) {
			try {
				retorno = em.find(UsuarioRol.class, id);
			} catch (NoResultException e) {
				//throw new UsuarioRolNoEncontradoException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("UsuarioRol.buscar.por.id.no.result.exception",id)));
			}catch (NonUniqueResultException e) {
				//throw new UsuarioRolException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("UsuarioRol.buscar.por.id.non.unique.result.exception",id)));
			} catch (Exception e) {
				//throw new UsuarioRolException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("UsuarioRol.buscar.por.id.exception")));
			}
		}
		return retorno;
	}
	
	/**
	 * Lista todas las entidades Rol existentes en la BD
	 * @return lista de todas las entidades Rol existentes en la BD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> listarTodos() {
		List<UsuarioRol> retorno = null;
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select usuRol from UsuarioRol usuRol ");
		Query q = em.createQuery(sbsql.toString());
		retorno = q.getResultList();
		return retorno;
		
	}
	
	/**
	 * Lista todos los roles de los usuarios existentes en la BD
	 * @param usrId -  usrId id del usuario a consultar
	 * @return - retorna la lista de todos los roles de los usuarios existentes en la BD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> buscarXUsuario(int usrId){
		List<UsuarioRol> retorno = null;
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" Select ur from UsuarioRol ur where ");
		sbSql.append(" ur.usroUsuario.usrId =:usrId ");
		sbSql.append(" and ur.usroEstado = 0 ");
		Query q = em.createQuery(sbSql.toString());
		q.setParameter("usrId",usrId);
		retorno = q.getResultList();
		return retorno;
	}
	
	
	}
	
		
	
	
	
	
	
	
	

