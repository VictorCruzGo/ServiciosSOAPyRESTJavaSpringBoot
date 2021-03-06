package bo.gob.sin.sre.fac.cfec.dto.interfaces;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(SolicitudRecepcionNaliAdapter.class)
public interface ISolicitudRecepcionNali {

	String getCodigoSistema();

	Integer getCodigoAmbiente();

	Integer getCodigoEmision();

	Integer getCodigoModalidad();

	Long getNit();

	String getCuis();

	String getCufd();

	Integer getCodigoDocumentoFiscal();

	Integer getCodigoDocumentoSector();

	Integer getCodigoSucursal();

	Integer getCodigoPuntoVenta();

	Date getFechaEnvio();

	String getArchivo();

	String getHashArchivo();

	Long getCodigoAutorizacion();

	@XmlElement(required = true)
	void setCodigoSistema(String codigoSistema);

	@XmlElement(required = true)
	void setCodigoAmbiente(Integer codigoAmbiente);

	@XmlElement(required = true)
	void setCodigoEmision(Integer codigoEmision);

	@XmlElement(required = true)
	void setCodigoModalidad(Integer codigoModalidad);

	@XmlElement(required = true)
	void setNit(Long nit);

	@XmlElement(required = true)
	void setCuis(String cuis);

	@XmlElement(required = true)
	void setCufd(String cufd);

	@XmlElement(required = true)
	void setCodigoDocumentoFiscal(Integer codigoDocumentoFiscal);

	@XmlElement(required = true)
	void setCodigoDocumentoSector(Integer codigoDocumentoSector);

	@XmlElement(required = true)
	void setCodigoSucursal(Integer codigoSucursal);

	@XmlElement(nillable = true)
	void setCodigoPuntoVenta(Integer codigoPuntoVenta);

	@XmlElement(required = true)
	void setFechaEnvio(Date fechaEnvio);

	@XmlElement(required = true)
	void setArchivo(String archivo);

	@XmlElement(required = true)
	void setHashArchivo(String hashArchivo);

	@XmlElement(required = true)
	void setCodigoAutorizacion(Long codigoAutorizacion);
}