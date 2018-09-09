import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../core/entities/user';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css'],
})

export class SignInComponent implements OnInit {

  public user: User;
  public userform: FormGroup;

  constructor(private userService: UserService,
              private router: Router) {
    this.user = new User();
  }

  ngOnInit(): void {
    this.userFormConfiguration();
  }

  public userFormConfiguration() {
    this.userform = new FormGroup({
      password: new FormControl('', Validators.required),
      login: new FormControl('', Validators.required),
    });
  }

  public onSubmit() {
    this.userService.signIn(this.user).subscribe((response) => {
      if (response.isSuccess) {
        this.userService.setUserAuthenticated(response.data[1], response.data[0].id);
        this.router.navigate(['/home']);
      }
    });
  }
}
