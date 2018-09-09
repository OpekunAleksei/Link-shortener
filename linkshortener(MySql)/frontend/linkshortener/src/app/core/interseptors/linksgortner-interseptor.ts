import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import 'rxjs/add/operator/do';
import { Observable } from 'rxjs/Observable';
import { Response } from '../entities/response';

@Injectable()
export class LinkshortnerInterceptor implements HttpInterceptor {

    constructor(private cookieService: CookieService) { }

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let cloneReq = req;
        let response: Response<any>;

        if (this.cookieService.get('token') !== undefined) {
            cloneReq = req.clone({
                setHeaders: { Authorization: this.cookieService.get('token') },
            });
        }
        return next.handle(cloneReq).do((event) => {
            if (event instanceof HttpResponse) {
                response = event.body;
                if (!response.isSuccess && response.erorMsg !== null) {
                    alert(response.erorMsg);
                }

            }
        });
    }
}
