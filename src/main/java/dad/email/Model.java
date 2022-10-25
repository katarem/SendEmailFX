package dad.email;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Model {
    
    private SimpleStringProperty remitenteMail = new SimpleStringProperty();
    private SimpleStringProperty remitentePassword = new SimpleStringProperty();
    private SimpleStringProperty serverSMP = new SimpleStringProperty();
    private SimpleStringProperty destinatarioMail = new SimpleStringProperty();
    private SimpleStringProperty puerto = new SimpleStringProperty();
    private SimpleStringProperty mensaje = new SimpleStringProperty();
    private SimpleStringProperty asunto = new SimpleStringProperty();
    private SimpleBooleanProperty ssl = new SimpleBooleanProperty();
    

    public final SimpleStringProperty remitenteMailProperty() {
		return this.remitenteMail;
	}
	
	public final String getRemitenteMail() {
		return this.remitenteMailProperty().get();
	}
	
	public final void setRemitenteMail(final String remitenteMail) {
		this.remitenteMailProperty().set(remitenteMail);
	}
 
    public final SimpleStringProperty asuntoProperty() {
		return this.asunto;
	}
	
	public final String getAsunto() {
		return this.asuntoProperty().get();
	}
	
	public final void setAunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}

	public final SimpleStringProperty remitentePasswordProperty() {
		return this.remitentePassword;
	}
	
	public final String getRemitentePassword() {
		return this.remitentePasswordProperty().get();
	}
	
	public final void setRemitentePassword(final String remitentePassword) {
		this.remitentePasswordProperty().set(remitentePassword);
	}
	
	public final SimpleStringProperty serverSMPProperty() {
		return this.serverSMP;
	}
	
	public final String getServerSMP() {
		return this.serverSMPProperty().get();
	}
	
	public final void setServerSMP(final String serverSMP) {
		this.serverSMPProperty().set(serverSMP);
	}
	
	public final SimpleStringProperty destinatarioMailProperty() {
		return this.destinatarioMail;
	}
	
	public final String getDestinatarioMail() {
		return this.destinatarioMailProperty().get();
	}
	
	public final void setDestinatarioMail(final String destinatarioMail) {
		this.destinatarioMailProperty().set(destinatarioMail);
	}
	
	public final SimpleStringProperty puertoProperty() {
		return this.puerto;
	}
	
	public final int getPuerto() {
		return Integer.parseInt(this.puertoProperty().getValue());
	}
	
	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	
	public final SimpleStringProperty mensajeProperty() {
		return this.mensaje;
	}
	
	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	
	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	
	public final SimpleBooleanProperty sslProperty() {
		return this.ssl;
	}
	
	public final boolean isSsl() {
		return this.sslProperty().get();
	}
	
	public final void setSsl(final boolean ssl) {
		this.sslProperty().set(ssl);
	}

}
