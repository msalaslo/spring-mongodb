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
        int numCentros = start + 10; 
        int numDepartamentos = start + 2; 
        int numDivisiones = start + 2;
        int numFamilias = start + 5;
        int numBarras = start + 5;
        int numTallas = start + 5;
        int numNiveles = start + 5;
        int numMarcas = start + 2;
        int numFabricantes = start + 2;
        int numPromociones = start + 2;
        
        String canlvnta = "CN";
        String codpromoci = "CODPROM";
        String dticprom = "TP";
        String xexcluye = "E";
		String finiefec =  "20170101";
		String ffinefec =  "20180101";
		String choraini =  "0800";
		String chorafin =  "0000";
		String cemprvnt =  "001";
		String ccentvnt =  "0001";
		String despromo =  "Descripcion promocion";
		String ccarpeta =  "01234567890123";
		String descarpe =  "Descripcion carpeta";
		String coorigen =  "123";
		String codplaex =  "123456789012345678901234";
		String chordiad =  "123";
		String chordiah =  "456";
		String xtipobon =  "B";
		String xusopweb =  "W";
		
        int total = numEmpresas * numCentros * numDepartamentos * numDivisiones * numFamilias * numBarras * numTallas * numPromociones;
        logger.debug("Total registros a cargar:" + total);
        for (int cempresa = start; cempresa < numEmpresas; cempresa++) {
        	String cempresaStr = String.format("%03d",Integer.valueOf(cempresa));
        	for (int centrooo = start; centrooo < numCentros; centrooo++) {
        		String centrooStr = String.format("%04d",Integer.valueOf(centrooo));
        		for (int cdivisio = start; cdivisio < numDivisiones; cdivisio++) {
        			String cdivisioStr = String.format("%02d",Integer.valueOf(cdivisio));
        			for (int cdepartm = start; cdepartm < numDepartamentos; cdepartm++) {
        				String cdepartmStr = String.format("%04d",Integer.valueOf(cdepartm));
		        		for (int cfamilia = start; cfamilia < numFamilias; cfamilia++) {
		        			String cfamiliaStr = String.format("%03d",Integer.valueOf(cfamilia));
							for (int cbarraaa = start; cbarraaa < numBarras; cbarraaa++) {
								String cbarraaaStr = String.format("%05d",Integer.valueOf(cbarraaa));
								for (int ctallaec = start; ctallaec < numTallas; ctallaec++) {
									String ctallaecStr = String.format("%03d",Integer.valueOf(ctallaec));
									for(int codPromocion = start; codPromocion < numPromociones; codPromocion++){
										for(int cniveln = start; cniveln < numNiveles; cniveln++){
											String cnivelnStr = String.format("%01d",Integer.valueOf(cniveln));
											for(int cmarmuma = start; cmarmuma < numMarcas; cmarmuma++){
												String cmarmumaStr = String.format("%014d",Integer.valueOf(cmarmuma));
												for(int cfabrica = start; cfabrica < numFabricantes; cfabrica++){
													String cfabricaStr = String.format("%05d",Integer.valueOf(cfabrica));
													Promocion promocion = new Promocion(
															cempresaStr, 
															centrooStr,
															canlvnta,
															codpromoci,
															cdepartmStr,
															cfamiliaStr,
															cbarraaaStr,
															ctallaecStr,
															dticprom, 
															cdivisioStr, 
															cnivelnStr, 
															xexcluye, 
															cfabricaStr, 
															cmarmumaStr, 
															finiefec, 
															ffinefec, 
															choraini, 
															chorafin, 
															cemprvnt, 
															ccentvnt, 
															despromo,
															ccarpeta, 
															descarpe, 
															coorigen, 
															codplaex, 
															chordiad, 
															chordiah, 
															xtipobon, 
															xusopweb 
															);
													promociones.add(promocion);
												}
											}
										}
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