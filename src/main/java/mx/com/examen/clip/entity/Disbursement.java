package mx.com.examen.clip.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disbursement")
public class Disbursement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDisbursement;

	private String      disbursement;
	private BigDecimal  amount;
	private String      clipUser;
	private String      date;

	public Integer getIdDisbursement() {
		return idDisbursement;
	}

	public void setIdDisbursement(Integer idDisbursement) {
		this.idDisbursement = idDisbursement;
	}

	public String getDisbursement() {
		return disbursement;
	}

	public void setDisbursement(String disbursement) {
		this.disbursement = disbursement;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getClipUser() {
		return clipUser;
	}

	public void setClipUser(String clipUser) {
		this.clipUser = clipUser;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
