import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleModule } from './vehicle/vehicle.module';

const routes: Routes = [
  {path:'',redirectTo:'/vehicles',pathMatch:'full'},
  { path: 'vehicles', loadChildren: () => import('./vehicle/vehicle.module').then(m => m.VehicleModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
