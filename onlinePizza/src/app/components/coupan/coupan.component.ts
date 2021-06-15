import { Component, OnInit } from '@angular/core';
import { Coupan } from 'src/app/coupan';
import { Observable, Subject } from 'rxjs';
import { CoupanService } from 'src/app/services/coupan.service';

@Component({
  selector: 'app-coupan',
  templateUrl: './coupan.component.html',
  styleUrls: ['./coupan.component.css']
})
export class CoupanComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  Coupans: Observable<Coupan[]>;
  Coupan : Coupan=new Coupan();
  deleteMessage=false;
  constructor(private CoupanService: CoupanService) { }

  ngOnInit() {
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };   
    this.CoupanService.getCoupan().subscribe(data =>{
    this.Coupans =data;
    this.dtTrigger.next();
    })
  }
  delete(id: number) {
    this.CoupanService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.CoupanService.getCoupan().subscribe(data =>{
            this.Coupans =data
            })
        },
        error => console.log(error));
  }

}
