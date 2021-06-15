import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PizzaComponent } from './components/pizza/pizza.component';
import { CustomerComponent } from './customer/customer.component';



const routes: Routes = [
  { path: 'view-pizza', component: PizzaComponent },
  { path: 'view-customer', component: CustomerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
