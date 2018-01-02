angular.module('financialGuideFrontApp').component('content', {
    bindings: {
       name: '@',
       small: '@',
    },
    template: `
    <header class="main-header" ng-include="'/template/header.html'"></header>
    <aside class="main-sidebar" ng-include="'/template/menu.html'"></aside>
    <div  ></div>
    `
 });
 