package mx.com.examen.clip.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.examen.clip.entity.Disbursement;
import mx.com.examen.clip.request.RequestTransaction;
import mx.com.examen.clip.response.ResponseAllTransactions;
import mx.com.examen.clip.response.ResponseDisbursement;
import mx.com.examen.clip.response.ResponseTransaction;
import mx.com.examen.clip.serviceImpl.DisbursementServiceImpl;
import mx.com.examen.clip.serviceImpl.TransactionServiceImpl;

@RestController
@RequestMapping("/clip")
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	
	@Autowired
	private DisbursementServiceImpl disbursementServiceImpl;
	
	
	@GetMapping("/info")
	public String hello() {
		return "Examen Clip -  23 Junio 2021 -  Version 1.0 " + "  " + "Autor: César Ricardo Alducin Ruiz";
	}

	@PostMapping("/makeTransaction")
	public ResponseEntity<ResponseTransaction> saveTransaction(@RequestBody RequestTransaction requestTransaction) {

		ResponseTransaction responseTransaction = new ResponseTransaction();

		try {
			responseTransaction = transactionServiceImpl.save(requestTransaction);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseTransaction);
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseTransaction);
	}

	@GetMapping("/transactions/{cliperUser}")
	public ResponseEntity<ResponseAllTransactions> getTransactionsByUser(@PathVariable("cliperUser") String clipUser) {

		ResponseAllTransactions lsTransaction = new ResponseAllTransactions();

		try {
			lsTransaction = transactionServiceImpl.allTransactionsFindByClipUser(clipUser);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lsTransaction);
		}

		return ResponseEntity.status(HttpStatus.OK).body(lsTransaction);

	}

	@GetMapping("/makeDisbursement")
	public ResponseEntity<ResponseDisbursement> makeDisbursement() {

		ResponseDisbursement responseDisbursement = new ResponseDisbursement();
		
		try {
			responseDisbursement = transactionServiceImpl.makeDisbursement();			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDisbursement);
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseDisbursement);

	}
	
	@GetMapping("/getDisbursement")
	public ResponseEntity<List<Disbursement>> getDisbursement() {

		List<Disbursement> lsDisbursements = new ArrayList<Disbursement>();

		try {
			lsDisbursements = disbursementServiceImpl.getAllDisbursements();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lsDisbursements);
		}

		return ResponseEntity.status(HttpStatus.OK).body(lsDisbursements);

	}


}
