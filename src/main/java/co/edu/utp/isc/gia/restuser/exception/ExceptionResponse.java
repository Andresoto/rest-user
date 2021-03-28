
package co.edu.utp.isc.gia.restuser.exception;

import java.util.Date;

/**
 *
 * @author Andres Soto
 */
public class ExceptionResponse {
  private Date timestamp;
  private String mensaje;
  private String detalles;
  private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String mensaje, String detalles, String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.httpCodeMessage = httpCodeMessage;
    }
  
  
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }
  
  
}
