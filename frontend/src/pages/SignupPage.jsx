import { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";
import "./Auth.css";

function SignupPage() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSignup = async (e) => {
    e.preventDefault();
    try {
      await api.post("/auth/signup", form);
      alert("Signup successful!");
      navigate("/login");
    } catch {
      alert("Username or email already exists");
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-box">
        <div className="auth-logo">Instagram</div>

        <form onSubmit={handleSignup}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            onChange={handleChange}
            required
          />

          <input
            type="email"
            name="email"
            placeholder="Email"
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

          <button type="submit">Sign up</button>
        </form>

        <div className="auth-footer">
          Have an account? <a href="/login">Log in</a>
        </div>
      </div>
    </div>
  );
}

export default SignupPage;
