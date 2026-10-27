package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Servicio con la lógica de negocio relacionada con los artículos del almacén.
 * 
 * <p>Actúa como puente entre la capa de controladores y el repositorio {@link ArticuloRepository}, que es quien accede a la base de datos.</p>
 */
@Service
public class ArticuloService {

    /** Repositorio usado para consultar los artículos en la base de datos */
    private final ArticuloRepository repositorio;

    /**
     * Crea el servicio con el repositorio indicado.
     * 
     * @param repositorio repositorio de artículos
     */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Devuelve todos los artículos almacenados
     * 
     * @return lista con todos los artículos. Si no hay ninguno estará vacía
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // TODO (#n de la incidencia): buscar el artículo por id y devolver un mapa con id, nombre y stock.
        // Si el stock es 0, añadir "mensaje": "Agotado". Si no existe, Optional.empty().
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
