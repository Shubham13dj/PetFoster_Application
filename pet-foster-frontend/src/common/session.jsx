// sessionUtils.js

// Function to store data in sessionStorage
export const storeInSession = (key, value) => {
    if (key && value) {
        // Ensure the key and value are not null/undefined
        sessionStorage.setItem(key, JSON.stringify(value));
        console.log(`Data stored in session: ${key}`);
    } else {
        console.error("Invalid key or value for session storage");
    }
};

// Function to retrieve data from sessionStorage
export const lookInSession = (key) => {
    const data = sessionStorage.getItem(key);
    if (data) {
        // Parse the data from JSON string back into an object or value
        return JSON.parse(data);
    } else {
        console.warn(`No data found for key: ${key}`);
        return null; // Return null if the data doesn't exist
    }
};

// Function to remove data from sessionStorage
export const removeFromSession = (key) => {
    if (key) {
        sessionStorage.removeItem(key);
        console.log(`Data removed from session: ${key}`);
    } else {
        console.error("Invalid key for session removal");
    }
};