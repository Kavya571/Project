package com.cg.onlinepizza.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.dto.Coupan;

@Service
public class ICoupanService {
    @Autowired
    ICoupanRepository ICoupanRepository;
    
	public Coupan addCoupans(Coupan coupan) {
		
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
