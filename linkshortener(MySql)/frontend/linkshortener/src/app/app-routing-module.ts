import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './authorization/registration/registration.component';
import { SignInComponent } from './authorization/sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { CreateLinkComponent } from './link/create-link/create-link.component';
import { LinkProfileComponent } from './link/link-profile/link-profile.component';
import { LinksByTagComponent } from './link/links-by-tag/links-by-tag.component';
import { RedirectionComponent } from './link/redirection/redirection.component';
import { UserLinksComponent } from './link/user-links/user-links.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { RedirectGuard } from './shared/guards/redirect.guard';

const routes: Routes = [

  { path: 'signUp', component: RegistrationComponent },
  { path: 'linkProfile/:id', component: LinkProfileComponent },
  { path: 'linksByTag/:tagId', component: LinksByTagComponent },
  { path: 'userLinks', component: UserLinksComponent , canActivate: [AuthGuard]},
  { path: 'signIn', component: SignInComponent },
  { path: 'home', component: HomeComponent },
  { path: 'createLink', component: CreateLinkComponent , canActivate: [AuthGuard]},
  { path: ':value', component: RedirectionComponent , canActivate: [RedirectGuard]},
  { path: '**', redirectTo: '/home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    AuthGuard,
    RedirectGuard,
  ],
})

export class AppRoutingModule { }
