package mx.com.examen.clip;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import mx.com.examen.clip.request.RequestTransaction;
import mx.com.examen.clip.response.ResponseDisbursement;
import mx.com.examen.clip.serviceImpl.TransactionServiceImpl;
import mx.com.examen.clip.utilerias.Utilerias;

@SpringBootApplication
public class ClipApplication implements CommandLineRunner{
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClipApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("INICIANDO EXAMEN - CLIP");
		
	}

	

}
