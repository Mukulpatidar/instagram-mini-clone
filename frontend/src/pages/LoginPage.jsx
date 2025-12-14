import { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";
import "./Auth.css";

function LoginPage() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const res = await api.post("/auth/login", form);
      localStorage.setItem("token", res.data);
      navigate("/");
    } catch {
      alert("Invalid credentials");
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-box">
        <div className="auth-logo">Instagram</div>

        <form onSubmit={handleLogin}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Password"
            onChange={handleChange}
            required
          />

          <button type="submit">Log in</button>
        </form>

        <div className="auth-footer">
          Don’t have an account? <a href="/signup">Sign up</a>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
