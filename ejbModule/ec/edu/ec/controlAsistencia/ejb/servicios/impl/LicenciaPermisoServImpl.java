package ec.edu.ec.controlAsistencia.ejb.servicios.impl;


import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.uce.controlAsistencia.jpa.entidades.LicenciaYPermiso;

@Stateless
public class LicenciaPermisoServImpl implements ec.edu.uce.controlAsistencia.ejb.servicios.interfaces.LicenciaPermisoServicio {
	
	public LicenciaPermisoServImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext(unitName="ec.edu.uce.controlAsistencia.jpa")
	private EntityManager em;

	/*@Resource(lookup = "java:/talentoHumanoDS")
	private DataSource ds;
	/*variables*/
	
	
	
	
	@Override
	public boolean LicenciaPermisoInsertar(LicenciaYPermiso licenciaPermiso) {
		
		boolean retorno = false;
		try {
			em.persist(licenciaPermiso);
			retorno= true;
			
		}catch(Exception  e){
			throw e;
			                                        
		}
		return retorno;
	}


	/*public List<LicenciaDto> ListaLicenciaYPermisoPorDetallePuestoId(int detallePuestoId) {
		List<LicenciaDto> licencias = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try{
		StringBuffer sql = new StringBuffer();
		sql.append("select * from Licencia_Y_Permiso where dtps_id="+detallePuestoId);
		sql.append(" lp.detallePuesto.dtpsId = ? ");

		con = ds.getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,detallePuestoId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				LicenciaDto licencia = new LicenciaDto();
				
				licencia.setLcprFechaEmision(rs.getTimestamp(5));
				licencias.add(licencia);
			}
		
		}catch(Exception  e){
			e.printStackTrace();
		}
		
		return licencias;

	}*/
	

	@Override
	public LicenciaYPermiso LicenciaYPermisoActualizar(LicenciaYPermiso licenciaYPermiso) {
		LicenciaYPermiso retorno=null;
		try{
			
			retorno=em.merge(licenciaYPermiso);
		}catch(Exception e ) {
			throw e;
		}
		return retorno;
	}

	@Override
	public int MaximaNumAutorizacion() {
		 int  numMaxima=0;
		 try{
			 
			 Calendar fechaFinal = Calendar.getInstance();
			 int anioactual=fechaFinal.get(Calendar.YEAR);
				StringBuffer sbsql = new StringBuffer();
				sbsql.append(" select  case when Max(lp.lcprNumLicencia) is null then 0 else Max(lp.lcprNumLicencia)  end from LicenciaYPermiso lp");
				sbsql.append(" WHERE   year(lp.lcprFechaEmision) = :anioActual)");
				sbsql.append(" AND lp.tplcEstado=1");
				Query q = em.createQuery(sbsql.toString());
				q.setParameter("anioActual",anioactual);
				numMaxima = (int) q.getSingleResult();
				
				}catch(Exception  e){
					throw  e; 
				}
		
		 		return numMaxima;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LicenciaYPermiso> ListaLicenciaYPermisoPorDetallePuestoId(int detallePuestoId) {
		List<LicenciaYPermiso> listaLicenciaPermiso = null;
		try{
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("Select lp from LicenciaYPermiso lp where");
		sbsql.append(" lp.detallePuesto.dtpsId = :detallePuestoId");
		Query q = em.createQuery(sbsql.toString());
		q.setParameter("detallePuestoId",detallePuestoId);
		listaLicenciaPermiso = (List<LicenciaYPermiso>)q.getResultList();

		}catch(Exception  e){
			throw  e; 
		}
		return listaLicenciaPermiso;
	}

}
