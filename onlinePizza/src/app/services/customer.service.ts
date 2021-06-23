import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  CUSTOMER_PATH = 'http://localhost:7072/';
  GET_CUSTOMER_PATH = '/viewCustomer';
  constructor(private http: HttpClient) { }


  getCustomer(): Observable<any> {

    return this.http.get(this.CUSTOMER_PATH + this.GET_CUSTOMER_PATH).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }
  createCustomer(customer: object): Observable<object> {
    return this.http.post(`${this.CUSTOMER_PATH}`+'customer', customer);
  }
  delete(id): Observable<any> {
    return this.http.delete(this.CUSTOMER_PATH + '/customer/'+id).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }
}
