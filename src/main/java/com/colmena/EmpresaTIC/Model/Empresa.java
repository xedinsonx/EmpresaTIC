package com.colmena.EmpresaTIC.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Empresas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdEmpresa;
    private Long Ruc;
    private String RazonSocial;
    private String Direccion;

    private int Estado;


}
