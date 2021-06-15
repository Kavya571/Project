import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PizzaComponent } from './components/pizza/pizza.component';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CoupanComponent } from './components/coupan/coupan.component';
import { CustomerComponent } from './components/customer/customer.component';
import { AddcoupanComponent } from './components/addcoupan/addcoupan.component';
import { AddcustomerComponent } from './components/addcustomer/addcustomer.component';
import { LoginComponent } from './components/login/login.component';
import { PizzaOrderComponent } from './components/pizza-order/pizza-order.component';
import { AddpizzaOrderComponent } from './components/addpizza-order/addpizza-order.component';

@NgModule({
  declarations: [
    AppComponent,
    PizzaComponent,
    CoupanComponent,
    CustomerComponent,
    AddcoupanComponent,
    AddcustomerComponent,
    LoginComponent,
    PizzaOrderComponent,
    AddpizzaOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
