import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class PizzaOrderService {
  PIZZAORDER_PATH = 'http://localhost:7070/';
  GET_PIZZAORDER_PATH = '/viewOrders';
  constructor(private http: HttpClient) { }
  getPizzaOrder(): Observable<any> {
    //return this.http.get(`${this.baseUrl}`+'students-list');
    return this.http.get(this.PIZZAORDER_PATH + this.GET_PIZZAORDER_PATH).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }
  delete(id): Observable<any> {
    return this.http.delete(this.PIZZAORDER_PATH + '/pizzaOrder/'+id).pipe(map(
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

