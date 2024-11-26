package com.yan.restfulapp.service.interfaces;

import com.yan.restfulapp.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    public List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
    Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local> findByNameLocal(String name);
}
