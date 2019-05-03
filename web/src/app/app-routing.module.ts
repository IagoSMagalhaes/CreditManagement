import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientNewComponent } from './clients/component/client-new/client-new.component';
import { ClientListComponent } from './clients/component/client-list/client-list.component';

const routes: Routes = [
  {path: 'client/new', component: ClientNewComponent},
  {path: '', component: ClientListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
