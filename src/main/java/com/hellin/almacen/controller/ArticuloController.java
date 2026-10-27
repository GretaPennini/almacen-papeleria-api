package com.hellin.almacen.controller;

import com.hellin.almacen.service.ArticuloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    // TODO (#n de la incidencia): GET /api/articulos -> lista de todos los artículos (200)

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
}
