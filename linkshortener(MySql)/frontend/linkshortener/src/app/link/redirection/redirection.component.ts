import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LinkService } from '../../core/services/LinkService';

@Component({
  selector: 'app-redirection',
  templateUrl: './redirection.component.html',
  styleUrls: ['./redirection.component.css'],
})
export class RedirectionComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private linkService: LinkService) { }

  ngOnInit() {
    this.route.params.subscribe(
      (params) => {
        this.linkService.getLinkByShortLink(params.value).subscribe((response) => {
          if (response.isSuccess) {
            document.location.href = response.data.url;
          } else {
            this.router.navigate(['/home']);
          }
        });
      },
    );
  }

}
