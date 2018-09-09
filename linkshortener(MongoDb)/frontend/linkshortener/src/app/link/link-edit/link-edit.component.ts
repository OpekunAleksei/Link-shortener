import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import _ = require('lodash');
import { Link } from '../../core/entities/link';
import { LinkService } from '../../core/services/LinkService';

@Component({
  selector: 'app-link-edit',
  templateUrl: './link-edit.component.html',
  styleUrls: ['./link-edit.component.css'],
})
export class LinkEditComponent {
  @Input()
  public link: Link;
  @Output()
  public updateComplete = new EventEmitter();
  public tagName: string;

  constructor(private linkService: LinkService,
              private router: Router) { }

  public update() {
    this.linkService.updateLink(this.link).subscribe((response) => {
      if (response.isSuccess) {
        this.updateComplete.emit(response.data);
      }
    });
  }

  public addTag() {
    if (!this.link.tags.includes(this.tagName)) {
      this.link.tags.push(this.tagName);
      this.tagName = '';
    }

  }
  public delete() {
    this.linkService.deteLink(this.link).subscribe((response) => {
      if (response.isSuccess) {
        this.router.navigate(['/userLinks']);
      }
    });
  }

  public removeTag(tag: string) {
    this.link.tags = this.link.tags.filter((deleteTag) => deleteTag !== tag);
  }

}
