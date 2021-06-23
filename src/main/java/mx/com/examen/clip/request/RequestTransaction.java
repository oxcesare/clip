package mx.com.examen.clip.request;

import java.math.BigDecimal;
import java.util.Date;

public class RequestTransaction {

	private BigDecimal amount;
	private String clipUser;
	private Integer cardData;
	private Date date;
	private Integer status;


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
		return "RequestTransaction [amount=" + amount + ", clipUser=" + clipUser + ", cardData=" + cardData + ", date="
				+ date + ", status=" + status + "]";
	}

}
