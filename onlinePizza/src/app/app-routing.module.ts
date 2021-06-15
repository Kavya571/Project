import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PizzaComponent } from './components/pizza/pizza.component';
import { PizzaOrderComponent } from './components/pizza-order/pizza-order.component';
import { CustomerComponent } from './customer/customer.component';



const routes: Routes = [
  { path: 'view-pizza', component: PizzaComponent },
  { path: 'view-customer', component: CustomerComponent },
   { path: 'view-pizzaOrder', component: PizzaOrderComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
