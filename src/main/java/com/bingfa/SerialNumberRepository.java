package com.bingfa;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

 




public interface SerialNumberRepository extends JpaRepository<SerialNumber, Long>,JpaSpecificationExecutor<SerialNumber> {

	/**
	 * 
	 * <p>Title:findByDateAndStatus</p>
	 * <p>Description: </p>
	 *  @param date
	 *  @param status
	 *  @return
	 */
	SerialNumber findByDateAndStatus(String date, String status);
	
}
