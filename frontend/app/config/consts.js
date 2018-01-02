angular.module('financialGuideFrontApp').constant('consts', {
  appName: 'Financial guide App',
  apiUrl: 'http://localhost:8085/api/v1',
}).run(['$rootScope', 'consts', function($rootScope, consts) {
  $rootScope.consts = consts
}])
