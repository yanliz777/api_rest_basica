package com.yan.restfulapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//Para generar los getter y setter de esta clase
@AllArgsConstructor//Para generar constructor con todos los atributos
@NoArgsConstructor//Para generar constructor vacio
public class Greating {
    private long id;
    private String content;
}
