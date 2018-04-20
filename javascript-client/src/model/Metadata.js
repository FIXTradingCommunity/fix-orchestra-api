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
* The Metadata model module.
* @module model/Metadata
* @version 1.0.1
*/
export default class Metadata {
    /**
    * Constructs a new <code>Metadata</code>.
    * description of an Orchestra repository, conforms to Dublin Core Terms
    * @alias module:model/Metadata
    * @class
    * @param identifier {String} unique ID of an Orchestra repository
    */

    constructor(identifier) {
        

        
        

        this['identifier'] = identifier;

        
    }

    /**
    * Constructs a <code>Metadata</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Metadata} obj Optional instance to populate.
    * @return {module:model/Metadata} The populated <code>Metadata</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Metadata();

            
            
            

            if (data.hasOwnProperty('identifier')) {
                obj['identifier'] = ApiClient.convertToType(data['identifier'], 'String');
            }
            if (data.hasOwnProperty('contributor')) {
                obj['contributor'] = ApiClient.convertToType(data['contributor'], 'String');
            }
            if (data.hasOwnProperty('coverage')) {
                obj['coverage'] = ApiClient.convertToType(data['coverage'], 'String');
            }
            if (data.hasOwnProperty('creator')) {
                obj['creator'] = ApiClient.convertToType(data['creator'], 'String');
            }
            if (data.hasOwnProperty('date')) {
                obj['date'] = ApiClient.convertToType(data['date'], 'Date');
            }
            if (data.hasOwnProperty('description')) {
                obj['description'] = ApiClient.convertToType(data['description'], 'String');
            }
            if (data.hasOwnProperty('format')) {
                obj['format'] = ApiClient.convertToType(data['format'], 'String');
            }
            if (data.hasOwnProperty('language')) {
                obj['language'] = ApiClient.convertToType(data['language'], 'String');
            }
            if (data.hasOwnProperty('relation')) {
                obj['relation'] = ApiClient.convertToType(data['relation'], 'String');
            }
            if (data.hasOwnProperty('rights')) {
                obj['rights'] = ApiClient.convertToType(data['rights'], 'String');
            }
            if (data.hasOwnProperty('publisher')) {
                obj['publisher'] = ApiClient.convertToType(data['publisher'], 'String');
            }
            if (data.hasOwnProperty('source')) {
                obj['source'] = ApiClient.convertToType(data['source'], 'String');
            }
            if (data.hasOwnProperty('subject')) {
                obj['subject'] = ApiClient.convertToType(data['subject'], 'String');
            }
            if (data.hasOwnProperty('title')) {
                obj['title'] = ApiClient.convertToType(data['title'], 'String');
            }
            if (data.hasOwnProperty('type')) {
                obj['type'] = ApiClient.convertToType(data['type'], 'String');
            }
        }
        return obj;
    }

    /**
    * unique ID of an Orchestra repository
    * @member {String} identifier
    */
    identifier = undefined;
    /**
    * @member {String} contributor
    */
    contributor = undefined;
    /**
    * a FIX category or guideline
    * @member {String} coverage
    */
    coverage = undefined;
    /**
    * @member {String} creator
    */
    creator = undefined;
    /**
    * when the file was produced
    * @member {Date} date
    */
    date = undefined;
    /**
    * a summary
    * @member {String} description
    */
    description = undefined;
    /**
    * file format
    * @member {String} format
    */
    format = undefined;
    /**
    * @member {String} language
    */
    language = undefined;
    /**
    * a related resource
    * @member {String} relation
    */
    relation = undefined;
    /**
    * @member {String} rights
    */
    rights = undefined;
    /**
    * @member {String} publisher
    */
    publisher = undefined;
    /**
    * a resource from which this one was derived
    * @member {String} source
    */
    source = undefined;
    /**
    * @member {String} subject
    */
    subject = undefined;
    /**
    * @member {String} title
    */
    title = undefined;
    /**
    * @member {String} type
    */
    type = undefined;








}


