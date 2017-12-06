/**
 * Orchestra API
 * API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
 *
 * OpenAPI spec version: 1.0.0
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
    instance = new OrchestraApi.Code();
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

  describe('Code', function() {
    it('should create an instance of Code', function() {
      // uncomment below and update the code to test Code
      //var instane = new OrchestraApi.Code();
      //expect(instance).to.be.a(OrchestraApi.Code);
    });

    it('should have the property oid (base name: "oid")', function() {
      // uncomment below and update the code to test the property oid
      //var instane = new OrchestraApi.Code();
      //expect(instance).to.be();
    });

    it('should have the property value (base name: "value")', function() {
      // uncomment below and update the code to test the property value
      //var instane = new OrchestraApi.Code();
      //expect(instance).to.be();
    });

    it('should have the property annotation (base name: "annotation")', function() {
      // uncomment below and update the code to test the property annotation
      //var instane = new OrchestraApi.Code();
      //expect(instance).to.be();
    });

    it('should have the property entityAttributes (base name: "entityAttributes")', function() {
      // uncomment below and update the code to test the property entityAttributes
      //var instane = new OrchestraApi.Code();
      //expect(instance).to.be();
    });

  });

}));
