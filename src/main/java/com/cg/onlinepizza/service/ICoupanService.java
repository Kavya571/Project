package com.cg.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.exceptions.CoupanExistException;
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
 
	public Coupan addCoupans(Coupan coupan)throws ValidateCoupanException, CoupanExistException{
		    validateCoupan(coupan);
		    Optional<Coupan> optionalCoupan = ICoupanRepository.findById(coupan.getCoupanId());
		    if(!optionalCoupan.isPresent()) {
		        return ICoupanRepository.save(coupan);
		    }
		    throw new CoupanExistException(OnlinePizzaConstants.COUPAN_EXIST);		
	};

	public Coupan editCoupans(Coupan coupan)throws ValidateCoupanException,CoupanIdNotFoundException{
		try {
			if(ICoupanRepository.existsById(coupan.getCoupanId())) {
			   if(!validateCoupan(coupan)) {
				  throw new ValidateCoupanException();
			   }	
			   return ICoupanRepository.save(coupan);
			}else {
				throw new CoupanIdNotFoundException();
			}
		}catch(CoupanIdNotFoundException ci) {
			throw new CoupanIdNotFoundException(OnlinePizzaConstants.COUPAN_ID_NOT_FOUND);
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
		Optional<Coupan> optionalCoupan = ICoupanRepository.findById(coupanId);
		if(optionalCoupan.isPresent()) {
		    ICoupanRepository.deleteById(coupanId);
		    return coupanId;
		}else {
			throw new CoupanIdNotFoundException();
		}
		}catch(Exception e) {
			throw new CoupanIdNotFoundException(OnlinePizzaConstants.COUPAN_ID_NOT_FOUND);
		}
	}

	public List<Coupan> viewCoupans(){
		List<Coupan> coupan = new ArrayList<Coupan>();
		ICoupanRepository.findAll().forEach(coupan1 -> coupan.add(coupan1));
		return coupan;
	}
}
