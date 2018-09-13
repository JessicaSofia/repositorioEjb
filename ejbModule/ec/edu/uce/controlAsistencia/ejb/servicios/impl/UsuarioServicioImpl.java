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
   
 ARCHIVO:     UsuarioServicioImpl.java      
 DESCRIPCION: Bean sin estado encargado de gestionar las operaciones sobre la tabla Usuario. 
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

import ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.UsuarioServicio;
import ec.edu.uce.controlAsistencia.jpa.entidades.Usuario;


@Stateless
public class UsuarioServicioImpl implements UsuarioServicio{

	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	/**
	 * Busca una entidad Usuario por su id
	 * @param id - del Usuario a buscar
	 * @return Usuario con el id solicitado
	 * @throws UsuarioNoEncontradoException - Excepcion lanzada cuando no se encuentra un Usuario con el id solicitado
	 * @throws UsuarioException - Excepcion general
	 */
	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario retorno = null;
		if (id != null) {
			try {
				retorno = em.find(Usuario.class, id);
			} catch (NoResultException e) {
				//throw new UsuarioNoEncontradoException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.id.no.result.exception",id)));
			}catch (NonUniqueResultException e) {
				//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.id.non.unique.result.exception",id)));
			} catch (Exception e) {
				//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.id.exception")));
			}
		}
		return retorno;
	}
	
	/**
	 * Lista todas las entidades Usuario existentes en la BD
	 * @return lista de todas las entidades Usuario existentes en la BD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> retorno = null;
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" Select usu from Usuario usu ");
		Query q = em.createQuery(sbsql.toString());
		retorno = q.getResultList();
		return retorno;
	}
	
	/**
	 * Busca a un usuario por su correo
	 * @param correo - correo con el que se va a buscar
	 * @return usuario con el correo solicitado
	 * @throws UsuarioNoEncontradoException 
	 * @throws UsuarioException 
	 */
	@Override
	public Usuario buscarPorCorreo(String correo) 	{
		Usuario retorno = null;
		try{
			if(correo != null){
				StringBuilder sbSql = new StringBuilder();
				sbSql.append(" Select u from Usuario u where ");
				sbSql.append(" upper(u.usrPersona.prsMailPersonal)= :correo ");
				Query q = em.createQuery(sbSql.toString());
				q.setParameter("correo",correo.toUpperCase());
				retorno = (Usuario)q.getSingleResult();
			}
		}catch(NoResultException nre){
			//throw new UsuarioNoEncontradoException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.correo.no.result.exception", correo)));
		}catch(NonUniqueResultException nre){
			//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.correo.non.unique.result.exception",correo)));
		}catch (Exception nre) {
			//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.correo.exception")));
		}
		return retorno;
	}
	
	
	/**
	 * Busca a un usuario por su nick
	 * @param nickName - nick con el que se va a buscar
	 * @return usuario con el nick solicitado
	 * @throws UsuarioNoEncontradoException, UsuarioException 
	 */
	@Override
	public Usuario buscarPorNick(String nickName) 	{
		Usuario retorno = null;
		try{
			if(nickName != null){
				StringBuilder sbSql = new StringBuilder();
				sbSql.append(" Select u from Usuario u where ");
				sbSql.append(" upper(u.usrNick)=upper(:nickName) ");

				Query q = em.createQuery(sbSql.toString());
				q.setParameter("nickName",nickName);
				retorno = (Usuario)q.getSingleResult();
			}
		}catch(NoResultException nre){
			//throw new UsuarioNoEncontradoException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.nickName.no.result.exception", nickName)));
		}catch(NonUniqueResultException nre){
			//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.nickName.non.unique.result.exception",nickName)));
		}catch (Exception nre) {
			//throw new UsuarioException(MensajeGeneradorUtilidades.getMsj(new MensajeGeneradorUtilidades("Usuario.buscar.por.nickName.exception")));
		}
		return retorno;
	}
	
	/**
	 * Busca a un usuario por su Identificación
	 * @param identificacion - identificacion con la que se va a buscar
	 * @return usuario con la identificacion solicitado 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarPorIndentificacion(String identificacion)	{
		List<Usuario> retorno = null;
		if(identificacion != null){
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" Select usr from Usuario usr where ");
			sbSql.append("usr.usrIdentificacion like  :identificacion");
			Query q = em.createQuery(sbSql.toString());
			q.setParameter("identificacion","%"+identificacion+"%");
			retorno = q.getResultList();
		}
	return retorno;
	}

	/**
	 * Busca a un usuario por su Identificación
	 * @param identificacion - identificacion con la que se va a buscar
	 * @return usuario con la identificacion solicitado 
	 */
	@Override
	public Usuario buscarIndentificacion(String identificacion)	{
		Usuario retorno = null;
		if(identificacion != null){
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" Select usr from Usuario usr where ");
			sbSql.append("usr.usrIdentificacion like  :identificacion");
			Query q = em.createQuery(sbSql.toString());
			q.setParameter("identificacion","%"+identificacion+"%");
			retorno = (Usuario) q.getSingleResult();
		}
	return retorno;
	}

	
	
	
}
