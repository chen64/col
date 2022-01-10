import { Component, OnInit } from '@angular/core';
import { GachaService } from './gacha.service';
import { Collectable } from '../models/collectable';
import { User } from '../models/user';
import { Subscription } from 'rxjs';
import { AuthService } from '../service';

@Component({
  selector: 'app-gacha',
  templateUrl: './gacha.component.html',
  styleUrls: ['./gacha.component.css']
})
export class GachaComponent implements OnInit {
  currentUser: User;
  username = 'temp';
  collList;
  currentUserSubscription: Subscription;
  users: User[] = [];
  constructor(
    private authService: AuthService,
    private gachaService: GachaService
  ) {
    this.currentUserSubscription = this.authService.currentUser.subscribe(
      data => {
        //console.log(data);
        this.currentUser = localStorage.getItem('currentUser') as any;
      }
    );
  }

  ngOnInit(): void {}

  getCollectables() {
    this.gachaService
      .getCollectablesfromServer(this.currentUser)
      .subscribe(data => {
        this.collList = data;
      });
  }

  getCollectable() {
    this.gachaService
      .getCollectablefromServer(this.currentUser)
      .subscribe(data => {
        this.collList = data;
      });
  }
}
