import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/services/customer.service';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  Customers: Observable<Customer[]>;
  Customer : Customer=new Customer();
  deleteMessage=false;

  constructor(private CustomerService:CustomerService) { }

  ngOnInit() {
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };   
    this.CustomerService.getCustomer().subscribe(data =>{
    this.Customers =data;
    this.dtTrigger.next();
    })
  }
  
  delete(id: number) {
    this.CustomerService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.CustomerService.getCustomer().subscribe(data =>{
            this.Customers =data
            })
        },
        error => console.log(error));

  }

}
