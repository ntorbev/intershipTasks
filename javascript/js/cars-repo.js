/**
 * CarsRepo represents a repository of cars. It is implemented by first initializing
 * an initial array of cars via the constructor and then appending the functionality to:
 * addNewCar and removeCar attached to CarsRepo's prototype.
 * @constructor
 * @param {Array} initialListOfCars - an array filled with Car objects to be included
 *      during initialization of a new CarsRepo.
 */
var CarsRepo = function (initialListOfCars) {
    this.cars = initialListOfCars;
};

/**
 * This function adds a new car to CarsRepo's cars.
 * @param {Car} newCar - an object of type Car to be added to CarsRepo's cars
 */
CarsRepo.prototype.addNewCar = function (newCar) {
    this.cars.push(newCar);
};

/**
 * This function removes a car from CarsRepo's cars.
 * @param {Car} carToBeRemoved - an object of type Car that is to be removed from
 *      CarsRepo's cars.
 */
CarsRepo.prototype.removeCar = function (carToBeRemoved) {
    var indexOfCar = this.cars.indexOf(carToBeRemoved);
    if (indexOfCar > -1) {
        this.cars.splice(indexOfCar, 1);
    }
};

/**
 * This function edits a car from CarsRepo's cars.
 * @param {indexOfCarToEdit} - the index of the car that is supposed to be edited
 * @param {Car} carToBeRemoved - an object of type Car that will replace the car
 * at the given index
 */
CarsRepo.prototype.editCar = function (indexOfCarToEdit, editedCar) {
    if (indexOfCarToEdit > -1 && this.cars[indexOfCarToEdit] !== undefined) {
        this.cars[indexOfCarToEdit] = editedCar;
    }
};