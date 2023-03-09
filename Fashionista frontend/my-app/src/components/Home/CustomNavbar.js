import { Button } from "bootstrap";
import React, { useState } from "react";
import FashionistaLogo from "../../images/logo/FashionistaLogo.jpg";
import LoginModal from "./LoginModal";

const CustomNavbar = () => {
  const [showLoginModal, setShowLoginModal] = useState(false);
  const [showRegisterModal, setShowRegisterModal] = useState(false);



  const handleLoginClick = () => {
    setShowLoginModal(true);
  };

  const handleLoginModalClose = () => {
    setShowLoginModal(false);
  };

  const handleRegisterClick = () => {
    setShowRegisterModal(true);
  }

  const handleRegisterModalClose = () => {
    setShowRegisterModal(false);
  }

  return (
    <>
      <nav
        className="navbar navbar-expand-lg bg-body-tertiary"
        style={{ backgroundColor: "#e3f2fd" }}
      >
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            <img src={FashionistaLogo} alt=""></img>
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">
                  Home
                </a>
              </li>
            </ul>
            <form className="d-flex ml-auto" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button className="btn btn-outline-success mx-2" type="submit">
                Search
              </button>
            </form>

            <div>
              <button
                className="btn btn-outline-secondary mx-2"
                onClick={handleLoginClick}
              >
                Login
              </button>
              {showLoginModal && <LoginModal onClose={handleLoginModalClose} />}
            </div>

            <div>
              <button
                className="btn btn-outline-secondary mx-2"
                onClick={handleRegisterClick}
              >
                Register
              </button>
              {showLoginModal && <LoginModal onClose={handleLoginModalClose} />}
            </div>
            
          </div>
        </div>
      </nav>
    </>
  );
};

export default CustomNavbar;
