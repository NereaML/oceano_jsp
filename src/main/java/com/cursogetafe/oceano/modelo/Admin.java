package com.cursogetafe.oceano.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Personal {
    
	
}
