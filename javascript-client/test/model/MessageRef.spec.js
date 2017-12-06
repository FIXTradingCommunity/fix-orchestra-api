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
    instance = new OrchestraApi.MessageRef();
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

  describe('MessageRef', function() {
    it('should create an instance of MessageRef', function() {
      // uncomment below and update the code to test MessageRef
      //var instane = new OrchestraApi.MessageRef();
      //expect(instance).to.be.a(OrchestraApi.MessageRef);
    });

    it('should have the property name (base name: "name")', function() {
      // uncomment below and update the code to test the property name
      //var instane = new OrchestraApi.MessageRef();
      //expect(instance).to.be();
    });

    it('should have the property msgType (base name: "msgType")', function() {
      // uncomment below and update the code to test the property msgType
      //var instane = new OrchestraApi.MessageRef();
      //expect(instance).to.be();
    });

    it('should have the property scenario (base name: "scenario")', function() {
      // uncomment below and update the code to test the property scenario
      //var instane = new OrchestraApi.MessageRef();
      //expect(instance).to.be();
    });

  });

}));
