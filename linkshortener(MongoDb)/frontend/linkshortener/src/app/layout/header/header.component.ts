import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})

export class HeaderComponent implements OnInit {
  public authUserItems: MenuItem[];
  public notAuthUserItems: MenuItem[];

  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.authUserItems = [
      { label: 'Create link', routerLink: 'createLink' },
      { label: 'My links',  routerLink: 'userLinks'},
      { label: 'Home', routerLink: '/home' },
      { label: 'Sign out', command: (event) => { this.logOut(); } },
    ];
    this.notAuthUserItems = [
      { label: 'Home', routerLink: '/home' },
      { label: 'Sign in', routerLink: '/signIn' },
      { label: 'Sign up', routerLink: '/signUp' },
    ];
  }

  public logOut() {
    this.userService.signOut().subscribe((response) => {
      if (response.isSuccess) {
        this.userService.logOut();
        this.router.navigate(['/']);
      }
    });
  }
}
