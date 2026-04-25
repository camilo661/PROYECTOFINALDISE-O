package models.medios;

import enums.Estado;
import models.MedioNotificacion;
import models.Notificacion;

import java.util.UUID;

public class AppMovil extends MedioNotificacion {

    private String tokenDispositivo;

    public AppMovil() {
        this.tokenDispositivo = " ";
    }
    
    public AppMovil(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    @Override
    public String enviarMensaje(Notificacion notificacion) {
       return   "Enviando notificación a través de la aplicación móvil\n" +
                "  Token Dispositivo: " + tokenDispositivo + "\n" +
                "  Para: " + notificacion.getDestinatario().getNombre() + "\n" +
                "  Mensaje: " + notificacion.getMensaje() + "\n" +
                "  Tipo: " + notificacion.getTipo();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[ tokenDispositivo = " + tokenDispositivo + "]";

    }
}
