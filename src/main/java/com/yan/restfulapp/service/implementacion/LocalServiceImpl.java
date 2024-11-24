package com.yan.restfulapp.service.implementacion;

import com.yan.restfulapp.entity.Local;
import com.yan.restfulapp.repository.LocalRepository;
import com.yan.restfulapp.service.interfaces.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service//con esto le indicamos a spring que acá está nuestra capa de servicio
public class LocalServiceImpl implements LocalService {

    //inyectamos el repositorio:
    @Autowired
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);//guardamos el objeto
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localDB = localRepository.findById(id).get();

    /*
     Los siguientes condicionales Verifican/validad que el atributo 'code' de 'local' no
     sea null ni tampoco tenga una cadena vacía antes de asignar el valor de 'local.getCode()'
     al atributo 'code' de 'localDB'.
     */
        if(Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode()))
        {
            localDB.setCode(local.getCode());
        }

        if(Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor()))
        {
            localDB.setFloor(local.getFloor());
        }

        if(Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName()))
        {
            localDB.setName(local.getName());
        }

        return localRepository.save(localDB);//guardamos el objeto actualizado
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }
}
