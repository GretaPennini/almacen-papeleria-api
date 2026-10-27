package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Articulo> listarTodos() {
        // TODO (#n de la incidencia): devolver todos los artículos. Pista: repositorio.findAll()
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    /**
 * Busca un artículo por su identificador y devuelve un resumen con sus datos
 * básicos (id, nombre y stock).
 * <p>
 * Si el artículo existe pero no tiene unidades disponibles (stock igual a 0),
 * se añade al resumen la clave {@code "mensaje"} con el valor {@code "Agotado"}.
 * Las claves del mapa se mantienen en orden de inserción.
 * </p>
 *
 * @param id identificador del artículo que se quiere consultar
 * @return un {@code Optional} con un mapa que contiene {@code id}, {@code nombre}
 *         y {@code stock} (y {@code mensaje} si el artículo está agotado), o
 *         {@code Optional.empty()} si no existe ningún artículo con ese id
 */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
    Optional<Articulo> encontrado = repositorio.findById(id);

    if (encontrado.isEmpty()) {
        return Optional.empty();
    }

    Articulo articulo = encontrado.get();
    Map<String, Object> resumen = new LinkedHashMap<>();
    resumen.put("id", articulo.getId());
    resumen.put("nombre", articulo.getNombre());
    resumen.put("stock", articulo.getStock());
    if (articulo.getStock() == 0) {
        resumen.put("mensaje", "Agotado");
    }
    return Optional.of(resumen);
}
}
