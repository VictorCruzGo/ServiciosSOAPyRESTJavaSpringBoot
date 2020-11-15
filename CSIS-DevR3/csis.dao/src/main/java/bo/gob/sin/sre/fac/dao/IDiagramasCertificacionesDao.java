package bo.gob.sin.sre.fac.dao;

import java.util.List;

import bo.gob.sin.sre.fac.model.SreDiagramasCertificaciones;
import bo.gob.sin.str.ccs.dao.GenericDao;

//RCR
public interface IDiagramasCertificacionesDao extends GenericDao<SreDiagramasCertificaciones>{

	/** 
	 * Realiza el listado de del diagrama de certificaciones 
	 * 
	 * @author: junior.flores 
	 * @Fecha:  24/09/2019
	 * @param   pEtapaId, C�digo unico de la Etapa.
	 * 		    pSistemaId, C�digo unico del sistema.
	 * 		    pSolicitudCertificacionId, C�digo unico de la solicitud de certificaci�n.	   		   
	 * @return  Devuelve la lista SreDiagramasCertificaciones.
	 */
	public List<SreDiagramasCertificaciones> recuperaListaDiagramasCertificaciones(long pEtapaId, long pSistemaId, long pSolicitudCertificacionId);
}
