import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';

@Component({
  selector: 'app-link-profile',
  templateUrl: './link-profile.component.html',
  styleUrls: ['./link-profile.component.css'],
})
export class LinkProfileComponent implements OnInit {
  public link: Link;
  public isLinkUpdate: boolean;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private linkService: LinkService) {
    this.isLinkUpdate = false;
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params) => {
        this.linkService.getLinkByShortLink(params.id).subscribe((response) => {
          if (response.isSuccess) {
            this.link = response.data;
          } else {
            this.router.navigate(['/home']);
          }
        });
      },
    );
  }

  public updateLink(link: Link) {
    this.link = link;
    this.isLinkUpdate = false;
  }
}
