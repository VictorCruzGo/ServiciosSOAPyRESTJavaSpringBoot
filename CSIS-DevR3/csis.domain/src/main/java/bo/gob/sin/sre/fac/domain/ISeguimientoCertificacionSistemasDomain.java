package bo.gob.sin.sre.fac.domain;

import java.util.List;

import bo.gob.sin.sre.fac.dto.DetalleCasosDePruebaEtapa0Dto;
import bo.gob.sin.sre.fac.dto.ListaSeguimientoCertificacionSistemasFaseDosDto;
import bo.gob.sin.sre.fac.dto.SeguimientoCertificacionSistemasDto;
import bo.gob.sin.sre.fac.dto.SeguimientoCertificacionSistemasFaseDosDto;
import bo.gob.sin.sre.fac.dto.SeguimientoDetalleCertificacionSistemasDto;
import bo.gob.sin.sre.fac.dto.SistemasContribuyentesDto;

public interface ISeguimientoCertificacionSistemasDomain {

	/** 
	 * Obtener el porcentaje de la tabla Pruebas de Certificación de Sistemas
	 * 
	 * @author: junior.flores 
	 * @Fecha: 03/06/2019
	 * @param pSistemaId, Código unico de Sistema
	 * 		  pNit, Número de Identificación Tributaria
	 * @return   Devuelve el listado del objeto SeguimientoCertificacionSistemasDto.
	 */
	public List<SeguimientoCertificacionSistemasDto> obtenerListaCertificacionSistemas(Long pSistemaId, Long pNit);
	
	public List<DetalleCasosDePruebaEtapa0Dto> obtenerListaDetalleCasosDePruebaEtapa0(Long pSistemaId, Long pNit);
	
	/** 
	 * Obtener el detalle del seguimiento de Certificación de Sistemas
	 * 
	 * @author: junior.flores 
	 * @Fecha: 14/06/2019
	 * @param pSistemaId, Código unico de Sistema
	 *        pEtapaPruebaCertificacionId, Código unico de la etapa de Certificación de Sistemas 
	 * @return   Devuelve el listado del objeto SeguimientoDetalleCertificacionSistemasDto.
	 */
	public List<SeguimientoDetalleCertificacionSistemasDto> obtenerListaDetalleCertificacionSistemas(Long pSistemaId, Integer pEtapaPruebaCertificacionId, Long pNit);
	
	/** 
	 * Obtener la lista de contribuyentes
	 * 
	 * @author: junior.flores 
	 * @Fecha: 18/06/2019
	 * @param  pSistemaContribuyenteId, Código unico del sistema contribuyente
	 * 		   pEstadoSistemaContribuyenteId, Código unico del estado del sistema contribuyente 
	 * @return   Devuelve el listado del objeto SistemasContribuyentesDto.
	 */
	public List<SistemasContribuyentesDto> obtenerListaSistemaContribuyente(Long pSistemaContribuyenteId, Integer pEstadoSistemaContribuyenteId);
	
	/**
	 * @descripcion Obtiene los casos de prueba de la etapa 0 - Generacion de CUF
	 * @author rosario.garcia
	 * @param pSistemaId
	 * @return Lista de pruebas sugeridas
	 */
	public List<DetalleCasosDePruebaEtapa0Dto> obtenerListaCasosPruebaSugeridosEtapa0(Long pSistemaId);
	
	/** 
	 * Realiza la actualizaci�n del Match para las etapas de Certificaci�n de Sistemas 
	 * 
	 * @author: junior.flores 
	 * @Fecha: 06/09/2019
	 * @param pSistemaId, C�digo unico de Sistema 
	 * 		  pEtapaPruebaCertificacionId, C�digo unico de la etapa de Certificaci�n de Sistemas
	 * @return   Devuelve el listado del objeto SeguimientoDetalleCertificacionSistemasDto.
	 */
	public Short actualizarMatchBd(Long pSistemaId, Integer pEtapaPruebaCertificacionId);
	
	/** 
	 * Obtener el listado de las etapas de la fase 2 del Seguimiento de Certificaci�n de Sistemas
	 * 
	 * @author: junior.flores 
	 * @Fecha: 20/09/2019
	 * @param  pSolicitud, Datos necesarios para obtener el listado
	 * 		   
	 * @return   Devuelve el listado de las etapas de la fase 2 del Seguimiento de Certificaci�n de Sistemas.
	 */
	public List<SeguimientoCertificacionSistemasFaseDosDto> listaEtapaFaseDos(ListaSeguimientoCertificacionSistemasFaseDosDto pSolicitud); 
}
