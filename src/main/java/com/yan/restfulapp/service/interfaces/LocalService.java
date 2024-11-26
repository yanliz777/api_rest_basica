package com.yan.restfulapp.service.interfaces;

import com.yan.restfulapp.entity.Local;
import com.yan.restfulapp.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    public List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
    Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local> findByNameLocal(String name);
    Optional<Local> findByNameIgnoreCase(String name);
    Local findLocalById(Long id) throws LocalNotFoundException;
}
