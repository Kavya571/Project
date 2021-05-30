package com.cg.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.exceptions.ValidateCoupanException;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.dto.Coupan;

@Service
public class ICoupanService {
    @Autowired
    ICoupanRepository ICoupanRepository;
 
	public Coupan addCoupans(Coupan coupan)throws ValidateCoupanException{
		    validateCoupan(coupan);
		    return ICoupanRepository.save(coupan);
			
	};

	public Coupan editCoupans(Coupan coupan)throws InvalidCoupanOperationException{
		try {
			if(ICoupanRepository.existsById(coupan.getCoupanId())) {
			return ICoupanRepository.save(coupan);
			}else {
				throw new InvalidCoupanOperationException();
			}
		}catch(Exception e) {
			throw new InvalidCoupanOperationException("Operation is not valid");
		}
	}
	
	public boolean validateCoupan(Coupan coupan) throws ValidateCoupanException {
		if (!coupan.getCoupanName().matches("[A-Za-z0-9]+")) {
			throw new ValidateCoupanException(OnlinePizzaConstants.COUPAN_CANNOT_BE_EMPTY);
		}
		if (!coupan.getCoupanType().matches("[A-Za-z0-9]+"))
			throw new ValidateCoupanException(OnlinePizzaConstants.COUPAN_CANNOT_BE_EMPTY);
		
		if (!coupan.getCoupanDescription().matches("[A-Za-z]+[\s][0-9]+[\s][%][a-zA-Z\s]+"))
			throw new ValidateCoupanException(OnlinePizzaConstants.DESCRIPTION_FORMAT_NOT_MATCHED);
		String coupanPizzaIdString = Integer.toString(coupan.getCoupanPizzaId());
		if (!(coupanPizzaIdString.matches("[0-9]+")))
			throw new ValidateCoupanException(OnlinePizzaConstants.COUPANPIZZAID_FORMAT);

		return true;
	}

	public int deleteCoupans(int coupanId)throws CoupanIdNotFoundException{
		try {
		ICoupanRepository.deleteById(coupanId);
		return coupanId;
		}catch(Exception e) {
			throw new CoupanIdNotFoundException("Coupan not found");
		}
	}

	public List<Coupan> viewCoupans(){
		List<Coupan> coupan = new ArrayList<Coupan>();
		ICoupanRepository.findAll().forEach(coupan1 -> coupan.add(coupan1));
		return coupan;
	}
}
