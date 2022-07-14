package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblCustomer;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/Cliente")
public class Clientes {

    @Autowired
    private daoCustomer daoCustomer;

    @Autowired
    private JmsListenerAPI api;

    // C R U D => Enrutado
    // C => CREAR NUEVO
    @PostMapping
    public TblCustomer añadirClientes(@RequestBody TblCustomer Cliente){
        try {
            // Grabando el LOG
            //Creating the ObjectMapper object

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(Cliente);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoCustomer.RegistrarClientes(Cliente);
        } catch (Exception e) {
            // devolviendo respuesta al cliente
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: Columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/Clientes")
    public List<TblCustomer> todosclientes(){
        return daoCustomer.TodosClientes();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/Clientes/{CodigoID}")
    public TblCustomer obtenerCliente(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {

            return daoCustomer.ObtenerCliente(CodigoID);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: Parametro no encontrado o no existe.");
        }
    }

    //    // U => ACTUALIZAR
    @PutMapping
    public TblCustomer modificarCliente(@RequestBody TblCustomer cliente){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(cliente);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoCustomer.ModificarCliente(cliente);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/Clientes/{CodigoID}")
    public TblCustomer eliminarCliente(@PathVariable Integer CodigoID){
        try {
            return daoCustomer.EliminarCliente(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: Parametro no econtrado o no existe.");
        }
    }
}
