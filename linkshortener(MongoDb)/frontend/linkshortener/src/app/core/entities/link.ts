
export class Link {

    public description: string;
    public userId: string;
    public url: string;
    public shortLink: string;
    public id: string;
    public views: number;
    public tags: string[];
    constructor(userId: string) {
        this.views = 0;
        this.userId = userId;
        this.tags = new Array();
    }
}
