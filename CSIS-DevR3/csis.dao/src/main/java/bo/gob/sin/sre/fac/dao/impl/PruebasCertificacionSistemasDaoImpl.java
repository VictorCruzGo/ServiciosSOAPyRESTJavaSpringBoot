package bo.gob.sin.sre.fac.dao.impl;

import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import bo.gob.sin.sre.fac.dao.IPruebasCertificacionSistemasDao;
import bo.gob.sin.sre.fac.dto.SeguimientoDetalleCertificacionSistemasDto;
import bo.gob.sin.sre.fac.model.SrePruebasCertificacionSistemas;
import bo.gob.sin.str.ccs.dao.AbstractGenericDao;

@Repository
@Transactional
public class PruebasCertificacionSistemasDaoImpl extends AbstractGenericDao<SrePruebasCertificacionSistemas> implements IPruebasCertificacionSistemasDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(PruebasSistemasDaoImpl.class);
	
	/**
	 * Obtiene la entidad Prueba Certificación Sistemas a travez de la prueba etapa certificación
	 * 
	 * @author: junior.flores
	 * @Fecha: 06/06/2019
	 * @param pEtapaCertificacionSistemasId, código de la etapa de Certificación de Sistemas
	 *        pSistemaId, Código unico de Sistema	 
	 * @return Devuelve una entidad tipo SrePruebasCertificacionSistemas.
	 */
	@Override
	public SrePruebasCertificacionSistemas obtenerPruebasCertificacionSistemasPorEtapa(Long pPruebaEtapaCertificacionId, Long pSistemaId) {
		LOG.info("Ingresando obtenerPruebasAutomaticasPorDocFiscal.");
		SrePruebasCertificacionSistemas vEntidad = new SrePruebasCertificacionSistemas();
		try {
			String vhql = "FROM SrePruebasCertificacionSistemas p WHERE p.pruebaEtapaSistemasId = :pPruebaEtapaCertificacionId and "					
					+ "p.sistemaId=:pSistemaId and p.estadoId = 'AC'";
			vEntidad = (SrePruebasCertificacionSistemas) getSession().createQuery(vhql).setParameter("pPruebaEtapaCertificacionId", pPruebaEtapaCertificacionId).
					    setParameter("pSistemaId", pSistemaId).getSingleResult();
			LOG.info("Informacion recuperada.");
		} catch (Exception e) {
			LOG.info("Informacion no recuperada.");
		}
		return vEntidad;
	}
	
	/**
	* @Descipcion: Realiza el registro del log seleccionado en la grilla del Detalle de Certificación de Pruebas.
	* @author: Peter Flores.
	* @Fecha: 08/07/2019
	* @param pSolicitud: Información necesaria para registrar la etapa de prueba (detalle)
	* @return Devuelve un valor booleano que indica la transacción
	*/
	@Override
	public boolean registroPruebaDetalleOpcional(SeguimientoDetalleCertificacionSistemasDto pSolicitud) {
		boolean respuestaFuncion = false;
		try {
			if (pSolicitud!=null) {
				String vJson=convertDtoToJson(pSolicitud);
				Query query = getSession()
						.createNativeQuery(
								"select sre_recaudaciones.sre_fac_registro_log_prueba_sugerida_por_etapa(:pJson)")
						.setParameter("pJson",vJson);
				respuestaFuncion = (Boolean)query.getSingleResult();
		         		           	
				return respuestaFuncion;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	private String convertDtoToJson(SeguimientoDetalleCertificacionSistemasDto pSolicitud){
  
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = mapperObj.writeValueAsString(pSolicitud);
			System.out.println(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	* @Descipcion: Realiza el registro en las siguientes tablas: 
	* 				- sre_fac_nit_asignados_clientes_proveedor
	* 				- sre_fac_sistemas_contribuyentes
	* 				- re_fac_inicios_sistemas
	* @author: Peter Flores.
	* @Fecha: 22/08/2019
	* @param pSistemaId: C�digo unico del Sistema 
	* 		 pContribuyenteId: C�digo unico del contribuyente
	* 		 pModalidadesFacturacion: Son las modalidades de facturaci�n que pertenece al sistema del contribuyente
	* @return Devuelve un valor booleano que indica la transacción
	*/
	@Override
	public boolean asignarNitProveedores(Long pSistemaId,Long pContribuyenteId, String pModalidadesFacturacion){
		boolean respuestaFuncion = false;
		try {
			if (pSistemaId!=null && pSistemaId>0 && pContribuyenteId!=null && pContribuyenteId>0) {
				Query query = getSession()
						.createNativeQuery(
								"select sre_recaudaciones.sre_fac_reg_asignar_nit_proveedor(:pSistemaId,:pContribuyenteId,:pModalidadesFacturacion)")
						.setParameter("pSistemaId",pSistemaId)
						.setParameter("pContribuyenteId",pContribuyenteId)
						.setParameter("pModalidadesFacturacion",pModalidadesFacturacion);
				respuestaFuncion = (Short)query.getSingleResult()==1?true:false;
		         		           	
				return respuestaFuncion;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
