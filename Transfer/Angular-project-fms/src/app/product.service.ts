import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  selectedProductToUpdate: Product;

  api = 'http://localhost:8080/fmsboot';

  constructor(private http: HttpClient) { }

  postData(product: Product): Observable<any> {
    return this.http.post<any>(`${this.api}/addProduct`, product);
  }

  getData(): Observable<any> {
    return this.http.post<any>(`${this.api}/getAllProducts`, {});
  }

  deleteData(product): Observable<any> {
    return this.http.delete<any>(`${this.api}/deleteProduct/${product.productId}`);
  }

  updateData(product): Observable<any> {
    return this.http.put<any>(
      `${this.api}/updateProduct`, product);
  }
}
