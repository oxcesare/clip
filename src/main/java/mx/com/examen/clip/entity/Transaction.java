package mx.com.examen.clip.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaction;

	private BigDecimal amount;
	private String clipUser;
	private Integer cardData;
	private Date date;
	private Integer status;

	public Integer getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
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

	public Integer getCardData() {
		return cardData;
	}

	public void setCardData(Integer cardData) {
		this.cardData = cardData;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [idTransaction=" + idTransaction + ", amount=" + amount + ", clipUser=" + clipUser
				+ ", cardData=" + cardData + ", date=" + date + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((cardData == null) ? 0 : cardData.hashCode());
		result = prime * result + ((clipUser == null) ? 0 : clipUser.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idTransaction == null) ? 0 : idTransaction.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (cardData == null) {
			if (other.cardData != null)
				return false;
		} else if (!cardData.equals(other.cardData))
			return false;
		if (clipUser == null) {
			if (other.clipUser != null)
				return false;
		} else if (!clipUser.equals(other.clipUser))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idTransaction == null) {
			if (other.idTransaction != null)
				return false;
		} else if (!idTransaction.equals(other.idTransaction))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
