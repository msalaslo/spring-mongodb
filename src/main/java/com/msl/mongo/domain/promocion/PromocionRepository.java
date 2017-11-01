package com.msl.mongo.domain.promocion;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromocionRepository extends MongoRepository<Promocion, String>{//, PromocionRepositoryCustom {

	public Promocion save(Promocion product);
    public Promocion findById(String id);
    public List<Promocion> findByEmpresa(String empresa);
    public List<Promocion> findByCentro(String centro);
    public List<Promocion> findByDivision(String division);
    public List<Promocion> findByFamilia(String familia);    
    public List<Promocion> findAll();

}
