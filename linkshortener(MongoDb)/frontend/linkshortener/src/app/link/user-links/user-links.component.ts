import { Component, OnInit } from '@angular/core';
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-user-links',
  templateUrl: './user-links.component.html',
  styleUrls: ['./user-links.component.css'],
})

export class UserLinksComponent implements OnInit {
  public links: Link[];
  constructor(private userService: UserService,
              private linkService: LinkService) {
    this.links = new Array();
  }

  ngOnInit() {
    this.linkService.getUserLinks(this.userService.getUserId()).subscribe((response) => {
      this.links = response.data;
    });
  }

}
