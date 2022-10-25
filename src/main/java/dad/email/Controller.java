package dad.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{

    private Model model;

    @FXML
    GridPane view;

    @FXML
    Label servidorLabel, ssLabel,fromlLabel,toLabel,subjectLabel;

    @FXML
    TextField servidorField, fromField, toField, subjectField, puertoField;

    @FXML
    TextArea mensajeField;

    @FXML
    Button sendButton, vaciarButton, closeButton;

    @FXML
    CheckBox sslCheck;

    @FXML
    PasswordField passField;

    public Controller() throws IOException{

        //Cargamos FXML
        FXMLLoader f = new FXMLLoader(getClass().getResource("/interfaz.fxml"));
        f.setController(this);
        f.load();

        model = new Model();

        //Bindings
        model.destinatarioMailProperty().bind(toField.textProperty());
        model.remitenteMailProperty().bind(fromField.textProperty());
        model.remitentePasswordProperty().bind(passField.textProperty());
        model.serverSMPProperty().bind(servidorField.textProperty());
        model.mensajeProperty().bind(mensajeField.textProperty());
        model.asuntoProperty().bind(subjectField.textProperty());
        model.puertoProperty().bind(puertoField.textProperty());
        model.sslProperty().bind(sslCheck.selectedProperty());

        //EventListeners
        sendButton.setOnAction(e -> enviarMail(e));
        closeButton.setOnAction(e -> cerrar(e));
        vaciarButton.setOnAction(e -> vaciar(e));

    }

    private void vaciar(ActionEvent e) {
        fromField.setText("");
        toField.setText("");
        passField.setText("");
        mensajeField.setText("");
        servidorField.setText("");
        puertoField.setText("");
        sslCheck.setSelected(false);
        subjectField.setText("");

    }

    private void cerrar(ActionEvent e) {
        App.primaryStage.close();
    }

    private void enviarMail(ActionEvent e) {
        Email email = new SimpleEmail();
        Alert alerta;
        try {
            email.setHostName(model.getServerSMP());
            email.setSmtpPort(model.getPuerto());
            email.setAuthenticator(new DefaultAuthenticator(model.getRemitenteMail(), model.getRemitentePassword()));
            email.setSSLOnConnect(model.isSsl());
            email.setFrom(model.getRemitenteMail());
            email.setSubject(model.getAsunto());
            email.setMsg(model.getMensaje());
            email.addTo(model.getDestinatarioMail());
            email.send();
            alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle(String.format("Enviado con éxito a '%s'", model.getDestinatarioMail()));
            alerta.setContentText("Su correo le llegará a su destinatario en unos minutos.");
            alerta.show();
            toField.setText("");
            mensajeField.setText("");
            subjectField.setText("");
        } catch (Exception e1) {
            alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText(e1.getMessage());
            alerta.show();
            e1.printStackTrace();
        } 
    }

    public GridPane getView() {
        return view;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
