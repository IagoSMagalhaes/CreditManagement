import { BaseService } from './../../../infra/service/base-service';
import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { ClientService } from '../../service/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clientArray = [];
  showDeletedMessage: boolean;
  searchText = '';

  constructor(private clientService: ClientService) {

  }

  ngOnInit() {
    this.clientService.findAll().then(response => {
       this.clientArray = response;
    });
  }

  delete(id: string) {
    if (confirm('Tem certeza que deseja excluir esse registro ? ')) {
      this.clientService.delete(id).then(response => {
        window.location.reload();
      });
    }
  }


}
