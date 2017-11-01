package com.msl.mongo.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.domain.promocion.PromocionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocionRepositoryLoaderTests {

    @Autowired
    PromocionRepository repository;

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
    
//    @Test
    public List<Promocion> loadProducts(int start){
    	List<Promocion> promociones = new ArrayList<Promocion>();
        int numEmpresas = start + 14;
        int numCentros = start + 500; 
        int numDepartamentos = start + 1; 
        int numDivisiones = start + 1;
        int numFamilias = start + 50;
        int numBarras = start + 1;
        int numTallas = start + 1;
        int numPromociones = start + 1;
        for (int empresa = start; empresa < numEmpresas; empresa++) {
        	for (int centro = start; centro < numCentros; centro++) {
        		for (int division = start; division < numDivisiones; division++) {
        			for (int departamento = start; departamento < numDepartamentos; departamento++) {
		        		for (int familia = start; familia < numFamilias; familia++) {
							for (int barra = start; barra < numBarras; barra++) {
								for (int talla = start; talla < numTallas; talla++) {
									String ref = "" + empresa + centro + familia + barra + talla;
									for(int codPromocion = start; codPromocion < numPromociones; codPromocion++){
										Promocion promocion = new Promocion(empresa + "", centro + "", departamento + "", division + "", familia + "", barra + "", talla+ "", codPromocion+ "", ref);
										promociones.add(promocion);
									}
								}
							}
						}
        			}
        		}
			}
        	System.out.println("Centros cargados:" + numCentros);
		}
        System.out.println("Empresa cargadas:" + numEmpresas);
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