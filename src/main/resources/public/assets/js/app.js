(function () {
    var app = angular.module('fizzbuzz', []);

    app.controller('GameController', ['$http', function ($http) {
        this.resultItem = {};
        this.inputItem = "";

        var game = this;

        this.submit = function () {
            game.resultItem = {};

            $http.get('/submit?input=' + game.inputItem).then(successCallback, errorCallback);

            function successCallback(response) {
                game.resultItem = response.data;
            }

            function errorCallback(error) {
                //error code
                console.error(error);
            }
        };
    }]);
})();
