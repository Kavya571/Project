import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { PizzaOrder } from 'src/app/pizza-order';
import { PizzaOrderService } from 'src/app/services/pizza-order.service';


@Component({
  selector: 'app-pizza-order',
  templateUrl: './pizza-order.component.html',
  styleUrls: ['./pizza-order.component.css']
})
export class PizzaOrderComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  PizzaOrders: Observable<PizzaOrder[]>;
  PizzaOrder : PizzaOrder=new PizzaOrder();
  deleteMessage=false;
  constructor(private PizzaOrderService:PizzaOrderService) { }

  ngOnInit() {
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };   
    this.PizzaOrderService.getPizzaOrder().subscribe(data =>{
    this.PizzaOrders =data;
    this.dtTrigger.next();
    })
  }
  delete(id: number) {
    this.PizzaOrderService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.PizzaOrderService.getPizzaOrder().subscribe(data =>{
            this.PizzaOrders =data
            })
        },
        error => console.log(error));
  }

}
