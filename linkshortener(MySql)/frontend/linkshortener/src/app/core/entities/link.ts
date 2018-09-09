import { Tag } from './tag';
import { User } from './user';

export class Link {

    public description: string;
    public user: User;
    public url: string;
    public shortLink: string;
    public id: number;
    public views: number;
    public tags: Tag[];
    constructor() {
        this.tags = new Array();
    }
}
