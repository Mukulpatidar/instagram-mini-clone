import axios from "axios";

// 1️⃣ Axios instance
const api = axios.create({
  baseURL: "http://localhost:7777", // ✅ Spring Boot port
  headers: {
    "Content-Type": "application/json",
  },
});

// 2️⃣ Request Interceptor
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");

    // Agar token hai → Authorization header add karo
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default api;
