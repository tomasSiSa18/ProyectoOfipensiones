package com.chipichipi.ProyectoOfipensiones.servicios;


import org.springframework.stereotype.Service;


@Service
public class UsuariosSerivicio {


    @Autowired
    private FacturaServicio facturaServicio;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Collection<Factura> darFacturasResponsableEconomico(ObjectId id) {
        Collection<Factura> facturasResponsable = new ArrayList<>();

        ResponsableEconomico responsableEconomico = usuarioRepository.findResponsableEconomico(id);

        
        if (responsableEconomico != null) {
            for (Estudiante estudiante : responsableEconomico.getEstudiantesACargo()) {
                Collection<Factura> facturas = facturaServicio.darFacturasEstudiante(estudiante.getId());

                facturasResponsable.addAll(facturas);
            }
        }

        return facturasResponsable;
    }

    public boolean existeUsuario(int id) {
        return true;
    }
    


    
}

