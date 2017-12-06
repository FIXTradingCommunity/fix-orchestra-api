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





/**
* The Flow model module.
* @module model/Flow
* @version 1.0.0
*/
export default class Flow {
    /**
    * Constructs a new <code>Flow</code>.
    * A stream of messages in one direction
    * @alias module:model/Flow
    * @class
    * @param name {String} unique flow name
    * @param source {String} Name of the actor that originates messages
    * @param destination {String} Name of the actor that receives messages
    */

    constructor(name, source, destination) {
        

        
        

        this['name'] = name;this['source'] = source;this['destination'] = destination;

        
    }

    /**
    * Constructs a <code>Flow</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Flow} obj Optional instance to populate.
    * @return {module:model/Flow} The populated <code>Flow</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Flow();

            
            
            

            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('source')) {
                obj['source'] = ApiClient.convertToType(data['source'], 'String');
            }
            if (data.hasOwnProperty('destination')) {
                obj['destination'] = ApiClient.convertToType(data['destination'], 'String');
            }
            if (data.hasOwnProperty('annotation')) {
                obj['annotation'] = Annotation.constructFromObject(data['annotation']);
            }
        }
        return obj;
    }

    /**
    * unique flow name
    * @member {String} name
    */
    name = undefined;
    /**
    * Name of the actor that originates messages
    * @member {String} source
    */
    source = undefined;
    /**
    * Name of the actor that receives messages
    * @member {String} destination
    */
    destination = undefined;
    /**
    * @member {module:model/Annotation} annotation
    */
    annotation = undefined;








}


