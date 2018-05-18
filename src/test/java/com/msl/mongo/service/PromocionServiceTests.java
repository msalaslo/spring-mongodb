package com.msl.mongo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.promocion.Promocion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocionServiceTests {
	
	Logger logger = LoggerFactory.getLogger(PromocionServiceTests.class);

    @Autowired
    PromocionService service;
	
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
	
	public static String padLeftZeros(String str, int n) {
	    return String.format("%1$" + n + "s", str).replace(' ', '0');
	  }
	
	@Before
	public void setUp() {

		// repository.deleteAll();
		String codpromoci = "97654321";
		service.save(new Promocion(
						String.format("%03d",Integer.valueOf(cempresa)), 
						String.format("%04d",Integer.valueOf(centrooo)),
						padLeftZeros(canlvnta, 2),
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
						padLeftZeros(cmarmuma, 14),
						String.format("%08d",Integer.valueOf(finiefec)), 
						String.format("%08d",Integer.valueOf(ffinefec)), 
						String.format("%04d",Integer.valueOf(choraini)), 
						String.format("%04d",Integer.valueOf(chorafin)), 
						String.format("%03d",Integer.valueOf(cemprvnt)), 
						String.format("%04d",Integer.valueOf(ccentvnt)), 
						padLeftZeros(cmarmuma, 27),
						padLeftZeros(ccarpeta, 12),
						padLeftZeros(descarpe, 29),
						String.format("%03d",Integer.valueOf(coorigen)), 
						padLeftZeros(codplaex, 23),
						String.format("%04d",Integer.valueOf(chordiad)), 
						String.format("%04d",Integer.valueOf(chordiah)), 
						padLeftZeros(xtipobon, 1),
						padLeftZeros(xusopweb, 1)
				));
	}

	@Test
	public void findsByEmpresa() {
		List<Promocion> result = service.findByEmpresa(cempresa);
		assertThat(result).extracting("centrooo").contains(centrooo);
	}

}
