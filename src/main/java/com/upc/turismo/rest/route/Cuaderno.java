package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblBook;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/Cuaderno")
public class Cuaderno {

    @Autowired
    private JmsListenerAPI api;

    @Autowired
    private daoBook daoBook;

    // C R U D => Enrutado
    // C => CREAR NUEVO
    @PostMapping
    public TblBook añadirCuaderno(@RequestBody TblBook Cuaderno) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(Cuaderno);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoBook.RegistrarCuaderno(Cuaderno);

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/Cuadernos")
    public List<TblBook> todocuaderno(){
        return daoBook.TodosRegistros();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/Cuadernos/{CodigoID}")
    public TblBook obtenerCuaderno(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {
            return daoBook.ObtenerRegistro(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro no encontrado o mal escrito.");
        }
    }

    // U => ACTUALIZAR
    @PutMapping
    public TblBook modificarCuaderno(@RequestBody TblBook cuaderno){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(cuaderno);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoBook.ModificarCuaderno(cuaderno);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/Cuadernos/{CodigoID}")
    public boolean eliminarCuaderno(@PathVariable Integer CodigoID){
        try {
            return daoBook.EliminarCuaderno(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }
}
