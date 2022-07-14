package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblPaymentMethod;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/MetodoPago")
public class MetodoPago {

    @Autowired
    private JmsListenerAPI api;
    @Autowired
    private daoPaymentMethod daoPaymentMethod;

    // C R U D => Enrutado
    // C => CREAR NUEVO
    @PostMapping
    public TblPaymentMethod añadirMetodoPago(@RequestBody TblPaymentMethod metodopago) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(metodopago);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoPaymentMethod.RegistrarTipoPago(metodopago);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/MetodosPago")
    public List<TblPaymentMethod> todosmetodospago(){
        return daoPaymentMethod.TodosTipoPagos();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/MetodosPago/{CodigoID}")
    public TblPaymentMethod obtenerMetodoPago(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {
            return daoPaymentMethod.ObtenerTipoPago(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }

    // U => ACTUALIZAR
    @PutMapping
    public TblPaymentMethod modificarMetodoPago(@RequestBody TblPaymentMethod metodopago){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(metodopago);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoPaymentMethod.ModficarTipoPago(metodopago);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/MetodosPago/{CodigoID}")
    public TblPaymentMethod eliminarMetodoPago(@PathVariable Integer CodigoID){
        try {
            return daoPaymentMethod.EliminarTipoPago(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: paramtro mal escrito o no existe.");
        }
    }
}
