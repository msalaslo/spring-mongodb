package com.msl.mongo.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.domain.promocion.PromocionRepository;
import com.msl.mongo.domain.promocion.PromocionRepositoryCustomImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocionRepositoryLoaderTests {
	
	Logger logger = LoggerFactory.getLogger(PromocionRepositoryLoaderTests.class);

    @Autowired
    PromocionRepository repository;
    
    @Autowired
    PromocionRepositoryCustomImpl customRepository;

    @Before
    public void setUp() {
        
    }
    
//    @Test
//    public void deleteAll() {
//    	repository.deleteAll();
//        List<Promocion> result = repository.findAll();
//        assertThat(result).hasSize(0);
//    }
    
    @Test
    public void load() {
        repository.save(loadProducts(0));
    }
    
    @Test
    public void writeBulk() {
    	logger.debug("writeBulk antes");
    	CompletableFuture<Integer> numRegistros = customRepository.save(loadProducts(0));
    	logger.debug("writeBulk despues, registros insertados:" + numRegistros);
    }
    
    @Async
    public List<Promocion> loadProducts(int start){
    	List<Promocion> promociones = new ArrayList<Promocion>();
        int numEmpresas = start + 10;
        int numCentros = start + 100; 
        int numDepartamentos = start + 2; 
        int numDivisiones = start + 2;
        int numFamilias = start + 5;
        int numBarras = start + 5;
        int numTallas = start + 5;
        int numPromociones = start + 2;
        int total = numEmpresas * numCentros * numDepartamentos * numDivisiones * numFamilias * numBarras * numTallas * numPromociones;
        logger.debug("Total registros a cargar:" + total);
        for (int empresa = start; empresa < numEmpresas; empresa++) {
        	for (int centro = start; centro < numCentros; centro++) {
        		for (int division = start; division < numDivisiones; division++) {
        			for (int departamento = start; departamento < numDepartamentos; departamento++) {
		        		for (int familia = start; familia < numFamilias; familia++) {
							for (int barra = start; barra < numBarras; barra++) {
								for (int talla = start; talla < numTallas; talla++) {
									String resto = String.format("%027d",Integer.valueOf(empresa + centro + familia + barra + talla));
									for(int codPromocion = start; codPromocion < numPromociones; codPromocion++){
										Promocion promocion = new Promocion(
												String.format("%03d",Integer.valueOf(empresa)), 
												String.format("%04d",Integer.valueOf(centro)), 
												String.format("%02d",Integer.valueOf(division)), 
												String.format("%04d",Integer.valueOf(departamento)), 
												String.format("%03d",Integer.valueOf(familia)), 
												String.format("%05d",Integer.valueOf(barra)), 
												String.format("%03d",Integer.valueOf(talla)), 
												String.format("%08d",Integer.valueOf(codPromocion)), 
												resto);
										promociones.add(promocion);
									}
								}
							}
						}
        			}
        		}
			}
        	logger.debug("Centros cargados:" + numCentros);
		}
        logger.debug("Empresa cargadas:" + numEmpresas);
        return promociones;
    }
    
    public void writeToFile() {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Promocion> products = loadProducts(0);
    	//Object to JSON in file
    	try {
    		File file = new File("C:\\temp\\file.json");
			mapper.writeValue(file, products);	
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void createProductsImportsFiles() {
    	int numFiles = 10;
    	for (int i = 0; i < numFiles; i++) {
			writeToFileReplacingChars(350000 * i);
		}
    }
    
    public void writeToFileReplacingChars(int startIndex) {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Promocion> products = loadProducts(startIndex);
    	FileWriter fw = null;
    	BufferedWriter bw = null;
    	BufferedReader br = null;
    	try {
    		final Pattern PATTERN1 = Pattern.compile("[", Pattern.LITERAL);
    		final Pattern PATTERN2 = Pattern.compile("]", Pattern.LITERAL);
    		final Pattern PATTERN3 = Pattern.compile("},", Pattern.LITERAL);
    		File file = new File("C:\\temp\\file-ori.json");
			mapper.writeValue(file, products);

			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String newContent = "";
			while (line != null) 
			{
					newContent = PATTERN1.matcher(line).replaceAll("");
					newContent = PATTERN2.matcher(newContent).replaceAll("");
					newContent = PATTERN3.matcher(newContent).replaceAll("}");
					newContent = newContent + System.lineSeparator();
			        line = br.readLine();
			}
			File replaced = new File("C:\\temp\\file-replaced" + startIndex + ".json");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(replaced, true);
			bw = new BufferedWriter(fw);
			bw.write(newContent);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			}catch (IOException ex) {

				ex.printStackTrace();

			}
		}
    }

}