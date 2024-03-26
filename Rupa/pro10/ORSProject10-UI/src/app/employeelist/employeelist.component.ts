import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {

  form: any = {
    searchParam: {},
    pageNo: 0,
    nextlist:[]
  }

  selectedIds: any = []

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.search();
  }

  search() {
    console.log('in search')
    var self = this;

    this.http.post('http://localhost:8080/employee/search/' + this.form.pageNo, this.form.searchParam).subscribe((res: any) => {
      self.form.list = res.result.data;
      //self.form.nextlist= res.result.nextList;
      if (self.form.list == 0) {
        self.form.message = 'Record not found'

      }
    })
  }

  forward(page) {
    this.router.navigateByUrl(page)
      ;

  }
  delete(id: any) {

    var self = this
    this.selectedIds.push(id)

    this.http.post('http://localhost:8080/employee/delete/' + this.selectedIds, self.form).subscribe((res: any) => {

      this.form.message = res.result.message
      console.log('message ', this.form.message)


      location.reload();
    })


  }
}






