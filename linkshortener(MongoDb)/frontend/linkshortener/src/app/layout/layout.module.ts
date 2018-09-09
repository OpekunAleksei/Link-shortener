import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ButtonModule } from 'primeng/components/button/button';
import { DataListModule } from 'primeng/components/datalist/datalist';
import { DataViewModule } from 'primeng/components/dataview/dataview';
import { InputTextareaModule } from 'primeng/components/inputtextarea/inputtextarea';
import { PanelModule } from 'primeng/components/panel/panel';
import { TabMenuModule } from 'primeng/components/tabmenu/tabmenu';
import { AppRoutingModule } from '../app-routing-module';
import { SharedModule } from '../shared/shared.module';
import { HeaderComponent } from './header/header.component';
import { LinkListComponent } from './link-list/link-list.component';

@NgModule({
  imports: [
    SharedModule,
    TabMenuModule,
    ButtonModule,
    DataListModule,
    DataViewModule,
    PanelModule,
    BrowserModule,
    InputTextareaModule,
    AppRoutingModule,
  ],
  declarations: [
    LinkListComponent,
    HeaderComponent,
  ],
  exports: [
    LinkListComponent,
    HeaderComponent,
  ],
})

export class LayoutModule { }
