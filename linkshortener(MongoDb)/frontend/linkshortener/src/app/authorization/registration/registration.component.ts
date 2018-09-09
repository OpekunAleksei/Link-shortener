import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../core/entities/user';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})

export class RegistrationComponent implements OnInit {
  public user: User;
  public isUserUpdate: boolean;
  public userform: FormGroup;
  public loiginIdentical: boolean;
  constructor(private userService: UserService,
              private router: Router,
              private fb: FormBuilder) {
    this.user = new User();
    this.loiginIdentical = false;
  }

  ngOnInit(): void {
    this.userFormConfiguration();
  }

  public userFormConfiguration() {
    this.userform = new FormGroup({
      passwords: this.fb.group({
        pwd: ['', Validators.required],
        confirm: ['', Validators.required],
      }, { validator: this.passwordsAreEqual() }),
      login: new FormControl('', Validators.required),
    });
  }

  public passwordValidate(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      if ((control.value === undefined || !control.dirty || !control.touched)) {
        return null;
      } else {
        return {
          custom: 'Wrong password',
        };
      }
    };
  }

  public checkLoginIdentical() {
    this.userService.chekLogin(this.user.login).subscribe((isIdentical) => {
      this.loiginIdentical = !isIdentical.isSuccess;
    });
  }

  public onSubmit() {
    this.userService.createUser(this.user).subscribe((response) => {
      if (response.isSuccess) {
        this.router.navigate(['/signIn']);
      } else {
      }
    });
  }
  
  private passwordsAreEqual(): ValidatorFn {
    return (group: FormGroup): { [key: string]: any } => {
      if (!(group.dirty || group.touched) || group.get('pwd').value === group.get('confirm').value) {
        return null;
      }
      return {
        custom: 'Passwords are not equal',
      };
    };
  }
}
