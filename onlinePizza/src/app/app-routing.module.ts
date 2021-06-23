import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PizzaComponent } from './components/pizza/pizza.component';
import { PizzaOrderComponent } from './components/pizza-order/pizza-order.component';
import { CustomerComponent } from './customer/customer.component';
import { AddCoupanComponent } from './components/add-coupan/add-coupan.component';
import { CoupanComponent } from './components/coupan/coupan.component';



const routes: Routes = [
  { path: 'view-pizza', component: PizzaComponent },
  { path: 'view-customer', component: CustomerComponent },
  { path: 'add-customer', component: AddCustomerComponent },
  { path: 'view-pizzaOrder', component: PizzaOrderComponent },
  { path: 'view-coupan',component: CoupanComponent},
  { path: 'add-coupan', component: AddCoupanComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
