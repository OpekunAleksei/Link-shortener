import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/urls';
import { Link } from '../entities/link';
import { Response } from '../entities/response';
import { Tag } from '../entities/tag';

@Injectable()
export class TagService {

    constructor(private http: HttpClient) { }

    public createTag(tag: Tag): Observable<Response<Tag>> {
        return this.http.put<Response<Tag>>(environment.createTag, tag);
    }

    public deleteTag(tag: Tag): Observable<Response<Tag>> {
        return this.http.delete<Response<Tag>>(environment.deleteTag + tag.id.toString());
    }

    public getLinksByTag(tagId: number): Observable<Response<Link[]>> {
        return this.http.get<Response<Link[]>>(environment.getLinksByTag + tagId.toString());
    }
}
