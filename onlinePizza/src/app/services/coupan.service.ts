import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class CoupanService {

  COUPAN_PATH = 'http://localhost:9090/';
  GET_COUPAN_PATH = '/viewCoupan';
  constructor(private http: HttpClient) { }
  getCoupan(): Observable<any> {

    return this.http.get(this.COUPAN_PATH + this.GET_COUPAN_PATH).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }
  
  createCoupan(coupan: object): Observable<object> {
    return this.http.post(`${this.COUPAN_PATH}`+'coupan', coupan);
  }
  delete(id): Observable<any> {
    return this.http.delete(this.COUPAN_PATH + '/coupan/'+id).pipe(map(
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
