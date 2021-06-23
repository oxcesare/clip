package mx.com.examen.clip.request;

import java.math.BigDecimal;

public class RequestTransaction {

	private BigDecimal amount;
	private String clipUser;
	private String cardData;
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

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCardData() {
		return cardData;
	}
	
	public void setCardData(String cardData) {
		this.cardData = cardData;
	}

}
