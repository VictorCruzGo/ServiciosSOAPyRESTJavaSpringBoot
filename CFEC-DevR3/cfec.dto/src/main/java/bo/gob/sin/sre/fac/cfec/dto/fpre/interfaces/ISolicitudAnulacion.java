package bo.gob.sin.sre.fac.cfec.dto.fpre.interfaces;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(SolicitudAnulacionAdapter.class)
public interface ISolicitudAnulacion {

	String getCodigoSistema();

	Integer getCodigoAmbiente();

	Integer getCodigoEmision();

	Integer getCodigoModalidad();

	Long getNit();

	String getCuis();

	String getCufd();
	
	String getCuape();

	Integer getCodigoDocumentoFiscal();

	Integer getCodigoDocumentoSector();

	Integer getCodigoSucursal();

	Integer getCodigoPuntoVenta();

	Long getNumeroDocumentoFiscal();
	
	String getCufp();

	Integer getCodigoMotivo();

	@XmlElement(required=true)
	void setCodigoSistema(String codigoSistema);

	@XmlElement(required=true)
	void setCodigoAmbiente(Integer codigoAmbiente);

	@XmlElement(required=true)
	void setCodigoEmision(Integer codigoEmision);

	@XmlElement(required=true)
	void setCodigoModalidad(Integer codigoModalidad);

	@XmlElement(required=true)
	void setNit(Long nit);

	@XmlElement(required=true)
	void setCuis(String cuis);

	@XmlElement(required=true)
	void setCufd(String cufd);
	
	@XmlElement(required=true)
	void setCuape(String cuape);

	@XmlElement(required=true)
	void setCodigoDocumentoFiscal(Integer codigoDocumentoFiscal);

	@XmlElement(required=true)
	void setCodigoDocumentoSector(Integer codigoDocumentoSector);

	@XmlElement(required=true)
	void setCodigoSucursal(Integer codigoSucursal);

	@XmlElement(nillable = true)
	void setCodigoPuntoVenta(Integer codigoPuntoVenta);

	@XmlElement(required=true)
	void setNumeroDocumentoFiscal(Long numeroDocumentoFiscal);

	@XmlElement(required=true)
	void setCufp(String cufp);

	@XmlElement(required=true)
	void setCodigoMotivo(Integer codigoMotivo);
}