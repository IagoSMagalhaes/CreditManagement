import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../service/client.service';
import { CreditManagementEnum } from 'src/app/enum/creditManagementEnum';
import { RiskEnum } from 'src/app/enum/risk';

@Component({
  selector: 'app-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {

  constructor(private clientService: ClientService) {
   }

  submitted: boolean;
  showSucessMessage: boolean;
  formClientNew = this.clientService.formClient.controls;
  values: CreditManagementEnum[] = [];
  risks: RiskEnum = RiskEnum.values;

  ngOnInit() {
  }

  onSubmit() {
      this.submitted = true;
      if (this.clientService.formClient.valid) {
        if (this.clientService.formClient.get('id').value === '') {
          this.clientService.save(this.clientService.formClient.value).then();
        } else {
          this.clientService.update(this.clientService.formClient.value).then();
        }
        this.showSucessMessage = true;
        setTimeout(() => this.showSucessMessage = false, 3000);
        this.submitted = false;
        this.clientService.formClient.reset();
  }
}
}
