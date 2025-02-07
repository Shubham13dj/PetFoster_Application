import './App.css';
import Navbar from './component/NavBar';
import MyFooter from './component/MyFooter';
import { Outlet } from 'react-router-dom';

function App() {
  return (
    <div className="d-flex flex-column min-vh-100">  {/* Ensures full height layout */}
      <Navbar />

      {/* Main Content (Outlet) - Takes remaining space */}
      <div className="flex-grow-1">
        <Outlet />
      </div>

      <MyFooter /> {/* Always sticks to the bottom */}
    </div>
  );
}

export default App;
