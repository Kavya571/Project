import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Pizza } from 'src/app/classes/pizza';
import { LoginService } from 'src/app/services/login.service';
import { PizzaServiceService } from 'src/app/services/pizza.service';
declare var toastr: any;
@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css'],
})
export class PizzaComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  Pizzas: Observable<Pizza[]>;
  Pizza : Pizza=new Pizza();
  deleteMessage=false;
  userName:String;
  constructor(private PizzaServiceService:PizzaServiceService,private LoginService:LoginService) { }
  ngOnInit() {
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };   
    this.PizzaServiceService.getPizza().subscribe(data =>{
    this.Pizzas =data;
    this.dtTrigger.next();
    })
    this.userName=this.LoginService.username;
  }
  delete(id: number) {
    this.PizzaServiceService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          toastr.success("SuccessFully deleted");
          this.deleteMessage=true;
          this.PizzaServiceService.getPizza().subscribe(data =>{
            this.Pizzas =data
            })
        },
        error => console.log(error));
        
  }

}
