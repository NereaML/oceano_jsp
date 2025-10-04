package com.cursogetafe.oceano.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("CUIDADOR")
public class CuidadorPersonal extends Personal {
    
}
