import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';

@Component({
  selector: 'app-links-by-tag',
  templateUrl: './links-by-tag.component.html',
  styleUrls: ['./links-by-tag.component.css'],
})

export class LinksByTagComponent implements OnInit {
  public links: Link[];
  constructor(private linkService: LinkService,
              private route: ActivatedRoute,
              private router: Router) {
    this.links = new Array();
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params) => {
        this.linkService.getLinksByTag(params.tag).subscribe((response) => {
          this.links = response.data;
        });
      },
    );
  }

  public getAll() {
    this.router.navigate(['/home']);
  }
}
