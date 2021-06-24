package mx.com.examen.clip.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.examen.clip.entity.Disbursement;

@Transactional
@Repository
public interface DisbursementDAO extends CrudRepository<Disbursement, Integer> {
	

}
