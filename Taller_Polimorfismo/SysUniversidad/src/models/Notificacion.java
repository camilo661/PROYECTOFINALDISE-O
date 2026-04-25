package models;
import enums.Estado;
import enums.TipoNotificacion;

import java.time.LocalDateTime;

public class Notificacion {

    private int codigo;
    private Destinatario destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private Estado estado;
    private MedioNotificacion medio;
    private TipoNotificacion tipo;

    public Notificacion() {
    }

    public Notificacion(MedioNotificacion medio, TipoNotificacion tipo) {
        this.medio = medio;
        this.tipo = tipo;
    }

    public Notificacion(int codigo, Destinatario destinatario, String mensaje, LocalDateTime fechaEnvio, Estado estado) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }

    public Notificacion(int codigo, Destinatario destinatario, String mensaje, LocalDateTime fechaEnvio, Estado estado, MedioNotificacion medio, TipoNotificacion tipo) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.medio = medio;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public MedioNotificacion getMedio() {
        return medio;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "codigo=" + codigo +
                ", destinatario=" + destinatario +
                ", mensaje='" + mensaje + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", estado=" + estado +
                ", medio=" + medio +
                ", tipo=" + tipo +
                '}';
    }
}
