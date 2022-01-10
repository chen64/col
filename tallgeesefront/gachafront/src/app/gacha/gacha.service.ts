import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class GachaService {
  url = 'http://localhost:9006/TallGeeseProject/api/gacha';

  constructor(private myHttpCli: HttpClient) {}

  getCollectablesfromServer(user: User): Observable<string[]> {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.myHttpCli.post<string[]>(
      this.url + '/10roll.app',
      user,
      httpPut
    );
  }

  getCollectablefromServer(user: User): Observable<string[]> {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.myHttpCli.post<string[]>(this.url + '/roll.app', user, httpPut);
  }
}
