import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleService } from './vehicle.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [ 
  { path: '', component: VehicleListComponent },
  { path: 'add', component: VehicleDetailsComponent },
  { path: 'edit/:id', component: VehicleDetailsComponent }
];


@NgModule({
  declarations: [
    VehicleDetailsComponent,
    VehicleListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  providers: [VehicleService]
})
export class VehicleModule { }
