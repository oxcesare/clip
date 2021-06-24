package mx.com.examen.clip.service;

import mx.com.examen.clip.request.RequestTransaction;
import mx.com.examen.clip.response.ResponseAllTransactions;
import mx.com.examen.clip.response.ResponseDisbursement;
import mx.com.examen.clip.response.ResponseTransaction;

public interface TransactionService {
	
	public ResponseTransaction save (RequestTransaction requestTransaction);
	
	public ResponseAllTransactions allTransactionsFindByClipUser(String user);
	
	public ResponseDisbursement makeDisbursement();

}
