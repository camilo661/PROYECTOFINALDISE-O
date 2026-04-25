import enums.Estado;
import enums.TipoNotificacion;
import models.Destinatario;
import models.Notificacion;
import models.medios.AppMovil;
import models.medios.CorreoElectronico;
import models.medios.MensajeTexto;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        //hora local creada en una variable
        LocalDateTime fecha =  LocalDateTime.now();

        //crear el objeto de la clase Destinatario que en realidad podría ser Usuario
        Destinatario usuario1 = new Destinatario(1, "Carlos Gomez", "3001234567", "carlos@uni.edu.co");
        //datos del destinario
        System.out.println(usuario1);

        System.out.println();
        //crear el objeto del medio por el cual se va a enviar el mensaje
        CorreoElectronico correo   = new CorreoElectronico("notificaciones@universidad.edu.co");
        MensajeTexto sms      = new MensajeTexto("Claro Colombia");
        AppMovil appMovil = new AppMovil("token-dispositivo-abc123");


        // crear el objeto de Notificacion para publicacion de calificaciones
        Notificacion n1 = new Notificacion(1, usuario1, "Se han publicado las calificaciones del periodo 2025-1.", fecha, Estado.ENVIADO, correo, TipoNotificacion.PUBLICACION_CALIFICACIONES);

        //enviar mensaje
        System.out.println(sms.enviarMensaje(n1));
        System.out.println();
        //estado de la notificacion
        System.out.println(n1);
        System.out.println();


        // crear el objeto de Notificacion para recordatorio de Matricula por mensaje de Texto
        Notificacion n2 = new Notificacion(2, usuario1, "Recuerde que el periodo de matriculas cierra el 30 de junio.", fecha, Estado.ENVIADO, sms, TipoNotificacion.RECORDATORIO_MATRICULA);
        //enviar mensaje
        System.out.println(appMovil.enviarMensaje(n2));
        //estado de la notificacion
        System.out.println();
        System.out.println(n2);
        System.out.println();


        // crear el objeto de Notificacion para Cancelacion de Clase por AppMovil
        Notificacion n3 = new Notificacion(3, usuario1, "La clase de Calculo III del dia de hoy ha sido cancelada.", fecha, Estado.ENVIADO, appMovil, TipoNotificacion.CANCELACION_CLASE);
        //enviar mensaje
        System.out.println(correo.enviarMensaje(n3));
        System.out.println();
        //estado de la notificacion
        System.out.println(n3);
        System.out.println();


        //crear el objeto de Notificacion para confirmacion de Inscripcion a evento por Correo Electronico
        Notificacion n4 = new Notificacion(4, usuario1, "Su inscripcion al evento de Taekwondo.", fecha, Estado.ENVIADO, correo, TipoNotificacion.CONFIRMACION_INSCRIPCION);
        //enviar mensaje
        System.out.println(correo.enviarMensaje(n4));
        System.out.println();
        //estado de la notificacion
        System.out.println(n4);




    }
}