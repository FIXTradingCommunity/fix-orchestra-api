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
import MessageRef from './MessageRef';
import Trigger from './Trigger';





/**
* The Response model module.
* @module model/Response
* @version 1.0.0
*/
export default class Response {
    /**
    * Constructs a new <code>Response</code>.
    * @alias module:model/Response
    * @class
    * @param name {String} 
    */

    constructor(name) {
        

        
        

        this['name'] = name;

        
    }

    /**
    * Constructs a <code>Response</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Response} obj Optional instance to populate.
    * @return {module:model/Response} The populated <code>Response</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Response();

            
            
            

            if (data.hasOwnProperty('name')) {
                obj['name'] = ApiClient.convertToType(data['name'], 'String');
            }
            if (data.hasOwnProperty('when')) {
                obj['when'] = ApiClient.convertToType(data['when'], 'String');
            }
            if (data.hasOwnProperty('messageRef')) {
                obj['messageRef'] = MessageRef.constructFromObject(data['messageRef']);
            }
            if (data.hasOwnProperty('assign')) {
                obj['assign'] = ApiClient.convertToType(data['assign'], 'String');
            }
            if (data.hasOwnProperty('trigger')) {
                obj['trigger'] = Trigger.constructFromObject(data['trigger']);
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
    * conditional expression; if not present, then response is unconditional
    * @member {String} when
    */
    when = undefined;
    /**
    * send a response message
    * @member {module:model/MessageRef} messageRef
    */
    messageRef = undefined;
    /**
    * assignment expression
    * @member {String} assign
    */
    assign = undefined;
    /**
    * @member {module:model/Trigger} trigger
    */
    trigger = undefined;
    /**
    * @member {module:model/Annotation} annotation
    */
    annotation = undefined;








}

