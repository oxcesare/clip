package mx.com.examen.clip.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"status","timeStamp","code","message"})
public class ResponseDisbursement {

	private String status;
	private String timeStamp;
	private String code;
	private String message;
	private List<ResponseDataDisbursement> lsResponseDataDisbursement;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ResponseDataDisbursement> getLsResponseDataDisbursement() {
		if(lsResponseDataDisbursement==null) {
			lsResponseDataDisbursement = new ArrayList<ResponseDataDisbursement>();
		}
		return lsResponseDataDisbursement;
	}

	public void setLsResponseDataDisbursement(List<ResponseDataDisbursement> lsResponseDataDisbursement) {
		this.lsResponseDataDisbursement = lsResponseDataDisbursement;
	}

}
