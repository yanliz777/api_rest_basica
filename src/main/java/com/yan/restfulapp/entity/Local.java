package com.yan.restfulapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//Con esto le decimos a spring que esta clase tiene que mapearse a la BD
@Table(name = "locals")//Con esto le indicamos el nombre de la tabla en la BD
@Data//Para generar los getter y setter de esta clase
@AllArgsConstructor//Para generar constructor con todos los atributos
@NoArgsConstructor//Para generar constructor vacio
@Builder//Para utilizar el patron de diseño builder
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String floor;
    private String code;

}
