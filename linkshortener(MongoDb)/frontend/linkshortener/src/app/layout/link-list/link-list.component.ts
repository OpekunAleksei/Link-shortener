import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Link } from '../../core/entities/link';

@Component({
  selector: 'app-link-list',
  templateUrl: './link-list.component.html',
  styleUrls: ['./link-list.component.css'],
})

export class LinkListComponent {
  @Input()
  public links: Link[];
  @Input()
  public isLinksByTag: boolean;

  constructor(private router: Router) {
    this.isLinksByTag = false;
  }

  public serchByTag(tag: string) {
    this.router.navigate(['/linksByTag', tag]);
  }

}
