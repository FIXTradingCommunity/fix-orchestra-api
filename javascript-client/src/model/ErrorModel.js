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


import ApiClient from '../ApiClient';





/**
* The ErrorModel model module.
* @module model/ErrorModel
* @version 1.0.1
*/
export default class ErrorModel {
    /**
    * Constructs a new <code>ErrorModel</code>.
    * @alias module:model/ErrorModel
    * @class
    * @param code {Number} 
    * @param message {String} 
    */

    constructor(code, message) {
        

        
        

        this['code'] = code;this['message'] = message;

        
    }

    /**
    * Constructs a <code>ErrorModel</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/ErrorModel} obj Optional instance to populate.
    * @return {module:model/ErrorModel} The populated <code>ErrorModel</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new ErrorModel();

            
            
            

            if (data.hasOwnProperty('code')) {
                obj['code'] = ApiClient.convertToType(data['code'], 'Number');
            }
            if (data.hasOwnProperty('message')) {
                obj['message'] = ApiClient.convertToType(data['message'], 'String');
            }
        }
        return obj;
    }

    /**
    * @member {Number} code
    */
    code = undefined;
    /**
    * @member {String} message
    */
    message = undefined;








}


