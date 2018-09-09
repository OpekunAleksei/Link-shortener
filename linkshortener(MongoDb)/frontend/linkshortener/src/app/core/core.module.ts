import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { LinkshortnerInterceptor } from './interseptors/linksgortner-interseptor';
import { LinkService } from './services/LinkService';
import { UserService } from './services/UserService';

@NgModule({
  imports: [HttpClientModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: LinkshortnerInterceptor, multi: true },
    CookieService,
    LinkService,
    UserService,
  ],
})

export class CoreModule { }
