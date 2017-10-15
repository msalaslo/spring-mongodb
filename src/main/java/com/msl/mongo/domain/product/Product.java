
package com.msl.mongo.domain.product;

import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

public class Product {

	@Id
    public String id;
    
    public String name;
    
    public String description;
    
    public String empresa;
    
    public String centro;
    
    public String familia;
    
    public String barra;
    
    public String talla;

    public Set<String> tags = null;

    public Product() {}
    
    public Product(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }
    
    public Product(String name, String description, String empresa, String centro, String familia, String barra, String talla) {
        super();
        this.name = name;
        this.description = description;
        this.centro = centro;
        this.empresa = empresa;
        this.familia = familia;
        this.barra = barra;
        this.talla = talla;
    }

    public Product(String name, String description, Set<String> tags) {
        super();
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("id", id).
        		append("name", name).
        		append("centro", centro).
        		append("empresa", empresa).
        		append("familia", familia).
        		append("barra", barra).
        		append("talla", talla).
        		append("tags", tags).
        		toString();
    }

}
