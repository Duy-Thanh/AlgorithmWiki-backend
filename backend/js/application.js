/**
 * application.js - JavaScript file to communicate with backend of this application
 * 
 * Copyright (C) 2024 CyberDay Studios. All right reserved
 */

/**
 * Here is the server configurations
 * 
 * Please adjust them with your server system
 */
var serverName = "127.0.0.1";
var portServer = "8080";

/**
 * Actually code here. DO NOT EDIT
 */
const fullServer = `http://${serverName}:${portServer}`;

//
// PRIVATE FUNCTION SECTION
// DO NOT USE. USE PUBLIC FUNCTION SECTION IN YOUR HTML INSTEAD
//

/**
 * Make 'GET' request
 */
async function getRequest(endpoint, queryParams = {}) {
    try {
        // Construct URL with query parameters if queryParams is provided
        let url_request = `${fullServer}${endpoint}`;
        if (Object.keys(queryParams).length > 0) {
            const url = new URL(url_request);
            Object.keys(queryParams).forEach(key => url.searchParams.append(key, queryParams[key]));
            url_request = url.toString();
        }

        const response = await fetch(url_request);

        if (!response || !response.ok) {
            throw new Error('Network response was not ok');
        }

        return await response.json();
    } catch (error) {
        console.error(`Error: ${error}`);
    }
}
// ===================================
// END PRIVATE FUNCTION SECTION
// ===================================

// PUBLIC FUNCTION SECTION
// USE THESE FUNCTIONS FROM HERE!!!

/**
 * API_index() - Check the API if API is working
 * 
 * @param None
 * @description Check the API if API is working or not
 * 
 * @return Boolean: True if API is working; False if API isn't working
 */

const API_index = async () => {
    const endpoint = "/api";

    try {
        const responseData = await getRequest(endpoint);

        if (responseData == null) {
            throw new Error("Backend cannot be reached: null of response");
        } else {
            console.log("API endpoint reached.");
            const { message, value, statusCode } = responseData;

            if (message == "status" && value == "working" && statusCode == "200") {
                console.log("API endpoint reached successfully");
                return true;
            } else {
                throw new Error("API endpoint reached with error: ", responseData);
            }
        }
    } catch (error) {
        console.error(`Error: ${error}`);
        return false;
    }
}

/**
 * API_status_non_details() - Show the server resources and server pressure that measured in simple form
 * 
 * @param None
 * @description Show the server resources measured in simple form
 * 
 * @return String: Return the server pressure state: 'minimal', 'normal', 'medium' and 'high'
 */
const API_status_non_details = async () => {
    const endpoint = "/api/status";

    try {
        const responseData = await getRequest(endpoint);

        if (responseData == null) {
            console.warn("Backend server have an occurred error and cannot be measured");
        } else {
            console.log("Backend server reached and server resources is measuread.");

            const { message, value, statusCode } = responseData;

            if (message == "server_pressure_status" && statusCode == "200") {
                if (value != null) {
                    console.log(`Server pressure status: ${value}`);
                    return value;
                } else {
                    console.error("Something went wrong when measuring backend server");

                    return "";
                }
            } else {
                console.error("Something went wrong. Response: ", responseData);

                return "";
            }
        }
    } catch (error) {
        console.error(`Error: ${error}`);

        return "";
    }
}

/**
 * API_status_with_details() - Show the server resources and server pressure that measured in advanced form
 * 
 * @param None
 * @description Show the server resources measured in advanced form
 * 
 * @return String: Return the server pressure state: 'minimal', 'normal', 'medium' and 'high'
 */
const API_status_with_details = async () => {
    const endpoint = "/api/status";
    const queryParams = { details: "true" };

    try {
        const responseData = await getRequest(endpoint, queryParams);

        if (responseData == null) {
            console.warn("Backend server have an occurred error and cannot be measured");
        } else {
            console.log("Backend server reached and server resources in details mode is measuread.");

            const { message, value, statusCode } = responseData;

            if (message == "server_pressure_status_details" && statusCode == "200") {
                if (value != null) {
                    console.log(`Server pressure details: ${value}`);
                    return value;
                } else {
                    console.error("Something went wrong when measuring backend server");

                    return "";
                }
            } else {
                console.error("Something went wrong. Response: ", responseData);

                return "";
            }
        }
    } catch (error) {
        console.error(`Error: ${error}`);

        return "";
    }
}

/**
 * API_status() - Show the server resources and server pressure that measured in advanced form
 * 
 * @param {boolean}: triggers return details server resources and server pressure
 *                           or not
 * @description Show the server resources measured in advanced form
 * 
 * @return {Promise<string>}: Return the server pressure state: 'minimal', 'normal', 'medium' and 'high'
 */

const API_status = async (details) => {
    if (!details) {
        API_status_non_details();
    } else {
        API_status_with_details();
    }
}
