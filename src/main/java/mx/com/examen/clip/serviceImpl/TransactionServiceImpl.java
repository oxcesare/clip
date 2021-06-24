package mx.com.examen.clip.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.examen.clip.entity.Disbursement;
import mx.com.examen.clip.entity.Transaction;
import mx.com.examen.clip.repository.TransactionDAO;
import mx.com.examen.clip.request.RequestTransaction;
import mx.com.examen.clip.response.ResponseAllTransactions;
import mx.com.examen.clip.response.ResponseDataDisbursement;
import mx.com.examen.clip.response.ResponseDisbursement;
import mx.com.examen.clip.response.ResponseTransaction;
import mx.com.examen.clip.service.TransactionService;
import mx.com.examen.clip.utilerias.Utilerias;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private DisbursementServiceImpl disbursementServiceImpl;

	
	@Override
	public ResponseTransaction save(RequestTransaction requestTransaction) {

		ResponseTransaction response = new ResponseTransaction();

		Transaction transaction = new Transaction();
		transaction.setAmount(requestTransaction.getAmount());
		transaction.setCardData(requestTransaction.getCardData());
		transaction.setClipUser(requestTransaction.getClipUser());
		transaction.setDate(Utilerias.formatFechaTransaccion(new Date()));
		transaction.setStatus(1);

		try {
			transactionDAO.save(transaction);
			response.setCode("100");
			response.setMessage("Successful transaction");
			response.setStatus("0");
			response.setTimeStamp(Utilerias.getTimeStamp(Utilerias.FECHATIMESTAMP));
		} catch (Exception e) {
			response.setCode("-300");
			response.setMessage(e.getMessage());
			response.setStatus("-1");
			response.setTimeStamp(Utilerias.getTimeStamp(Utilerias.FECHATIMESTAMP));
		}

		return response;
	}

	@Override
	public ResponseAllTransactions allTransactionsFindByClipUser(String clipUser) {

		ResponseAllTransactions lsResponse = new ResponseAllTransactions();

		try {
			List<Transaction> lsTransactions = transactionDAO.findByClipUser(clipUser);
			lsResponse.setLsTransactions(lsTransactions);

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return lsResponse;
	}

	@Override
	public ResponseDisbursement makeDisbursement() {
		// TODO Auto-generated method stub

		List<Transaction> lsTransactions                          = new ArrayList<Transaction>();
		
		ResponseDisbursement responseDisbursement                 = new ResponseDisbursement();
		Set<String> users                                         = new TreeSet<>();
		BigDecimal amount                                         = BigDecimal.ZERO;
		List<String> totalTransactions                            = null;		
		ResponseDataDisbursement respData                         = null;
		List<ResponseDataDisbursement> lsResponseDataDisbursement = new ArrayList<>();
		int i													  = 0;
		
		

		try {
			lsTransactions = transactionDAO.transactionsByClipUser();
			
			/** Agregar a un Set los Users**/			
			if (lsTransactions.size() > 0) {
				for (Transaction user : lsTransactions) {
					users.add(user.getClipUser());
				}
				
				responseDisbursement.setCode("100");			
				responseDisbursement.setMessage("Successful");
				responseDisbursement.setStatus("0");
				responseDisbursement.setTimeStamp(Utilerias.getTimeStamp(Utilerias.FECHATIMESTAMP));
				
			}
			else {
				responseDisbursement.setCode("300");			
				responseDisbursement.setMessage("Not Record");
				responseDisbursement.setStatus("-1");
				responseDisbursement.setTimeStamp(Utilerias.getTimeStamp(Utilerias.FECHATIMESTAMP));
			}
			
			for (String userSet : users) {
				
				respData                    = new ResponseDataDisbursement();
				totalTransactions           = new ArrayList<>();
				amount					    = BigDecimal.ZERO;
				
				i++;
				
				respData.setCliperUser(userSet);
				respData.setDisbursement("disbursement".concat(String.valueOf(i)));
				
				
				for (Transaction transaction : lsTransactions) {					
					if(userSet.equals(transaction.getClipUser())) {
						amount = amount.add(transaction.getAmount());
					}
				}
				respData.setAmount(amount);
				
				
				for (Transaction transaction : lsTransactions) {
					
					if(userSet.equals(transaction.getClipUser())) {
						totalTransactions.add("Transaction".concat(String.valueOf(transaction.getIdTransaction())));
					}
				}
				
				respData.setLsTransactions(totalTransactions);
				lsResponseDataDisbursement.add(respData);
				
				
				
			}
			
			responseDisbursement.setLsResponseDataDisbursement(lsResponseDataDisbursement);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		/**
		 * 
		 */
		
		
		saveDisbursement();
		updateTransactionStatus();

		return responseDisbursement;
	}

	
	
	
	public void saveDisbursement() {
		 
		List<Transaction> lsTransactionsUp     = new ArrayList<Transaction>();
		
		/**
		 * Actualizar todas las transacciones con estatus 1 a estatus 0 
		 * para no ser consideradas en el próximo desembolso.
		 */
		
		try {
			
			Disbursement disbursement   = null;
			int i 					    = 0;
			
			lsTransactionsUp = transactionDAO.transactionsByClipUserSave();
			
			for (Transaction responseDataDisbursement : lsTransactionsUp) {
				
				disbursement = new Disbursement();
				i++;
				disbursement.setDisbursement("transaction".concat(String.valueOf(i)));
				disbursement.setClipUser(responseDataDisbursement.getClipUser());
				disbursement.setAmount(responseDataDisbursement.getAmount());
				disbursement.setDate(Utilerias.formatFechaTransaccion(new Date()));
				disbursementServiceImpl.save(disbursement);
				
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
	}
	
	
	
	public void updateTransactionStatus() {
		 
		List<Transaction> lsTransactionsUp     = new ArrayList<Transaction>();
		
		/**
		 * Actualizar todas las transacciones con estatus 1 a estatus 0 
		 * para no ser consideradas en el próximo desembolso.
		 */
		
		try {
			
			Transaction transactionDisbursement   = null;
			
			lsTransactionsUp = transactionDAO.transactionsByClipUserUpdate();
			
			for (Transaction responseDataDisbursement : lsTransactionsUp) {
				
				transactionDisbursement = new Transaction();
				transactionDisbursement.setIdTransaction(responseDataDisbursement.getIdTransaction());
				transactionDisbursement.setAmount(responseDataDisbursement.getAmount());
				transactionDisbursement.setCardData(responseDataDisbursement.getCardData());
				transactionDisbursement.setClipUser(responseDataDisbursement.getClipUser());
				transactionDisbursement.setDate(responseDataDisbursement.getDate());
				transactionDisbursement.setStatus(0);
				transactionDAO.save(transactionDisbursement);
				
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
	}
	
	
	
}
