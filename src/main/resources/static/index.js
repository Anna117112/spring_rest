angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8289/app';

    // console.log(123);

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                // console.log(response.data)
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

     $scope.createProductJson = function () {
            console.log($scope.newProductJson);
            $http.post(contextPath + '/products', $scope.newProductJson)
                .then(function (response) {
                    $scope.loadProducts();
                });
        }
          $scope.loadProducts();
        });

