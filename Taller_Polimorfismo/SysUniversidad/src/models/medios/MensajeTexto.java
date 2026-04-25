package models.medios;

import enums.Estado;
import models.MedioNotificacion;
import models.Notificacion;

public class MensajeTexto extends MedioNotificacion {

    private String operador;

    public MensajeTexto() {
        this.operador = "";
    }
    
    public MensajeTexto(String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String enviarMensaje(Notificacion notificacion) {
        return "Enviando notificacion por Mensaje de Texto a traves del "  + "Operador: " + operador + " ]\n" +
                "  al numero : " + notificacion.getDestinatario().getTelefono() + "\n" +
                "  Mensaje: " + notificacion.getMensaje() + "\n" +
                "  Tipo: " + notificacion.getTipo();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[ operador = " + operador + "]";

    }
}
