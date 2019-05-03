import { Injectable, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { BaseResourceService } from 'src/app/infra/service/base-resource.service';
import { CreditManagementUrl } from 'src/app/infra/url/credit-management-url';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private URL = CreditManagementUrl.CLIENT;

  constructor(private baseService: BaseResourceService) {
  }

  formClient = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required]),
    creditLimit: new FormControl('', [Validators.required]),
    risk: new FormControl('', [Validators.required]),
    interestRate: new FormControl('')
  });
  save(client): Promise<any> {
    return this.baseService.save(this.URL, client);
  }
  delete(id): Promise<any> {
    return this.baseService.delete(this.URL, id);
  }
  get(id): Promise<any> {
    return this.baseService.get(this.URL, id);
  }

  findAll(): Promise<any> {
    return this.baseService.findAll(this.URL);
  }
  update(client): Promise<any> {
    return this.baseService.update(this.URL, client);
  }
}
