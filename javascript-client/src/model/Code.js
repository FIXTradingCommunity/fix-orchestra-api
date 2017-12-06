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


import ApiClient from '../ApiClient';
import Annotation from './Annotation';
import EntityAttributes from './EntityAttributes';
import ObjectId from './ObjectId';





/**
* The Code model module.
* @module model/Code
* @version 1.0.0
*/
export default class Code {
    /**
    * Constructs a new <code>Code</code>.
    * @alias module:model/Code
    * @class
    * @param oid {module:model/ObjectId} 
    * @param value {String} 
    */

    constructor(oid, value) {
        

        
        

        this['oid'] = oid;this['value'] = value;

        
    }

    /**
    * Constructs a <code>Code</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Code} obj Optional instance to populate.
    * @return {module:model/Code} The populated <code>Code</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Code();

            
            
            

            if (data.hasOwnProperty('oid')) {
                obj['oid'] = ObjectId.constructFromObject(data['oid']);
            }
            if (data.hasOwnProperty('value')) {
                obj['value'] = ApiClient.convertToType(data['value'], 'String');
            }
            if (data.hasOwnProperty('annotation')) {
                obj['annotation'] = Annotation.constructFromObject(data['annotation']);
            }
            if (data.hasOwnProperty('entityAttributes')) {
                obj['entityAttributes'] = EntityAttributes.constructFromObject(data['entityAttributes']);
            }
        }
        return obj;
    }

    /**
    * @member {module:model/ObjectId} oid
    */
    oid = undefined;
    /**
    * @member {String} value
    */
    value = undefined;
    /**
    * @member {module:model/Annotation} annotation
    */
    annotation = undefined;
    /**
    * @member {module:model/EntityAttributes} entityAttributes
    */
    entityAttributes = undefined;








}

