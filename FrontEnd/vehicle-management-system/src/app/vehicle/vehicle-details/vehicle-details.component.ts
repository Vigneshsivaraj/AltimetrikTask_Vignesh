import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrl: './vehicle-details.component.css'
})
export class VehicleDetailsComponent {
  form!: FormGroup;
  id!: string;
  isAddMode!: boolean;
  loading = false;
  submitted = false;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private vehicleService: VehicleService
  ) {}

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];
      this.isAddMode = !this.id; 
      this.form = this.formBuilder.group({
          make: ['', Validators.required],
          model: ['', Validators.required],
          year: ['', Validators.required],
          vin: ['', Validators.required]
      });

      if (!this.isAddMode) {
          this.vehicleService.getById(this.id) 
              .subscribe(x => this.form.patchValue(x));
      }
  } 
  
  get f() { return this.form.controls; }

  onSubmit() {
      this.submitted = true;
 
      // stop here if form is invalid
      if (this.form.invalid) {
          return;
      }

      this.loading = true;
      if (this.isAddMode) {
          this.createVehicle();
      } else {
          this.updateVehicle();
      }
  }

  private createVehicle() {
      this.vehicleService.create(this.form.value)
          .pipe(first())
          .subscribe(() => {
              alert('Vehicle added');
              this.router.navigate(['../'], { relativeTo: this.route });
          })
          .add(() => this.loading = false);
  }

  private updateVehicle() {
      this.vehicleService.update(this.id, this.form.value)
          .pipe(first())
          .subscribe(() => {
             alert('Vehicle updated');
              this.router.navigate(['../../'], { relativeTo: this.route });
          })
          .add(() => this.loading = false);
  }
}
