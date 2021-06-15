import { Component, OnInit } from '@angular/core';
import { Coupan } from 'src/app/coupan';
import { CoupanService } from 'src/app/services/coupan.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-add-coupan',
  templateUrl: './add-coupan.component.html',
  styleUrls: ['./add-coupan.component.css']
})
export class AddCoupanComponent implements OnInit {

  constructor(private coupanservice:CoupanService) { }

  coupan : Coupan=new Coupan();
  submitted = false;

  ngOnInit() {
    this.submitted=false;
  }

  coupansaveform=new FormGroup({
    coupanName:new FormControl('' , [Validators.required , Validators.minLength(5),Validators.minLength(0) ] ),
    coupanType:new FormControl('',[Validators.required]),
    coupanDescription:new FormControl('',[Validators.required]),
    coupanPizzaId:new FormControl('',Validators.required)
  });

  saveCoupan(saveCoupan){
    this.coupan=new Coupan();   
    this.coupan.coupanName=this.CoupanName.value;
    this.coupan.coupanType=this.CoupanType.value;
    this.coupan.coupanDescription=this.CoupanDescription.value;
    this.coupan.coupanPizzaId = this.CoupanPizzaId.value;
    this.submitted = true;
    this.save();
  }

  

  save() {
    this.coupanservice.createCoupan(this.coupan)
      .subscribe(data => console.log(data), error => console.log(error));
    this.coupan = new Coupan();
  }

  get CoupanName(){
    return this.coupansaveform.get('coupanName');
  }

  get CoupanType(){
    return this.coupansaveform.get('coupanType');
  }

  get CoupanDescription(){
    return this.coupansaveform.get('coupanDescription');
  }
  get CoupanPizzaId(){
    return this.coupansaveform.get('coupanPizzaId');
  }

  addCoupanForm(){
    this.submitted=false;
    this.coupansaveform.reset();
  }

}
