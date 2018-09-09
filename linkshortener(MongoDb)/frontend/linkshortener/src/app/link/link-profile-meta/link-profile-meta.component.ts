import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';
import { UserService } from '../../core/services/UserService';

@Component({
  selector: 'app-link-profile-meta',
  templateUrl: './link-profile-meta.component.html',
  styleUrls: ['./link-profile-meta.component.css'],
})

export class LinkProfileMetaComponent implements OnInit {
  @Input()
  public link: Link;
  @Output() isUpdateStart = new EventEmitter();
  public isUserLink: boolean;

  constructor(private userService: UserService,
              private linkService: LinkService,
              private router: Router) { }

  ngOnInit() {
    this.isUserLink = this.link.userId === this.userService.getUserId();
  }
  public startUpdate() {
    this.isUpdateStart.emit(true);
  }
  public deleteLink() {
    this.linkService.deteLink(this.link).subscribe((response) => {
      if (response.isSuccess) {
        this.router.navigate(['/userLinks']);
      }
    });
  }

  public serchByTag(tag: string) {
    this.router.navigate(['/linksByTag', tag]);
  }
}
