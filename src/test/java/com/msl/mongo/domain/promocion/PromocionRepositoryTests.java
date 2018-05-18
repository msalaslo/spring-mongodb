package com.msl.mongo.domain.promocion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.domain.promocion.PromocionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocionRepositoryTests {

	@Autowired
	PromocionRepository repository;

	Promocion silla, reloj, galletas;

	String cempresa = "123";
	String centrooo = "1234";
	String canlvnta = "U";
	String codpromoci = "12345678";
	String cdepartm = "1234";
	String cfamilia = "123";
	String cbarraaa = "1234";
	String ctallaec = "123";
	String dticprom = "12";
	String cdivisio = "12";
	String cniveln = "1";
	String xexcluye = "1";
	String cfabrica = "123456";
	String cmarmuma = "12345678901234";

	String finiefec = "20170101";
	String ffinefec = "20180101";
	String choraini = "0800";
	String chorafin = "0000";
	String cemprvnt = "001";
	String ccentvnt = "0001";
	String despromo = "Descripcion promocion";
	String ccarpeta = "01234567890123";
	String descarpe = "Descripcion carpeta";
	String coorigen = "123";
	String codplaex = "123456789012345678901234";
	String chordiad = "123";
	String chordiah = "456";
	String xtipobon = "B";
	String xusopweb = "W";

	@Before
	public void setUp() {

		// repository.deleteAll();
		String codpromoci = "87654321";
		silla = repository.save(new Promocion(
						String.format("%03d",Integer.valueOf(cempresa)), 
						String.format("%04d",Integer.valueOf(centrooo)),
						String.format("%02d",Integer.valueOf(canlvnta)),
						String.format("%08d",Integer.valueOf(codpromoci)),
						String.format("%04d",Integer.valueOf(cdepartm)),
						String.format("%03d",Integer.valueOf(cfamilia)),
						String.format("%05d",Integer.valueOf(cbarraaa)),
						String.format("%03d",Integer.valueOf(ctallaec)),
						String.format("%03d",Integer.valueOf(dticprom)), 
						String.format("%02d",Integer.valueOf(cdivisio)), 
						String.format("%01d",Integer.valueOf(cniveln)), 
						String.format("%01d",Integer.valueOf(xexcluye)), 
						String.format("%05d",Integer.valueOf(cfabrica)), 
						String.format("%014d",Integer.valueOf(cmarmuma)), 
						String.format("%08d",Integer.valueOf(finiefec)), 
						String.format("%08d",Integer.valueOf(ffinefec)), 
						String.format("%04d",Integer.valueOf(choraini)), 
						String.format("%04d",Integer.valueOf(chorafin)), 
						String.format("%03d",Integer.valueOf(cemprvnt)), 
						String.format("%04d",Integer.valueOf(ccentvnt)), 
						String.format("%027d",Integer.valueOf(despromo)),
						String.format("%012d",Integer.valueOf(ccarpeta)), 
						String.format("%29d",Integer.valueOf(descarpe)), 
						String.format("%03d",Integer.valueOf(coorigen)), 
						String.format("%023d",Integer.valueOf(codplaex)), 
						String.format("%04d",Integer.valueOf(chordiad)), 
						String.format("%04d",Integer.valueOf(chordiah)), 
						String.format("%01d",Integer.valueOf(xtipobon)), 
						String.format("%01d",Integer.valueOf(xusopweb))
				));
	}

	@Test
	public void setsIdOnSave() {
		String codpromoci = "87654322";
		Promocion promo = repository.save(new Promocion(
				String.format("%03d",Integer.valueOf(cempresa)), 
				String.format("%04d",Integer.valueOf(centrooo)),
				String.format("%02d",Integer.valueOf(canlvnta)),
				String.format("%08d",Integer.valueOf(codpromoci)),
				String.format("%04d",Integer.valueOf(cdepartm)),
				String.format("%03d",Integer.valueOf(cfamilia)),
				String.format("%05d",Integer.valueOf(cbarraaa)),
				String.format("%03d",Integer.valueOf(ctallaec)),
				String.format("%03d",Integer.valueOf(dticprom)), 
				String.format("%02d",Integer.valueOf(cdivisio)), 
				String.format("%01d",Integer.valueOf(cniveln)), 
				String.format("%01d",Integer.valueOf(xexcluye)), 
				String.format("%05d",Integer.valueOf(cfabrica)), 
				String.format("%014d",Integer.valueOf(cmarmuma)), 
				String.format("%08d",Integer.valueOf(finiefec)), 
				String.format("%08d",Integer.valueOf(ffinefec)), 
				String.format("%04d",Integer.valueOf(choraini)), 
				String.format("%04d",Integer.valueOf(chorafin)), 
				String.format("%03d",Integer.valueOf(cemprvnt)), 
				String.format("%04d",Integer.valueOf(ccentvnt)), 
				String.format("%027d",Integer.valueOf(despromo)),
				String.format("%012d",Integer.valueOf(ccarpeta)), 
				String.format("%29d",Integer.valueOf(descarpe)), 
				String.format("%03d",Integer.valueOf(coorigen)), 
				String.format("%023d",Integer.valueOf(codplaex)), 
				String.format("%04d",Integer.valueOf(chordiad)), 
				String.format("%04d",Integer.valueOf(chordiah)), 
				String.format("%01d",Integer.valueOf(xtipobon)), 
				String.format("%01d",Integer.valueOf(xusopweb))
		));
		assertThat(promo.id).isNotNull();
	}

	@Test
	public void findsByEmpresa() {
		List<Promocion> result = repository.findByCempresa(cempresa);
		assertThat(result).extracting("centrooo").contains(centrooo);
	}

	// @Test
	// public void findsByExample() {
	//
	// Product probe = new Product("Silla Rower", null);
	//
	// List<Product> result = repository.findAll(Example.of(probe));
	//
	// assertThat(result).hasSize(2).extracting("description").contains("Silla de
	// comedor", "Silla de jardín");
	// }

	@Test
	public void checkSize() {
		List<Promocion> result = repository.findAll();
		System.out.println("Product repository size:" + result.size());
		assertThat(result).isNotNull();
	}
}