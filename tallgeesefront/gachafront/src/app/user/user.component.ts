import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import { User } from '../models';
import { UserService, AuthService } from '../service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  currentUser: User;
  username = 'temp';
  collList;
  currentUserSubscription: Subscription;
  users: User[] = [];
  constructor(
    private authService: AuthService,
    private userService: UserService
  ) {
    this.currentUserSubscription = this.authService.currentUser.subscribe(
      data => {
        //console.log(data);
        this.currentUser = localStorage.getItem('currentUser') as any;
      }
    );
  }

  ngOnInit() {
    this.loadUser();
  }

  private loadUser() {
    this.userService
      .showCollection(this.currentUser)
      .pipe(first())
      .subscribe(data => {
        this.collList = data;
      });
  }
}
