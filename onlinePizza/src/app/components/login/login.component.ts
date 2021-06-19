import { Component,  OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/login';
import { LoginService } from 'src/app/services/login.service';
declare var toastr: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private LoginService:LoginService) { }
  login : Login=new Login();
  submitted = false;
  //username:String;
  ngOnInit() {
    if(this.submitted==false){
      this.router.navigate(['login']);
    }else{
      toastr.warning('','Already ur loggedIN')
    }
  }

  usersaveform=new FormGroup({
    userName:new FormControl('' , [Validators.required , Validators.maxLength(10),Validators.minLength(0) ] ),
    password:new FormControl('',[Validators.required])
  });

  saveUser(saveUser){
    this.login=new Login();   
    this.login.userName=this.UserName.value;
    this.login.password=this.Password.value;
    this.submitted = true;
    this.save();
  }
   save() {
     if(this.login.userName=='admin' && this.login.password=='admin'){
      //this.username=this.login.userName;
      this.LoginService.username='admin';
      toastr.success("SuccessFully loggedIn");
      this.router.navigate(['view-pizza']);
     }else{
      this.LoginService.signin(this.login.userName,this.login.password)
      .subscribe((data) =>{
        console.log(data)
        toastr.success("SuccessFully loggedIn");
        this.router.navigate(['view-pizza']);
        //this.username=this.login.userName;
      } , error => {
          toastr.error("Invalid credentials");
      });
     }
    
  }

  get UserName(){
    return this.usersaveform.get('userName');
  }

  get Password(){
    return this.usersaveform.get('password');
  }

}
