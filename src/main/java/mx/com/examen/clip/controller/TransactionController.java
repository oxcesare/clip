package mx.com.examen.clip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.examen.clip.request.RequestTransaction;
import mx.com.examen.clip.response.ResponseTransaction;
import mx.com.examen.clip.serviceImpl.TransactionServiceImpl;

@RestController
@RequestMapping("/clip")
public class TransactionController {

	
	
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	
	
	@GetMapping("/info")
	public String hello() {
		return "Examen Clip -  23 Junio 2021" +  "  " +  "Autor: César Ricardo Alducin Ruiz";
	}
	
	
	
	@PostMapping("/makeTransaction")
	public ResponseEntity<ResponseTransaction> saveTransaction (@RequestBody RequestTransaction requestTransaction) {
		
		ResponseTransaction responseTransaction = new ResponseTransaction();
		
		try {
			responseTransaction = transactionServiceImpl.save(requestTransaction);
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseTransaction);			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseTransaction);
		
		
	}

}
