package bo.gob.sin.sre.fac.cfec.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bo.gob.sin.config.AppConfig;
import bo.gob.sin.sre.fac.cfec.dto.RespuestaValidacionRecepcionPaqueteDto;
import bo.gob.sin.sre.fac.cfec.dto.XmlRecepcionGenericoDto;
import bo.gob.sin.sre.fac.cfec.dto.interfaces.Respuesta;
import bo.gob.sin.sre.fac.cfec.dto.parameter.Parametros;
import bo.gob.sin.sre.fac.cfec.servicedomain.ICoreFacturacionSoap;
import bo.gob.sin.sre.fac.cfec.servicedomain.IUtilitarios;
import bo.gob.sin.sre.fac.cfec.servicedomain.IValidarRecepcion;
import bo.gob.sin.sre.fac.cfec.servicedomain.validation.CodigosMensajesServiciosSOAPServiceImpl;
import bo.gob.sin.str.cexc.LogExcepcion;
import bo.gob.sin.str.cexc.MethodSign;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback 
public class TestValidarRecepcionPaqueteP01 {
	private static final Logger LOG = LoggerFactory.getLogger(TestValidarRecepcionPaqueteP01.class);
	
	@Autowired
	ICoreFacturacionSoap iCoreFacturacionSoap;
		
	@Autowired
	IValidarRecepcion iValRec;
	
	@Autowired
	IUtilitarios iutil;
	
	@Rollback(false)
	@Test
	public void validarRecepcionPaqueteP01() throws Exception{
		// computarizada
		XmlRecepcionGenericoDto vArchivoXml = new XmlRecepcionGenericoDto();

		Respuesta vRespuesta = new Respuesta();
		LOG.info("recepcionFactura ||Iniciando");
		try {
			//***            
			vArchivoXml.setP_codigo_sistema("9BB347E");
			vArchivoXml.setP_tipo_ambiente_id(2);
			vArchivoXml.setP_tipo_emision_id(2);
			vArchivoXml.setP_tipo_modalidad_id(3); //error
			vArchivoXml.setP_nit(1020703023L);
			vArchivoXml.setP_cuis("85EA4EE9");
			vArchivoXml.setP_cufd("16597E97098BF8FCF84A9E06CEF0BCD2");
			vArchivoXml.setP_tipo_documento_fiscal_id(1);
			vArchivoXml.setP_tipo_documento_sector_id(1);
			vArchivoXml.setP_sucursal_id(0);
			vArchivoXml.setP_punto_venta_id(null);			
			vArchivoXml.setP_fecha_envio("2019-05-15T20:22:00.829");
			vArchivoXml.setV_recepcionPaqueteId(140L);
			RespuestaValidacionRecepcionPaqueteDto vRespuestaDto = iCoreFacturacionSoap.CoreFacturacionPrincipalPaquete(vArchivoXml, Parametros.ValidacionRecepcionPaquete);
			// conversion a interfaces
			vRespuesta.setCodigoRecepcion(vRespuestaDto.getCodigoRecepcion());
			vRespuesta.setTransaccion(vRespuestaDto.isTransaccion());
			vRespuesta.setCodigoEstado(vRespuestaDto.getCodigoEstado());
			vRespuesta.setListaCodigosRespuestas(vRespuestaDto.getListaCodigosRespuestas());

			LOG.info("TestRecepcionPaqueteP01 Estandar ==>"+vRespuesta.toString());

		} catch (Exception e) {
			LogExcepcion.registrar(e, LOG, MethodSign.build(vRespuesta));
			LOG.info("registrarRecepcion Estandar||Excepcion");
			vRespuesta.setCodigoRecepcion(0L);
			vRespuesta.setTransaccion(false);
			vRespuesta.setCodigoEstado(CodigosMensajesServiciosSOAPServiceImpl.RECEPCION_RECHAZADA);
			vRespuesta.getListaCodigosRespuestas().add(CodigosMensajesServiciosSOAPServiceImpl.ERROR_DE_EJECUCION_DEL_SERVICIO);
		}
	}

	
	}
