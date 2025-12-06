
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import AddProperty from './pages/AddProperty';
import PropertyList from './pages/PropertyList';
import Navbar from './components/Navbar';

export default function App(){
  return(
    <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<Register/>}/>
        <Route path="/add-property" element={<AddProperty/>}/>
        <Route path="/properties" element={<PropertyList/>}/>
      </Routes>
    </BrowserRouter>
  );
}
