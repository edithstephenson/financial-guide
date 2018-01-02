angular.module("financialGuideFrontApp").config([
  "$stateProvider",
  "$urlRouterProvider",  
  function($stateProvider, $urlRouterProvider) {

    $stateProvider.state("login", {
      url: "/login",
      templateUrl: "login/login.html"
    }).state("app", {
      url: "/guide",
      template:      
      "<header class=\"main-header\" ng-include=\"'/template/header.html\'\"></header>"+
      "<aside class=\"main-sidebar\" ng-include=\"'/template/menu.html'\"></aside>"+
      "<div class=\"content-wrapper\">"+
        "<div ui-view></div>"+
      "</div>"
    }).state("app.billingCycle", {
      url: "/billing/cycles",
      templateUrl: "billing/customerCash.html"
    }).state('customers', {
      url: "/customers",
      templateUrl: "customers/customers.html"
    });

    $urlRouterProvider.otherwise("/login");
}])


