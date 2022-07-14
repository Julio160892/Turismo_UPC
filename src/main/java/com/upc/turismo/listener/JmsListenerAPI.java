package com.upc.turismo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.UUID;

@Component
public class JmsListenerAPI {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.cola.envio}")
    private String colaDestino;

//    @Value("${jms.cola.respuesta}")
//    private String colaRespuesta;

    //@JmsListener(destination = "${jms.cola.envio}")
    // =================================================================================================================  //

    public String EnviarRecibir(String msg){

        // random ID
        String corrID = UUID.randomUUID().toString();

        jmsTemplate.convertAndSend( colaDestino, msg, m -> {
            m.setJMSCorrelationID(corrID);
            return m;
        });
        // llega a la cola
        System.out.println("ENVIANDO MENSAJE:" + msg);

        String respuesta = (String) jmsTemplate.receiveSelectedAndConvert( colaDestino,
                "JMSCorrelationID='"+corrID+"'");
        System.out.println("RECIBIENDO RESPUESTA:" + respuesta);

        // para retornar un msg
        return respuesta;
    }

    // =================================================================================================================  //

//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//    @Value("${jms.cola.respuesta}")
//    String destinationQueue;
//
//    @JmsListener(destination="${jms.cola.envio}")
//    public void miMensaje(String mensajeJson, JmsMessageHeaderAccessor headerAccessor) {
//
//        LOGGER.debug("Mensaje: Recibido: " + mensajeJson);
//
//        String corrId;
//        corrId = headerAccessor.getCorrelationId();
//        System.out.println("Mensaje: ID =+1:" + corrId);
//
//        String nuevoMensaje = "Bienvenido ya estás registrado " + mensajeJson + "!";
//
//        System.out.println("Mensaje: Respondiendo: "+ nuevoMensaje);
//        jmsTemplate.convertAndSend(destinationQueue, nuevoMensaje, m -> {
//            m.setJMSCorrelationID(corrId);
//            return m;
//        });
//    }
}
