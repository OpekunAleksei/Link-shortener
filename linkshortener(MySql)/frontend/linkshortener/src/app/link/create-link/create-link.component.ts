import { Component } from '@angular/core';
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-create-link',
  templateUrl: './create-link.component.html',
  styleUrls: ['./create-link.component.css'],
})
export class CreateLinkComponent {

  public link: Link;
  public existLink: Link;
  public editLink: boolean;

  constructor(private userService: UserService,
              private linkService: LinkService) {

    this.editLink = false;
    this.link = new Link();
  }

  public shorten() {
    this.linkService.createLink(this.link.url, this.userService.getUserId()).subscribe((response) => {
      if (response.isSuccess) {
        this.link = response.data;
        this.editLink = true;
      } else {
        this.existLink = response.data;
      }
    });
  }

}
