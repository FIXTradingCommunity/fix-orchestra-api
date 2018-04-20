/**
 * Orchestra API
 * API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.OrchestraApi);
  }
}(this, function(expect, OrchestraApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new OrchestraApi.StateMachine();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('StateMachine', function() {
    it('should create an instance of StateMachine', function() {
      // uncomment below and update the code to test StateMachine
      //var instane = new OrchestraApi.StateMachine();
      //expect(instance).to.be.a(OrchestraApi.StateMachine);
    });

    it('should have the property name (base name: "name")', function() {
      // uncomment below and update the code to test the property name
      //var instane = new OrchestraApi.StateMachine();
      //expect(instance).to.be();
    });

    it('should have the property initial (base name: "initial")', function() {
      // uncomment below and update the code to test the property initial
      //var instane = new OrchestraApi.StateMachine();
      //expect(instance).to.be();
    });

    it('should have the property states (base name: "states")', function() {
      // uncomment below and update the code to test the property states
      //var instane = new OrchestraApi.StateMachine();
      //expect(instance).to.be();
    });

    it('should have the property annotation (base name: "annotation")', function() {
      // uncomment below and update the code to test the property annotation
      //var instane = new OrchestraApi.StateMachine();
      //expect(instance).to.be();
    });

  });

}));
