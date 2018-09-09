
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ButtonModule } from 'primeng/components/button/button';
import { InputTextareaModule } from 'primeng/components/inputtextarea/inputtextarea';
import { AppRoutingModule } from '../app-routing-module';
import { LayoutModule } from '../layout/layout.module';
import { SharedModule } from '../shared/shared.module';
import { CreateLinkComponent } from './create-link/create-link.component';
import { LinkEditComponent } from './link-edit/link-edit.component';
import { LinkProfileMetaComponent } from './link-profile-meta/link-profile-meta.component';
import { LinkProfileComponent } from './link-profile/link-profile.component';
import { LinksByTagComponent } from './links-by-tag/links-by-tag.component';
import { RedirectionComponent } from './redirection/redirection.component';
import { UserLinksComponent } from './user-links/user-links.component';

@NgModule({
    imports: [
        LayoutModule,
        SharedModule,
        ButtonModule,
        FormsModule,
        BrowserModule,
        InputTextareaModule,
        AppRoutingModule,
    ],
    declarations: [
        CreateLinkComponent,
        LinkEditComponent,
        UserLinksComponent,
        LinkProfileComponent,
        LinkProfileMetaComponent,
        RedirectionComponent,
        LinksByTagComponent,
    ],
    exports: [
        CreateLinkComponent,
        LinkEditComponent,
        UserLinksComponent,
        LinkProfileComponent,
        LinkProfileMetaComponent,
        RedirectionComponent,
        LinksByTagComponent,
    ],
})

export class LinkModule { }
