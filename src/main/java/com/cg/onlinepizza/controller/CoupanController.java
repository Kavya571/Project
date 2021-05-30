package com.cg.onlinepizza.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.service.ICoupanService;
import com.cg.onlinepizza.util.OnlinePizzaConstants;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.exceptions.ValidateCoupanException;
import com.cg.onlinepizza.dto.*;
@RestController
public class CoupanController {
	@Autowired
	ICoupanService ics;
	
	@GetMapping("/viewCoupan")
	public List<Coupan> viewCoupans(){
		return ics.viewCoupans();
		
	}
	@PostMapping("/coupan")
	public SuccessMsg addcoupan(@RequestBody Coupan coupan) throws ValidateCoupanException {
		ics.addCoupans(coupan);
		return new SuccessMsg(OnlinePizzaConstants.COUPAN_ADDED);
	}
	
	@PutMapping("/edit")
	public SuccessMsg edit(@RequestBody Coupan coupan) throws InvalidCoupanOperationException {
		ics.editCoupans(coupan);
		return new SuccessMsg(OnlinePizzaConstants.COUPAN_UPDATED);
	}
	
	@DeleteMapping("/coupan/{coupanId}")
	public SuccessMsg deleteCoupan(@PathVariable("coupanId") int id) throws CoupanIdNotFoundException{
		ics.deleteCoupans(id);
		return new SuccessMsg(OnlinePizzaConstants.COUPAN_DELETED);
	}
	

}
