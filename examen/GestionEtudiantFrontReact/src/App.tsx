import { BrowserRouter as Router, Routes, Route, } from 'react-router-dom';
import Login from './views/Login';
import Dashboard from './views/Dashboard';
import Students from './views/Students';
import Navbar from './components/Navbar';
import ViewClasses from './views/Classes';
import Teachers from './views/Teacher';


function AppRoutes() {


  return (
    <>
      {<Navbar />}
      <div className="container mt-4">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/students" element={<Students />} />
          <Route path="/classes" element={<ViewClasses/>} />
          <Route path="/teachers" element={<Teachers/>} />
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </div>
    </>
  );
}

function App() {
  return (
    <Router>
        <AppRoutes />

    </Router>
  );
}

export default App;