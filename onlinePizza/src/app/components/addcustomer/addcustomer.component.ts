import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/services/customer.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-addcustomer',
  templateUrl: './addcustomer.component.html',
  styleUrls: ['./addcustomer.component.css']
})
export class AddCustomerComponent implements OnInit {

  constructor(private customerservice:CustomerService) { }

  customer : Customer=new Customer();
  submitted = false;

  ngOnInit() {
    this.submitted=false;
  }

  customersaveform=new FormGroup({
    customerName:new FormControl('' , [Validators.required , Validators.minLength(5),Validators.minLength(0) ] ),
    customerEmail:new FormControl('',[Validators.required]),
    customerAddress:new FormControl('',[Validators.required]),
    customerMobile:new FormControl('',Validators.required),
    userName:new FormControl('',Validators.required),
    password:new FormControl('',Validators.required)
  });

  saveCustomer(saveCustomer){
    this.customer=new Customer();   
    this.customer.customerName=this.CustomerName.value;
    this.customer.customerEmail=this.CustomerEmail.value;
    this.customer.customerAddress=this.CustomerAddress.value;
    this.customer.customerMobile = this.CustomerMobile.value;
    this.customer.userName = this.UserName.value;
    this.customer.password = this.Password.value;

    this.submitted = true;
    this.save();
  }

  

  save() {
    this.customerservice.createCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }

  get CustomerName(){
    return this.customersaveform.get('customerName');
  }

  get CustomerEmail(){
    return this.customersaveform.get('customerEmail');
  }

  get CustomerAddress(){
    return this.customersaveform.get('customerAddress');
  }
  get CustomerMobile(){
    return this.customersaveform.get('customerMobile');
  }
  get UserName(){
    return this.customersaveform.get('userName');
  }
  get Password(){
    return this.customersaveform.get('password');
  }

  addCustomerForm(){
    this.submitted=false;
    this.customersaveform.reset();
  }

}
