import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  username:string;
  LOGIN_PATH = 'http://localhost:7070/';
  constructor(private http: HttpClient) { }
  signin(UserName,Password):Observable<object>{
    return this.http.get(this.LOGIN_PATH+'/signin/'+UserName+'/'+Password).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      },
      this.username=UserName
    ));
  }
}
