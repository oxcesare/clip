package mx.com.examen.clip.response;

import java.util.ArrayList;
import java.util.List;


import mx.com.examen.clip.entity.Transaction;

public class ResponseAllTransactions {

	private List<Transaction> lsTransactions;

	public List<Transaction> getLsTransactions() {

		if (lsTransactions == null) {
			lsTransactions = new ArrayList<Transaction>();
		}
		return lsTransactions;
	}

	public void setLsTransactions(List<Transaction> lsTransactions) {
		this.lsTransactions = lsTransactions;
	}

}
