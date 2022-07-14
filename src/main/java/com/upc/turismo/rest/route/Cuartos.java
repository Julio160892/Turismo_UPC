package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblRoom;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/Cuarto")
public class Cuartos {

    @Autowired
    private JmsListenerAPI api;

    @Autowired
    private daoRoom daoRoom;

    // C R U D => Enrutado
    // C => CREAR NUEVO
    @PostMapping
    public TblRoom añadirCuartos(@RequestBody TblRoom cuarto) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(cuarto);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoRoom.RegistrarCuarto(cuarto);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/Cuartos")
    public List<TblRoom> todoscuartos(){
        return daoRoom.TodosCuartos();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/Cuartos/{CodigoID}")
    public TblRoom obtenerCuartos(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {
            return daoRoom.ObtenerCuarto(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }

    // U => ACTUALIZAR
    @PutMapping
    public TblRoom modificarCuartos(@RequestBody TblRoom cuartos){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(cuartos);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoRoom.RegistrarCuarto(cuartos);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/Cuartos/{CodigoID}")
    public TblRoom eliminarCuartos(@PathVariable Integer CodigoID){
        try {
            return daoRoom.EliminarCuarto(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }
}
