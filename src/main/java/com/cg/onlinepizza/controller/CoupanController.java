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

import com.cg.onlinepizza.dto.Coupan;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidCoupanOperationException;
import com.cg.onlinepizza.service.ICoupanService;
@RestController
public class CoupanController {
	@Autowired
	ICoupanService ics;
	@GetMapping("/viewCoupan")
	private List<Coupan> viewCoupans(){
		return ics.viewCoupans();
	}
	@PostMapping("/coupan")
	private int addcoupan(@RequestBody Coupan coupan) {
		ics.addCoupans(coupan);
		return coupan.getCoupanId();
	}
	
	@PutMapping("/edit")
	private Coupan edit(@RequestBody Coupan coupan) throws InvalidCoupanOperationException {
		ics.editCoupans(coupan);
		return coupan;
	}
	
	@DeleteMapping("coupan/{coupanId}")
	private void deleteCoupan(@PathVariable("coupanId") int id) throws CoupanIdNotFoundException{
		ics.deleteCoupans(id);
	}
	

}