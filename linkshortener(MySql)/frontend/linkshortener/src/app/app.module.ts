import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing-module';
import { AppComponent } from './app.component';
import { AuthorizationModule } from './authorization/authorization.module';
import { CoreModule } from './core/core.module';
import { HomeComponent } from './home/home.component';
import { LayoutModule } from './layout/layout.module';
import { LinkModule } from './link/link.module';
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
  ],
  imports: [
    LinkModule,
    AuthorizationModule,
    FormsModule,
    CoreModule,
    LayoutModule,
    SharedModule,  
    AppRoutingModule,
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
