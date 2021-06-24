package mx.com.examen.clip.response;

public class ResponseTransaction {
	
	
	private String status;
	private String timeStamp;
	private String code;
	private String message;
	
	
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
	
	@Override
	public String toString() {
		return "ResponseTransaction [status=" + status + ", timeStamp=" + timeStamp + ", code=" + code + ", message="
				+ message + "]";
	}
}
