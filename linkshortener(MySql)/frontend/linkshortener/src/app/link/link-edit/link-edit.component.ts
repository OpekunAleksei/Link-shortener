import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import _ = require('lodash');
import { Link } from '../../core/entities/link';
import { Tag } from '../../core/entities/tag';
import { LinkService } from '../../core/services/LinkService';
import { TagService } from '../../core/services/TagService';

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
              private tagService: TagService,
              private router: Router) { }

  public update() {
    this.linkService.updateLink(this.link).subscribe((response) => {
      if (response.isSuccess) {
        this.updateComplete.emit(response.data);
      }
    });
  }

  public addTag() {
    const tag = new Tag(this.tagName);

    if (!this.link.tags.includes(tag)) {
      this.tagService.createTag(tag).subscribe((response) => {
        this.tagName = '';
        this.link.tags.push(response.data);
      });
    }
  }

  public delete() {
    this.linkService.deteLink(this.link).subscribe((response) => {
      if (response.isSuccess) {
        this.router.navigate(['/userLinks']);
      }
    });
  }

  public removeTag(tag: Tag) {
    this.tagService.deleteTag(tag).subscribe((response) => {
      if (response.isSuccess) {
        this.link.tags = this.link.tags.filter((deleteTag) => deleteTag !== tag);
      }
    });
  }

}
