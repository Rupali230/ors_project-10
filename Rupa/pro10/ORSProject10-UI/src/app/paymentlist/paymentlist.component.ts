import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-paymentlist',
  templateUrl: './paymentlist.component.html',
  styleUrls: ['./paymentlist.component.css']
})
export class PaymentlistComponent implements OnInit {

  form: any = {
    searchParam: {},
    pageNo: 0,
    preload: []
  }
  nextList = 0;

  selectedIds: any = []

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.search();
    // this.preload();
  }

  // preload() {
  //   console.log("preload start")
  //   var self = this;
  //   this.http.get('http://localhost:8080/payment/preload').subscribe((res: any) => {
  //     self.form.preload = res.result;
  //   })
  // }

  search() {
    console.log('in search')
    var self = this;

    this.http.post('http://localhost:8080/payment/search/' + this.form.pageNo, this.form.searchParam).subscribe((res: any) => {

      self.form.list = res.result.data;
      this.nextList = res.result.nextList;


    })
  }


  forward(page) {
    this.router.navigateByUrl(page)
      ;

  }
  delete(id: any) {

    var self = this
    this.selectedIds.push(id)

    this.http.post('http://localhost:8080/payment/delete/' + this.selectedIds, self.form).subscribe((res: any) => {

      this.form.message = res.result.message
      console.log('message ', this.form.message)


      location.reload();
    })
  }

  next() {
    this.form.pageNo++;
    this.search();
  }

  previous() {
    this.form.pageNo--;
    this.search();
  }
}






