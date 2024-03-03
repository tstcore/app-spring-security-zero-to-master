import { Injectable } from '@angular/core';
import { HttpInterceptor,HttpRequest,HttpHandler,HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {tap} from 'rxjs/operators';
import { User } from 'src/app/model/user.model';
import { Observable } from 'rxjs';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  user: User = new User();
  constructor(private router: Router) {}
  //-- the interceptor method that constantly intercepts our service requests
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {
    let httpHeaders = new HttpHeaders();
    //-- checks whether the sessionStorage contains the userDetails object
    if(sessionStorage.getItem('userdetails')){
      this.user = JSON.parse(sessionStorage.getItem('userdetails')!);
    }
    //-- checking whether user email and password are not null?
    if(this.user && this.user.password && this.user.email){
      httpHeaders = httpHeaders.append('Authorization', 'Basic ' + window.btoa(this.user.email + ':' + this.user.password));
    }
    //-- Read / Get the xsrf-token from the session storage
    let xsrf = sessionStorage.getItem('XSRF-TOKEN');
    //-- check whether xsrf is not null?
    if(xsrf) {
      httpHeaders = httpHeaders.append('X-XSRF-TOKEN',xsrf);
    }
    //-- appending the httpHeaders with x-requested-with and xmlhttpRequest
    httpHeaders = httpHeaders.append('X-Requested-With', 'XMLHttpRequest');
    //-- cloning the httpHeader object into the xhr constant
    const xhr = req.clone({ headers: httpHeaders });
  //-- requestHandler handling the newly cloned HttpHeader
  return next.handle(xhr).pipe(tap(
      (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status !== 401) {
            return;
          }
          this.router.navigate(['dashboard']);
        }
      }));
  }
}
