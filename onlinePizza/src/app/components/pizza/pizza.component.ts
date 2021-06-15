import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Pizza } from 'src/app/pizza';
import { PizzaServiceService } from 'src/app/services/pizza.service';
@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  Pizzas: Observable<Pizza[]>;
  Pizza : Pizza=new Pizza();
  deleteMessage=false;
  constructor(private PizzaServiceService:PizzaServiceService) { }

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
  }
  delete(id: number) {
    this.PizzaServiceService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.PizzaServiceService.getPizza().subscribe(data =>{
            this.Pizzas =data
            })
        },
        error => console.log(error));
  }

}
