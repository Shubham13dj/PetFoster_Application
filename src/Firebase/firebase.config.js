// Import the functions you need from the Firebase SDKs
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";

// Your Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyA6sRRbdSJPY0Popt2anxBD8uq7GS62cOM",
  authDomain: "pet-foster-8c209.firebaseapp.com",
  projectId: "pet-foster-8c209",
  storageBucket: "pet-foster-8c209.appspot.com", // Fixed typo here
  messagingSenderId: "262364311501",
  appId: "1:262364311501:web:e5e9804a898d25de8b9e84",
  measurementId: "G-4XLZGX0XW1"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

export { app, analytics }; // Correctly export Firebase app
