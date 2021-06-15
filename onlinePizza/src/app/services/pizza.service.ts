import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/internal/operators';


@Injectable({
  providedIn: 'root'
})
export class PizzaServiceService {
  PIZZA_PATH = 'http://localhost:7070/';
  GET_PIZZA_PATH = '/viewPizza';
  constructor(private http: HttpClient) { }
  getPizza(): Observable<any> {
    //return this.http.get(`${this.baseUrl}`+'students-list');
    return this.http.get(this.PIZZA_PATH + this.GET_PIZZA_PATH).pipe(map(
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
    return this.http.delete(this.PIZZA_PATH + '/pizza/'+id).pipe(map(
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
