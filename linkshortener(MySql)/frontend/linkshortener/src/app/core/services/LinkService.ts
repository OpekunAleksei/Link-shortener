import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/urls';
import { Link } from '../entities/link';
import { Response } from '../entities/response';

@Injectable()
export class LinkService {

    constructor(private http: HttpClient) { }

    getShortLink(): Observable<Response<any>> {
        return this.http.get<Response<any>>(environment.getShortUrl);
    }

    createLink(url: string, userId: number): Observable<Response<Link>> {
        return this.http.put<Response<Link>>(environment.createDeleteLink + userId.toString(), url);
    }

    public updateLink(link: Link): Observable<Response<Link>> {
        return this.http.post<Response<Link>>(environment.updateLink, link);
    }

    public  deteLink(link: Link): Observable<Response<Link>> {
        return this.http.delete<Response<Link>>(environment.createDeleteLink + link.id);
    }

    public  getAll(): Observable<Response<Link[]>> {
        return this.http.get<Response<Link[]>>(environment.getAllLink);
    }

    public  getUserLinks(userId: number): Observable<Response<Link[]>> {
        return this.http.post<Response<Link[]>>(environment.userLinks , userId);
    }
    
    public  getLinkByShortLink(shortLink: string): Observable<Response<Link>> {
        return this.http.get<Response<Link>>(environment.getLinkByShotrUrl + shortLink);
    }
}
