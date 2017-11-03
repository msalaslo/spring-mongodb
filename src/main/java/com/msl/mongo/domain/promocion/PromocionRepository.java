package com.msl.mongo.domain.promocion;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromocionRepository extends MongoRepository<Promocion, String>{//, PromocionRepositoryCustom {

	public Promocion save(Promocion product);
    public Promocion findById(String id);
    public List<Promocion> findByCempresa(String cempresa);
    public List<Promocion> findByCentrooo(String centrooo);
    public List<Promocion> findByCdivisio(String cdivisio);
    public List<Promocion> findByCfamilia(String cfamilia);    
    public List<Promocion> findAll();

}
