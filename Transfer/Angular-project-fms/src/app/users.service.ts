import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  selectedUserToUpdate: User;

  api = 'http://localhost:8080/fmsboot';

  constructor(private http: HttpClient) { }

  postData(user): Observable<any> {
    return this.http.post<any>(`${this.api}/addUser`, user);
  }

  getData(): Observable<any> {
    return this.http.post<any>(`${this.api}/getAllUsers`, {});
  }

  getName(userId): Observable<any> {
    return this.http.get<any>(`${this.api}/getUser/${userId}`);
  }

  deleteData(user): Observable<any> {
    return this.http.delete<any>(`${this.api}/deleteUser/${user.userId}`);
  }

  // To be checked
  updateData(user): Observable<any> {
    return this.http.put<any>(
      `${this.api}/updateUser`, user);
  }
}

