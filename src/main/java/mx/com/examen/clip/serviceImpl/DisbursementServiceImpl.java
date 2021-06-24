package mx.com.examen.clip.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.examen.clip.entity.Disbursement;
import mx.com.examen.clip.repository.DisbursementDAO;
import mx.com.examen.clip.service.DisbursementService;

@Service
public class DisbursementServiceImpl implements DisbursementService {

	private static final Logger logger = LoggerFactory.getLogger(DisbursementServiceImpl.class);
	
	@Autowired
	private DisbursementDAO disbursementDAO;
	
	
	@Override
	public void save(Disbursement disbursement) {		
		try {
			disbursementDAO.save(disbursement);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	@Override
	public List<Disbursement> getAllDisbursements() {
		
		List<Disbursement> lsDisbursements = new ArrayList<Disbursement>();
		
		try {
			lsDisbursements = (List<Disbursement>) disbursementDAO.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return lsDisbursements;
	}

}
