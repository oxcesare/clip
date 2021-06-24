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
	
	
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClipApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		RequestTransaction requestTransaction = new  RequestTransaction();
		requestTransaction.setAmount(new BigDecimal("10000000.00"));
		requestTransaction.setCardData("5534677899000099");
		requestTransaction.setClipUser("César Ricardo Alducin Ruiz");
		requestTransaction.setStatus(1);
		
		
		String json = Utilerias.convertToJson(requestTransaction);
		
		logger.info(json);
		
		ResponseDisbursement responseDisbursement = new ResponseDisbursement();
		
		responseDisbursement = transactionServiceImpl.makeDisbursement();
		
		System.out.println(responseDisbursement.getMessage());
		
		
		
	}

}
