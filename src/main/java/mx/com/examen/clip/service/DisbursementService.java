package mx.com.examen.clip.service;

import java.util.List;

import mx.com.examen.clip.entity.Disbursement;

public interface DisbursementService {
	
	
	public void save (Disbursement disbursement);

	public List<Disbursement> getAllDisbursements(); 	
	
}
