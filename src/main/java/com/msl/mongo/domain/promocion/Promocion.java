
package com.msl.mongo.domain.promocion;

import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

public class Promocion {

	@Id
    public String id;
     
	//123
    public String empresa;
    
    //1234
    public String centro;
    
    //12
    public String division;
    
    //1234
    public String departamento;
    
    //123
    public String familia;
    
    //12345
    public String barra;
    
    //123
    public String talla;
    
    //123..8
    public String codPromocion;
    
    //123..27
    public String resto;

    public Promocion() {}
    
    public Promocion(String empresa, String centro, String division, String departamento, String familia, String barra, String talla, String codPromocion, String resto) {
        super();
        this.id = UUID.randomUUID().toString();
        this.centro = centro;
        this.empresa = empresa;
        this.division = division;
        this.departamento = departamento;
        this.familia = familia;
        this.barra = barra;
        this.talla = talla;
        this.codPromocion = codPromocion;
        this.resto = resto;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("id", id).
        		append("centro", centro).
        		append("empresa", empresa).
        		append("division", division).
        		append("departamento", departamento).
        		append("familia", familia).
        		append("barra", barra).
        		append("talla", talla).
        		append("codPromocion", codPromocion).
        		append("resto", resto).
        		toString();
    }

}
