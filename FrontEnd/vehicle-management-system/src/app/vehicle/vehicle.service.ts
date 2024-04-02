import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 
import { Vehicle } from './model/vehicle';
const baseUrl = `http://localhost:8081/api/vms`;

@Injectable({ providedIn: 'root' })
export class VehicleService {  
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Vehicle[]>(baseUrl);
    }

    getById(id: string) {
        return this.http.get<Vehicle>(`${baseUrl}/${id}`);
    }

    create(vehicle: Vehicle) {
        return this.http.post(baseUrl, vehicle);
    }

    update(id: string, vehicle: Vehicle) {
        return this.http.put(`${baseUrl}/${id}`, vehicle);
    }

    delete(id: string) {
        return this.http.delete(`${baseUrl}/${id}`);
    }
}
