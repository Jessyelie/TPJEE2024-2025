
import { Link, useNavigate } from 'react-router-dom';


function Navbar() {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate('/login');
  };

  return !window.location.href.includes("/login") && (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container">
        <Link className="navbar-brand" to="/dashboard">GestionEtudiants</Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">

          <ul className="navbar-nav me-auto">
            {!window.location.href.includes("/dashboard") &&
              <>
                <li className="nav-item">
                  <Link className="nav-link" to="/students">Étudiants</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/classes">Classes</Link>
                </li><li className="nav-item">
                  <Link className="nav-link" to="/teachers">Enseignants</Link>
                </li><li className="nav-item">
                  <Link className="nav-link" to="/courses">Cours</Link>
                </li>
              </>}
          </ul>

          <button
            onClick={handleLogout}
            className="btn btn-outline-light"
          >
            Déconnexion
          </button>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;