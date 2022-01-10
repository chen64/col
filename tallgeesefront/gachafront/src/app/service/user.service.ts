import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class UserService {
  url = 'http://localhost:9006/TallGeeseProject/api/gacha';

  constructor(private http: HttpClient) {}

  getAll(user: User): Observable<string[]> {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.http.post<string[]>(this.url + `getUser.app`, user, httpPut);
  }

  register(user: User) {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.http.post(this.url + `/addUser.app`, user, httpPut);
  }

  showCollection(user: User): Observable<string[]> {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.http.post<string[]>(
      this.url + '/userCollection.app',
      user,
      httpPut
    );
  }

  email(email: string) {
    const httpPut = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        withCredentials: 'true'
      })
    };
    return this.http.post(this.url + `/mail.app`, email, httpPut);
  }
}
