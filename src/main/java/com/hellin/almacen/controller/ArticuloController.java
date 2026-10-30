package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controlador que gestiona las peticiones relacionadas con los artículos.
 *
 * Recibe las peticiones HTTP y utiliza ArticuloService para obtener los datos.
 *
 * La ruta principal es /api/articulos.
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    //Guardamos una referencia al servicio para poder utilizar sus métodos.
    private final ArticuloService servicio;

    /**
     * Constructor del controlador.
     *
     * Spring proporciona automáticamente el servicio cuando crea el controlador.
     *
     * @param servicio servicio encargado de gestionar los artículos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * Este método corresponde a la issue #6.
     *
     * Cuando alguien realiza una petición GET a /api/articulos,
     * Spring ejecuta este método y devuelve los artículos en formato JSON.
     *
     * Si todo funciona correctamente, la respuesta HTTP es 200 (OK).
     *
     * @return lista completa de artículos del almacén
     */
    @GetMapping
    public List<Articulo> listarTodos() {
        // Pedimos al servicio que obtenga todos los artículos.
        // La implementación de listarTodos() en el servicio
        // corresponde a la issue #7 de Greta.
        return servicio.listarTodos();
    }

    /**
    * Devuelve los datos básicos de un artículo y si está agotado.
    *
    * @param id identificador del artículo
    * @return 200 con el mapa de datos básicos, o 404 si el artículo no existe
    */
    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> basico(@PathVariable Integer id) {
        return servicio.buscarBasico(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    ESTOY_PROVOCANDO_UN_ERROR_DE_COMPILACION
}
