import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { environment } from '../environments/environment'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { ClientNewComponent } from './clients/component/client-new/client-new.component';
import { ClientListComponent } from './clients/component/client-list/client-list.component';
import { FooterComponent } from './infra/components/footer/footer.component';
import { HeaderComponent } from './infra/components/header/header.component';
import { SidebarComponent } from './infra/components/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent,
    ClientListComponent,
    ClientNewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas : [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
