package com.upc.turismo.rest.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.turismo.entidades.TblEmployees;
import com.upc.turismo.listener.JmsListenerAPI;
import com.upc.turismo.negocio.daoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/Empleado")
public class Empleados {

    @Autowired
    private JmsListenerAPI api;
    @Autowired
    private daoEmployees daoEmployees;

    // C R U D => Enrutado
    // C => CREAR NUEVO
    @PostMapping
    public TblEmployees AñadirEmpleado(@RequestBody TblEmployees Empleado) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(Empleado);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoEmployees.RegistrarEmpleados(Empleado);
        } catch (Exception e){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ERROR: columna mal especificada.");
        }
    }

    // R => LISTAR TODOS
    @GetMapping(value = "/Empleados")
    public List<TblEmployees> todosempleados(){
        return daoEmployees.TodosEmpleados();
    }
    //   => LISTAR ESPECIFICO
    @GetMapping("/Empleados/{CodigoID}")
    public TblEmployees obtenerEmpleados(@PathVariable(value = "CodigoID")Integer CodigoID){
        try {
            return daoEmployees.ObtenerEmpleado(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }
    // U => ACTUALIZAR
    @PutMapping
    public TblEmployees modificarEmpleados(@RequestBody TblEmployees empleados){
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(empleados);
            //System.out.println(jsonString);
            String enviar = api.EnviarRecibir(jsonString);

            return daoEmployees.ModificarEmpleado(empleados);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ERROR: columna mal especificada.");
        }
    }

    // D => ELIMINA
    @DeleteMapping("/Empleados/{CodigoID}")
    public TblEmployees eliminarEmpleados(@PathVariable Integer CodigoID){
        try {
            return daoEmployees.EliminarEmpleado(CodigoID);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: parametro mal escrito o no existe.");
        }
    }
}
