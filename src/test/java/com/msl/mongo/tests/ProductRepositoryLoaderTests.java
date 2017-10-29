package com.msl.mongo.tests;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.msl.mongo.domain.product.Product;
import com.msl.mongo.domain.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryLoaderTests {

    @Autowired
    ProductRepository repository;

    @Before
    public void setUp() {
        
    }
    
    @Test
    public void deleteAll() {
    	repository.deleteAll();
        List<Product> result = repository.findAll();
        assertThat(result).hasSize(0);
    }
    
    @Test
    public void load() {
        repository.save(loadProducts(0));
        List<Product> result = repository.findByDescription("DESC1");
        assertThat(result).hasSize(1).extracting("name").contains("NAME00000");
    }
    
//    @Test
    public List<Product> loadProducts(int start){
    	List<Product> products = new ArrayList<Product>();
        int numEmpresas = start + 14;
//        int numCentros = start + 500;
//        int numFamilias = start + 50;
        int numCentros = start + 500;
        int numFamilias = start + 50;
        int numBarras = start + 1;
        int numTallas = start + 1;
        for (int empresa = start; empresa < numEmpresas; empresa++) {
        	for (int centro = start; centro < numCentros; centro++) {
        		for (int familia = start; familia < numFamilias; familia++) {
					for (int barra = start; barra < numBarras; barra++) {
						for (int talla = start; talla < numTallas; talla++) {
							String ref = "" + empresa + centro + familia + barra + talla;
							Product product = new Product("NAME" + ref , "DESC" + ref, "EMP" + empresa, "CENT" + centro, "FAM" + familia, "BAR" + barra, "TAL" + talla);
							products.add(product);
						}
					}
				}
			}
        	System.out.println("Centros cargados:" + numCentros);
		}
        System.out.println("Empresa cargadas:" + numEmpresas);
        return products;
    }
    
    public void writeToFile() {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Product> products = loadProducts(0);
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
    	List<Product> products = loadProducts(startIndex);
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
    
    @Test
    public void findsByDescription() {

        List<Product> result = repository.findByDescription("DESC00000");

        assertThat(result).hasSize(1).extracting("name").contains("NAME00000");
    }
}