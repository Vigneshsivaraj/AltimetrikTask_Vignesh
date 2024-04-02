import { Component, OnInit } from '@angular/core'; 
import { VehicleService } from '../vehicle.service';
import { Vehicle } from '../model/vehicle';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrl: './vehicle-list.component.css'
})
export class VehicleListComponent {
  vehicles!: Vehicle[];
  searchQuery: string = '';
  filteredVehicles: Vehicle[] = [];

  constructor(private vehicleService: VehicleService) {}

  ngOnInit() {
      this.vehicleService.getAll() 
          .subscribe(vehicles => this.vehicles = vehicles);
  }

  deleteVehicle(id: string) {
      const vehicle = this.vehicles.find(x => x.id === id);
      if (!vehicle) return;
      vehicle.isDeleting = true;
      this.vehicleService.delete(id) 
          .subscribe(() => this.vehicles = this.vehicles.filter(x => x.id !== id));
  }
  
  loadVehicles() {
    //to load all vehciles
    this.vehicleService.getAll().subscribe(vehicles => {
      this.vehicles = vehicles; 
    });
  } 

  filterVehicles(searchQuery: any) { 
    //filter the vehicle records based on search text
    this.searchQuery = searchQuery.target.value 
    this.vehicleService.getAll().subscribe(vehicles => { 
      this.vehicles = vehicles.filter(vehicle =>
        vehicle.make.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
        vehicle.model.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
        vehicle.year.toString().includes(this.searchQuery.toLowerCase()) ||
        vehicle.vin.toLowerCase().includes(this.searchQuery.toLowerCase())
      );      });
  }
}
