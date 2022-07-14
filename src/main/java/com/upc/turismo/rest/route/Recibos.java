package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblReceipt;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoBook;
import com.upc.turismo.negocio.daoReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/Recibo")
public class Recibos {

    @Autowired
    private JmsListenerAPI api;

    @Autowired
    private daoReceipt daoReceipt;
    // C R U D => Enrutado
    // C => CREAR NUEVO

    @PostMapping
    public TblReceipt añadirRecibos(@RequestBody TblReceipt recibo) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(recibo);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoReceipt.RegistarRecibo(recibo);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/Recibos")
    public List<TblReceipt> todosrecibos(){
        return daoReceipt.TodosRecibos();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/Recibos/{CodigoID}")
    public TblReceipt obtenerRecibos(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {
            return daoReceipt.ObtenerRecibo(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }

    // U => ACTUALIZAR
    @PutMapping
    public TblReceipt modificarRecibos(@RequestBody TblReceipt recibos){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(recibos);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoReceipt.ModificarRecibo(recibos);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/Recibos/{CodigoID}")
    public TblReceipt eliminarRecibos(@PathVariable Integer CodigoID){
        try {
            return daoReceipt.EliminarRecibo(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }
}
