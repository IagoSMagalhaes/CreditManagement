import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environment/environment';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BaseResourceService {


  constructor(private http: HttpClient) {
}
  private URL = environment.credit_management_url;

     findAll(url: string, id?: number): Promise<any> {
       console.log('efetuando chamada');
           return this.http.get(this.URL + url).toPromise().then(
                   response => {
                     console.log('response = ' + response);
                     return response;
                   }).catch( response => 'Erro na chamada da APIsss');
              }

    delete(url: string, id: number): Promise<any> {
      return this.http.delete(this.URL + url + id)
                      .toPromise()
                      .catch( response => 'Erro na chamada da API');
  }

  get(url: string, id?: number): Promise<any> {
    return this.http.get(this.URL + url + '/' + id).toPromise().then(
      response => {
        return response;
      }).catch( response => 'Erro na chamada da API');
 }

  save(url: string, entity?: any): Promise<any> {
     return this.postAndReturnValue(url, {body: JSON.stringify(entity)});

 }

 update(url: string, entity: any): Promise<any> {
  return this.http.put(this.URL + url, JSON.stringify(entity), httpOptions)
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
  return this.http.post(this.URL + url, body, httpOptions)
    .toPromise()
    .then(response => {
        return response as any;
    } ).catch( response => 'Erro na chamada da API');
}

}
