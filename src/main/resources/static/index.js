angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.loadPage = function (page) {
            $http({
                url: contextPath + '/api/v1/products',
                method: 'GET',
                params: {
                    p: page
                }
            }).then(function (response) {
                $scope.productsPage = response.data;

                let minPageIndex = page - 2;
                if (minPageIndex < 1) {
                    minPageIndex = 1;
                }

                let maxPageIndex = page + 2;
                if (maxPageIndex > $scope.productsPage.totalPages) {
                    maxPageIndex = $scope.productsPage.totalPages;
                }

                $scope.paginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);

                console.log("PAGE FROM BACKEND")
                console.log($scope.productsPage);
            });
        };

    $scope.createNewProduct = function () {
        $http.post(contextPath + '/api/v1/products', $scope.newProduct)
            .then(function successCallback(response) {
                $scope.loadPage(1);
                $scope.newProduct = null;
            }, function errorCallback(response) {
                console.log(response.data);
                alert('Error: ' + response.data.messages);
            });
    };

    $scope.clickOnProduct = function (product) {
        console.log(product);
    }
    $scope.pingProduct = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/ping',
            method: 'GET',
            params: {
                id: productId,
                temp: 'empty'
            }
        }).then(function (response) {
            console.log("OK");
        });
    }
    $scope.getCartItems = function () {
                $http.get(contextPath + '/api/v1/cart')
                    .then(function (response) {
                        $scope.outCart = response.data;
                    });
            };


    $scope.addItemToCart = function (productId){
        $http({
        url: contextPath + '/api/v1/cart/addItem/',
                    method: 'GET',
                    params: {
                        id: productId
                    }
        }).then(function successCallback(response) {
                    $scope.getCartItems();
                }, function errorCallback(response) {
                    console.log(response.data);
                    alert('Error: ' + response.data.messages);
                });
          };

    $scope.deleteAllItems = function(){
    $http.get(contextPath + '/api/v1/cart/deleteAllItems')
                    .then(function (response) {
                       $scope.getCartItems();
                    });
            };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadPage(1);
});