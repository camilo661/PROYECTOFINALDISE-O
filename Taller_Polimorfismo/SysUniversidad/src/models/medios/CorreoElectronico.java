package models.medios;

import enums.Estado;
import models.MedioNotificacion;
import models.Notificacion;

public class CorreoElectronico extends MedioNotificacion {

    private String remitente;

    public CorreoElectronico() {
        this.remitente = " ";
    }

    public CorreoElectronico(String remitente) {
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    @Override
    public String enviarMensaje(Notificacion notificacion) {
        return "Enviando notificacion por medio de Correo Electronico desde: " + remitente + "\n" +
                "  Para: " + notificacion.getDestinatario().getCorreoElectronico() + "\n" +
                "  Mensaje: " + notificacion.getMensaje() + "\n" +
                "  Tipo: " + notificacion.getTipo();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[ remitente = " + remitente + "]";
    }
}
