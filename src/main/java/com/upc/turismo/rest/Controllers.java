package com.upc.turismo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.listener.JmsListenerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Controllers {

    @Autowired
    private JmsListenerAPI ssl;

    @GetMapping(value = "prueba")
    public boolean redirige(){
        return true;
    }

    @PostMapping
    public String mq5(){
        return ssl.EnviarRecibir("hola mundo");
    }

    /*
    * PROBANDO JSMQ ENVIANDO
    */
//    @JmsListener(destination="${jms.cola.envio}")
//    public void miMensaje(String mensajeJson) {
//        System.out.println("Recibido:" + mensajeJson);
//        //mensajeJSON a Objeto Auto
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            //convirtiendo de JSON a Auto
//            Auto auto =  mapper.readValue(mensajeJson, Auto.class);
//            auto.setRespuesta("Registrar a Tabla");
//            System.out.println(mensajeJson);
//            Auto respuesta = negocio.grabar(auto);//registra en la base de  datos
//
//            if (respuesta == null) {
//                System.out.println("No se pudo registrar");
//            }
//            else {
//                System.out.println("Registrado ok!");
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            System.out.println(e.getMessage());
//            System.out.println("No se pudo registrar");
//        }
//    }
//
//    @GetMapping("/enviar/{mensaje}")
//    @PostMapping("/enviar/{mensaje}")
//    public String enviable(@PathVariable(value = "mensaje") String mensaje){
//        jmsProductorConsumidor.enviarRecibir(mensaje);
//        return "OK";
//    }
}
