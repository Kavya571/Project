package com.cg.onlinepizza.repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.onlinepizza.dto.Coupan;


public interface ICoupanRepository extends CrudRepository<Coupan,Integer> {
//	Coupan addCoupans(Coupan coupan);
//
//	Coupan editCoupans(Coupan coupan)throws InvalidCoupanOperationException ;
//
//	Coupan deleteCoupans(int coupanId)throws CoupanIdNotFoundException;
//
//	List<Coupan> viewCoupans();
}
