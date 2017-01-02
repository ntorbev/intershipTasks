var MockCarService = function () {
    this.arrayOfCars = [new Car("Nissan Infiniti G35", "2003", "black"),
        new Car("Hyundai Genesis", "2009", "red"),
        new Car("Honda Fit", "2002", "blue"),
        new Car("Ford Fusion", "2005", "grey"),
        new Car("Bentley Brooklands", "2008", "white"),
        new Car("Chevrolet Volt", "2011", "grey"),
        new Car("Bugatti Veyron", "2005", "black"),
        new Car("Ford GT", "2005", "red"),
        new Car("Dodge Viper", "2002", "red")];
};

MockCarService.prototype.getCars = function () {
    return this.arrayOfCars;
};