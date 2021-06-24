package mx.com.examen.clip.repository;

import javax.transaction.Transactional;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.examen.clip.entity.Transaction;


@Transactional
@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
	
	List<Transaction> findByClipUser(String clipUser);
	
	
	@Query("SELECT u FROM Transaction u Where u.status=1 order by u.clipUser")
	List<Transaction> transactionsByClipUser();
	
	@Query("SELECT u FROM Transaction u Where u.status=1 order by u.clipUser")
	List<Transaction> transactionsByClipUserUpdate();

	
	@Query("SELECT u FROM Transaction u Where u.status=1 order by u.clipUser")
	List<Transaction> transactionsByClipUserSave();

	

	
	
}
