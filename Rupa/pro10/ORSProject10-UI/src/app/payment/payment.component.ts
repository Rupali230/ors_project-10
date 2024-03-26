import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  form: any = {

  }
  inputerror: any = {

  }

  constructor(private http: HttpClient,private route: ActivatedRoute) { }

  ngOnInit() {

    this.getId();
    if (this.form.id && this.form.id > 0) {
      this.display();


    }
  }

  save() {

    this.http.post('http://localhost:8080/payment/add', this.form).subscribe((res: any) => {

      if (res.result.message) {
        this.form.message = res.result.message;
       
      }if (res.success) {
          this.form.data = res.result.data;
      }
       if (res.result.inputerror) {
        this.inputerror = res.result.inputerror;

      }
      if (res.result.data) {
        this.form.id = res.result.data;
    }

    })   

}

getId(): void {
  var self = this;

  self.form.id = this.route.snapshot.params['id'];
  console.log('ID:', this.form.id);

  this.route.params.subscribe(params => {
    this.form.id = params['id'];

  });
}
display() {
  var self = this;

  this.http.get('http://localhost:8080/payment/get/' + this.form.id).subscribe((res: any) => {
    self.form.id=0;
    self.form = res.result.data;
   
    
   

  })
}

}