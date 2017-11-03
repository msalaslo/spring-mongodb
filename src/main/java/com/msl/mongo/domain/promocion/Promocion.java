
package com.msl.mongo.domain.promocion;

import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "promocion")
public class Promocion {

	@Id
    public String id;
	
	public String referencia;
     
	//123 desde 1 a 3
    public String cempresa;
    
    //1234 desde 4 a 7
    public String centrooo;
    
    //12 desde 8 a 9
    public String canlvnta;
    
    //123..7 desde 10 a 17
    public String codpromoci;
    
    //1234 desde 18 a 21
    public String cdepartm;
    
    //123 desde 22 a 24
    public String cfamilia;
    
    //12345 desde 25 a 29
    public String cbarraaa;
    
    //123 desde 30 a 32
    public String ctallaec;
    
    //123 desde 33 a 34
    public String dticprom;
    
    //12 desde 35 a 36
    public String cdivisio;
    
    //1 desde 37 a 37
    public String cniveln;
    
    //1 desde 38 a 38
    public String xexcluye;
    
    //123456 desde 39 a 45
    public String cfabrica;
    
    //123..14 desde 46 a 60
    public String cmarmuma;
    
    //123...7 desde 61 a 68
    public String finiefec;
    
    //123...7 desde 69 a 76
    public String ffinefec;
    
    //1234 desde 77 a 80
    public String choraini;
    
    //1234 desde 77 a 80
    public String chorafin;
    
    //12 desde 85 a 87
    public String cemprvnt;
    
    //123 desde 88 a 91
    public String ccentvnt;
    
    //123..29 desde 92 a 111
    public String despromo;
    
    //123..12 desde 112 a 124
    public String ccarpeta;

    //123..49 desde 125 a 174
    public String descarpe;
    
    //123 desde 175 a 177
    public String coorigen;
    
    //123..23 desde 178 a 201
    public String codplaex;
    
    //123 desde 202 a 205
    public String chordiad;
    
    //123 desde 206 a 209
    public String chordiah;
    
    //1 desde 210 a 210
    public String xtipobon;
    
    //1 desde 211 a 211
    public String xusopweb;

    public Promocion() {}
    
    public Promocion(
    	    String cempresa,
    	    String centrooo,
    	    String canlvnta,
    	    String codpromoci,
    	    String cdepartm,
    	    String cfamilia,
    	    String cbarraaa,
    	    String ctallaec,
    	    String dticprom,
    	    String cdivisio,
    	    String cniveln,
    	    String xexcluye,
    	    String cfabrica,
    	    String cmarmuma,
    	    String finiefec,
    	    String ffinefec,
    	    String choraini,
    	    String chorafin,
    	    String cemprvnt,
    	    String ccentvnt,
    	    String despromo,
    	    String ccarpeta,
    	    String descarpe,
    	    String coorigen,
    	    String codplaex,
    	    String chordiad,
    	    String chordiah,
    	    String xtipobon,
    	    String xusopweb) {
        super();
        this.id = UUID.randomUUID().toString();
        this.referencia = cempresa + centrooo + cdepartm + cfamilia + cbarraaa + ctallaec + cdivisio + cniveln + cfabrica + cmarmuma;
	    this.cempresa = cempresa;
	    this.centrooo = centrooo;
	    this.canlvnta = canlvnta;
	    this.codpromoci = codpromoci;
	    this.cdepartm = cdepartm;
	    this.cfamilia = cfamilia;
	    this.cbarraaa = cbarraaa;
	    this.ctallaec = ctallaec;
	    this.dticprom = dticprom;
	    this.cdivisio = cdivisio;
	    this.cniveln = cniveln;
	    this.xexcluye = xexcluye;
	    this.cfabrica = cfabrica;
	    this.cmarmuma = cmarmuma;
	    this.finiefec = finiefec;
	    this.ffinefec = ffinefec;
	    this.choraini = choraini;
	    this.chorafin = chorafin;
	    this.cemprvnt = cemprvnt;
	    this.ccentvnt = ccentvnt;
	    this.despromo = despromo;
	    this.ccarpeta = ccarpeta;
	    this.descarpe = descarpe;
	    this.coorigen = coorigen;
	    this.codplaex = codplaex;
	    this.chordiad = chordiad;
	    this.chordiah = chordiah;
	    this.xtipobon = xtipobon;
	    this.xusopweb = xusopweb;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("id", id).
                append("referencia", referencia).
        	    append("cempresa", cempresa).
        	    append("centrooo", centrooo).
        	    append("canlvnta", canlvnta).
        	    append("codpromoci", codpromoci).
        	    append("cdepartm", cdepartm).
        	    append("cfamilia", cfamilia).
        	    append("cbarraaa", cbarraaa).
        	    append("ctallaec", ctallaec).
        	    append("dticprom", dticprom).
        	    append("cdivisio", cdivisio).
        	    append("cniveln", cniveln).
        	    append("xexcluye", xexcluye).
        	    append("cfabrica", cfabrica).
        	    append("cmarmuma", cmarmuma).
        	    append("finiefec", finiefec).
        	    append("ffinefec", ffinefec).
        	    append("choraini", choraini).
        	    append("chorafin", chorafin).
        	    append("cemprvnt", cemprvnt).
        	    append("ccentvnt", ccentvnt).
        	    append("despromo", despromo).
        	    append("ccarpeta", ccarpeta).
        	    append("descarpe", descarpe).
        	    append("coorigen", coorigen).
        	    append("codplaex", codplaex).
        	    append("chordiad", chordiad).
        	    append("chordiah", chordiah).
        	    append("xtipobon", xtipobon).
        	    append("xusopweb", xusopweb).
        		toString();
    }

}
