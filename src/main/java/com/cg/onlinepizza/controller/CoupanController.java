package com.cg.onlinepizza.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.dto.Coupan;
import com.cg.onlinepizza.service.ICoupanService;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;

@RestController
public class CoupanController {
	@Autowired
	ICoupanService ics;
	
	@GetMapping("/viewCoupan")
	public List<Coupan> viewCoupans(){
		return ics.viewCoupans();
	}
	@PostMapping("/coupan")
	public int addcoupan(@RequestBody Coupan coupan) {
		ics.addCoupans(coupan);
		return coupan.getCoupanId();
	}
	
	@PutMapping("/edit")
	public Coupan edit(@RequestBody Coupan coupan) throws InvalidCoupanOperationException {
		ics.editCoupans(coupan);
		return coupan;
	}
	
	@DeleteMapping("coupan/{coupanId}")
	public int deleteCoupan(@PathVariable("coupanId") int id) throws CoupanIdNotFoundException{
		ics.deleteCoupans(id);
		return id;
	}
	

}
