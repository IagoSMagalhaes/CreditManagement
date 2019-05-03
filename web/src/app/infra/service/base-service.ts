import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { HttpClient } from '@angular/common/http';

// @Injectable()
export class BaseService {

  constructor(private http: HttpClient) {
}
  private URL = environment.credit_management_url;

  get(url: string, id?: number): Promise<any> {
    return this.http.get(this.URL + url + '/' + id).toPromise().then(
      response => {
        return response;
      }).catch( response => 'Erro na chamada da API');
 }

  save(url: string, entity?: any): Promise<any> {
     return this.postAndReturnValue(url, {body: entity});

 }

 update(url: string, entity: any, byPassBusinessErrors?: boolean): Promise<any> {
  return this.http.put(this.URL + url, JSON.stringify(entity))
                  .toPromise()
                  .then(response => {
                    return response;
                  }).catch( response => 'Erro na chamada da API');
}

private returnArray(response) {
  const responseArray = response as Array<any>;
  return responseArray;
}

  postAndReturnValue(url: string, options?: any): Promise<any> {
  const optionsTratado = options || {};
  const body = optionsTratado.body;
  return this.http.post(this.URL + url, body)
    .toPromise()
    .then(response => {
        return response;
    } ).catch( response => 'Erro na chamada da API');
}

}
