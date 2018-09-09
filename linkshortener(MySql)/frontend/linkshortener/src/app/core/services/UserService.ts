import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/urls';
import { Response } from '../entities/response';
import { User } from '../entities/user';

@Injectable()
export class UserService {

    constructor(private cookieService: CookieService,
                private http: HttpClient) { }

    public isUserAuthenticated() {
        if (this.cookieService.get('token').length !== 0) {
            return true;
        } else {
            return false;
        }
    }

    public setUserAuthenticated(token: string, id: number) {
        this.cookieService.set('token', token);
        this.cookieService.set('userId', id.toString());
    }

    public getUserId(): number {
        return parseInt(this.cookieService.get('userId'), 10);
    }

    public logOut() {
        this.cookieService.deleteAll('/ ');
    }

    public signIn(user: User): Observable<Response<any[]>> {
        return this.http.post<Response<any>>(environment.signInUrl, user);
    }

    public signOut(): Observable<Response<any>> {
        return this.http.post<Response<any[]>>(environment.signOutUrl, this.cookieService.get('token'));
    }

    public chekLogin(login: string): Observable<Response<User>> {
        return this.http.post<Response<User>>(environment.chekLoginUrl, login);
    }

    public createUser(user: User): Observable<Response<User>> {
        return this.http.put<Response<User>>(environment.createUserUrl, user);
    }
}
