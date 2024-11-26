package com.yan.restfulapp.repository;

import com.yan.restfulapp.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {
    //Traemos un registro por su nombre:
    //consulta con JPQL:
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalByNameWithJPQLAnd(String name);

    //Misma Consulta pero utilizando inversión de control de Spring Data JPA:
    Optional<Local> findByName(String name);
}
