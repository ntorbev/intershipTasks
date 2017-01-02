(function () {
    var mockCarService = new MockCarService(),
        initialCars = mockCarService.getCars(),
        displaySubmitButton = true,
        repo = new CarsRepo(initialCars),
        carsList,
        options = {valueNames: ['model', 'year', 'color']},
        models,
        years,
        colors,
        $editCarButton,
        $cancelButton;

    update();

    function update() {
        writeTable();
        filterModels();
        filterYears();
        filterColors();
        initializeCarsList();
    }

    function writeTable() {
        let tableBody = $('.list');
        // tableBody.empty();

        for (let i in repo.cars) {
            let tr = $('<tr/>').appendTo(tableBody);
            tr.append(`<td class="model">${repo.cars[i].model}</td>`);
            tr.append(`<td class="year">${repo.cars[i].year }</td>`);
            tr.append(`<td class="color">${ repo.cars[i].color }</td>`);
            tr.append(`<td><button type="button" class="editCarButtons" data-id="${i}">Edit</button></td>`);
            tr.append(`<td><button type="button" class="removeCarButtons" data-id="${i}">Remove</button></td>`);
        }
    }

    function filterModels() {
        clearModels();
        populateModels();
    }

    function filterYears() {
        clearYears();
        populateYears();
    }

    function filterColors() {
        clearColors();
        populateColors();
    }

    function initializeCarsList() {
        carsList = new List('carsDiv', options);
    }

    function clearModels() {
        $('#modelsSelect').empty();
        models = [];
    }

    function populateModels() {
        for (let i in repo.cars) {
            if (models.indexOf(repo.cars[i].model) === -1) {
                models.push(repo.cars[i].model);
                $('#modelsSelect').append('<option value="' + repo.cars[i].model + '">' + repo.cars[i].model + '</option>');
            }
        }
    }

    function clearYears() {
        $('#yearsSelect').empty();
        years = [];
    }

    function populateYears() {
        for (let i in repo.cars) {
            if (years.indexOf(repo.cars[i].year) === -1) {
                years.push(repo.cars[i].year);
                $('#yearsSelect').append('<option value="' + repo.cars[i].year + '">' + repo.cars[i].year + '</option>');
            }
        }
    }

    function clearColors() {
        $('#colorsSelect').empty();
        colors = [];
    }

    function populateColors() {
        for (let i in repo.cars) {
            if (colors.indexOf(repo.cars[i].color) === -1) {
                colors.push(repo.cars[i].color);
                $('#colorsSelect').append('<option value="' + repo.cars[i].color + '">' + repo.cars[i].color + '</option>');
            }
        }
    }

    $editCarButton = $('<br><input type="button" id="edit" data-id="" value="Edit"/>');
    $cancelButton = $('<input type="button" id="cancel" value="Cancel"/>');
    $editCarButton.insertAfter("#createCarButton").hide();
    $cancelButton.insertAfter("#edit").hide();

    if (document.addEventListener) {
        document.addEventListener("click", handleClick, false);
    } else if (document.attachEvent) {
        document.attachEvent("onclick", handleClick);
    }

    function handleClick(event) {
        event.preventDefault();
        event = event || window.event;
        event.target = event.target || event.srcElement;

        var element = event.target;

        while (element) {
            if (element.nodeName === "BUTTON") {
                if (/removeCarButtons/.test(element.className)) {
                    removeCarFromRepo(element);
                    break;
                } else if (/editCarButtons/.test(element.className)) {
                    editCarInRepo(element);
                    break;
                }
            }
            element = element.parentNode;
        }
    }

    function removeCarFromRepo(button) {
        var carId = $(button).attr('data-id');
        var carToBeRemoved = repo.cars[carId];

        if (confirm("Are you sure you want to remove [" + carToBeRemoved.model + "]") == true) {
            repo.removeCar(carToBeRemoved);
            clearInputFields();
            update();
        }
    }

    function editCarInRepo(button) {
        var carId = $(button).attr('data-id');
        var carToEdit = repo.cars[carId];
        $('#model').val(carToEdit.model);
        $('#year').val(carToEdit.year);
        $('#color').val(carToEdit.color);
        if (displaySubmitButton === true) {
            toggleInputButtons();
            displaySubmitButton = false;
        }

        $('#edit').attr('data-id', carId);
        update();
    }

    function toggleInputButtons() {
        $('#createCarButton').toggle();
        $('#edit').toggle();
        $('#cancel').toggle();
    }

    function clearInputFields() {
        $('#model').val("");
        $('#year').val("");
        $('#color').val("");
    }

    document.getElementById("createCarButton").addEventListener("click", function (event) {
        event.preventDefault();
        var newCar = new Car($('#model').val(), $('#year').val(), $('#color').val());
        repo.addNewCar(newCar);
        update();
        clearInputFields();
    });

    document.getElementById("filter-by-model-btn").addEventListener("click", function (event) {
        event.preventDefault();
        update();
        carsList.search($('input[name=modelSelect]').val(), ['model']);
    });
    document.getElementById("filter-by-year-btn").addEventListener("click", function (event) {
        event.preventDefault();
        update();
        carsList.search($('input[name=yearSelect]').val(), ['year']);
    });
    document.getElementById("filter-by-color-btn").addEventListener("click", function (event) {
        event.preventDefault();
        update();
        carsList.search($('input[name=colorSelect]').val(), ['color']);
    });

    document.getElementById("edit").addEventListener("click", function (event) {
        event.preventDefault();
        carId = $(this).attr('data-id');
        var newCar = new Car($('#model').val(), $('#year').val(), $('#color').val());
        repo.editCar(carId, newCar);
        if (displaySubmitButton === false) {
            toggleInputButtons();
            displaySubmitButton = true;
        }
        clearInputFields();
        update();
    });

    document.getElementById("cancel").addEventListener("click", function (event) {
        event.preventDefault();
        clearInputFields();
        if (displaySubmitButton === false) {
            toggleInputButtons();
            displaySubmitButton = true;
        }

    });
}());



