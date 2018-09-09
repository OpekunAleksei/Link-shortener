import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Link } from '../core/entities/link';
import { LinkService } from '../core/services/LinkService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})

export class HomeComponent implements OnInit {
  public links: Link[];
  public shortLink: string;
  constructor(private linkService: LinkService,
              private router: Router) {
    this.links = new Array();
  }

  ngOnInit() {
    this.linkService.getAll().subscribe((response) => {
      this.links = response.data;
    });
  }

  public findLink() {
    this.router.navigate(['/linkProfile', this.shortLink.substr(23, 10)]);
  }
}
