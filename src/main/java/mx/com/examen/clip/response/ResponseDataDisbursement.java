package mx.com.examen.clip.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"disbursement","amount","cliperUser"})
public class ResponseDataDisbursement {

	
	private String disbursement;
	private BigDecimal amount;
	private String cliperUser;
	
	
	
	public String getDisbursement() {
		return disbursement;
	}
	
	public void setDisbursement(String disbursement) {
		this.disbursement = disbursement;
	}
	
	private List<String> lsTransactions;

	public List<String> getLsTransactions() {
		return lsTransactions;
	}

	public void setLsTransactions(List<String> lsTransactions) {
		this.lsTransactions = lsTransactions;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCliperUser() {
		return cliperUser;
	}

	public void setCliperUser(String cliperUser) {
		this.cliperUser = cliperUser;
	}

}
