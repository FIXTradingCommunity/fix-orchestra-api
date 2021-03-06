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
import Annotation from './Annotation';





/**
* The Transition model module.
* @module model/Transition
* @version 1.0.1
*/
export default class Transition {
    /**
    * Constructs a new <code>Transition</code>.
    * @alias module:model/Transition
    * @class
    */

    constructor() {
        

        
        

        

        
    }

    /**
    * Constructs a <code>Transition</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Transition} obj Optional instance to populate.
    * @return {module:model/Transition} The populated <code>Transition</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Transition();

            
            
            

            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('when')) {
                obj['when'] = ApiClient.convertToType(data['when'], 'String');
            }
            if (data.hasOwnProperty('target')) {
                obj['target'] = ApiClient.convertToType(data['target'], 'String');
            }
            if (data.hasOwnProperty('annotation')) {
                obj['annotation'] = Annotation.constructFromObject(data['annotation']);
            }
        }
        return obj;
    }

    /**
    * @member {String} name
    */
    name = undefined;
    /**
    * Optional guard condition
    * @member {String} when
    */
    when = undefined;
    /**
    * name of the target state
    * @member {String} target
    */
    target = undefined;
    /**
    * @member {module:model/Annotation} annotation
    */
    annotation = undefined;








}


