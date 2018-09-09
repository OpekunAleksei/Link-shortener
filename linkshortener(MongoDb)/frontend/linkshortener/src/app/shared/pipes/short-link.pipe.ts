import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'shortLink' })
export class ShortLinkPipe implements PipeTransform {

    transform(value: string): string {
        const url = 'http://localhost:4200/';

        return url + value;
    }
}
