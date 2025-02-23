import { Link } from 'react-router-dom';

function Dashboard() {
  return (
    <div className="container">
      <h1 className="mb-4">Tableau de bord</h1>
      <div className="row">
        <div className="col-md-4 mb-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Étudiants</h5>
              <p className="card-text">Gérer les étudiants</p>
              <Link to="/students" className="btn btn-primary">Accéder</Link>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Classes</h5>
              <p className="card-text">Gérer les classes</p>
              <Link to="/classes" className="btn btn-primary">Accéder</Link>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Enseignants</h5>
              <p className="card-text">Gérer les enseignants</p>
              <Link to="/teachers" className="btn btn-primary">Accéder</Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;