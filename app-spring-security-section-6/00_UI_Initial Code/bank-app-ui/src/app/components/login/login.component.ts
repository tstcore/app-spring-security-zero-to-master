import { Component, OnInit } from '@angular/core';
import { User } from "src/app/model/user.model";
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';
import { getCookie } from 'typescript-cookie'; //-- Make sure to add the dependency in package.json file


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  authStatus: string = "";
  model:User = new User();

  constructor(private loginService: LoginService, private router: Router) {

   }

  ngOnInit(): void {

  }

  validateUser(loginForm: NgForm): void {
    this.loginService.validateLoginDetails(this.model).subscribe(
      responseData => {
        this.model = <any> responseData.body;
        this.model.authStatus = 'AUTH';
        window.sessionStorage.setItem("userdetails",JSON.stringify(this.model));
        this.router.navigate(['dashboard']);
      });

  }

}