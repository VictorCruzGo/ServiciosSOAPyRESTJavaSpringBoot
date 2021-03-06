package bo.gob.sin.sre.fac.domain;

import bo.gob.sin.sre.fac.model.SreSistemas;

public interface ISistemasABMDomain {

	/**
	 * Cambiar estado en Solicitud Certificacion 
	 * 
	 * @author: Ivan Salas
	 * @Fecha: 19/09/2018
	 * @modificadoPor: Carmen Rosa Silva
	 * @FechaModificacion: 15/11/2018
	 * @param pSolicitudCertificacionId, id de la tabla solicitud certificacion
	 * @param pUsuario, número de identificacion del usuario
	 * @param pEstadoId, nuevo estado de solicitud certificacion
	 * @return Devuelve objeto SreSolicitudCertificacion.
	 */
	public SreSistemas cambiarEstadoSistema(long pSistemaId, long pUsuario, int pEstadoId);	
}
