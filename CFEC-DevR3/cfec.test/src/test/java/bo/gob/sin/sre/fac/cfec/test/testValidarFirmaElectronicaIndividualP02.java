package bo.gob.sin.sre.fac.cfec.test;

import java.util.ArrayList;
import java.util.List;

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
import bo.gob.sin.sre.fac.cfec.dto.RespuestaListaRegistroRecepcionesSoapDto;
import bo.gob.sin.sre.fac.cfec.dto.RespuestaValidacionRecepcionPaqueteDto;
import bo.gob.sin.sre.fac.cfec.dto.RespuestaXmlXsdDto;
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
public class testValidarFirmaElectronicaIndividualP02 {
	private static final Logger LOG = LoggerFactory.getLogger(testValidarFirmaElectronicaIndividualP02.class);
	
	@Autowired
	ICoreFacturacionSoap iCoreFacturacionSoap;
		
	@Autowired
	IValidarRecepcion iValRec;
	
	@Autowired
	IUtilitarios iutil;
	
	@Rollback(false)
	@Test
	public void validarFirmaElectronicaIndividualP02() throws Exception{
		
		// caso ideal 
		List<Integer> vRespuesta = new ArrayList<>();
		XmlRecepcionGenericoDto vArchivoXml = new XmlRecepcionGenericoDto();
		LOG.info("validarDatos de la Recepcion ||Iniciando");
		try {
				
			// factura electronica computarizada
			vArchivoXml.setV_archivo("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"); 
			vArchivoXml.setV_archivoXml(iutil.decodificarArchivo(vArchivoXml.getV_archivo()));
			vRespuesta=iValRec.validarFirmaElectronicaIndividual(vArchivoXml.getV_archivoXml());
				
			LOG.info("testValidarFirmaElectronicaIndicidualP02==>"+vRespuesta.toString());  
		} catch (Exception e) {
			LogExcepcion.registrar(e, LOG, MethodSign.build(vRespuesta));
			LOG.info("registrarRecepcion Estandar||Excepcion");
			vRespuesta.add(88);	// 88 = FORMATO_XSD_INCORRECTO
			
		}
	}
	
}
