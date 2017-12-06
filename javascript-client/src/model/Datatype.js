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





/**
* The Datatype model module.
* @module model/Datatype
* @version 1.0.0
*/
export default class Datatype {
    /**
    * Constructs a new <code>Datatype</code>.
    * @alias module:model/Datatype
    * @class
    * @param name {String} 
    */

    constructor(name) {
        

        
        

        this['name'] = name;

        
    }

    /**
    * Constructs a <code>Datatype</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Datatype} obj Optional instance to populate.
    * @return {module:model/Datatype} The populated <code>Datatype</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Datatype();

            
            
            

            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('baseType')) {
                obj['baseType'] = ApiClient.convertToType(data['baseType'], 'String');
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
    * @member {String} name
    */
    name = undefined;
    /**
    * @member {String} baseType
    */
    baseType = undefined;
    /**
    * @member {module:model/Annotation} annotation
    */
    annotation = undefined;
    /**
    * @member {module:model/EntityAttributes} entityAttributes
    */
    entityAttributes = undefined;








}

