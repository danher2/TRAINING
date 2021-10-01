package org.aguzman.poointerfaces.repositorio;


//herencia multiple pero de interfaces 1 sola interfaz que agrupa todo
public interface OrdenablePaginableCrudRepositorio extends OrdenableRepositorio,
                        PaginableRepositorio, CrudRepositorio, ContableRepositorio {
}
