import { NgModule } from '@angular/core';
import { ShortLinkPipe } from './pipes/short-link.pipe';

@NgModule({
    declarations: [ShortLinkPipe],
    exports: [
        ShortLinkPipe,
    ],
})
export class SharedModule { }
