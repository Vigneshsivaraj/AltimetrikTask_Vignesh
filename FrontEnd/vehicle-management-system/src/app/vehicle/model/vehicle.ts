export interface Vehicle {
    id: string;
    make: string;
    model: string;
    year: number;
    vin: string;
    isDeleting?: boolean;
}
