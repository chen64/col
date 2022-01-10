import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './service/authguard.service';
import { GachaComponent } from './gacha/gacha.component';
import { MailComponent } from './mail/mail.component';

const routes: Routes = [
  { path: 'home', component: UserComponent, canActivate: [AuthGuard] },
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'gacha', component: GachaComponent },
  { path: 'mail', component: MailComponent },

  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(routes);
