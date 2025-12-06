
import { Link } from 'react-router-dom';

export default function Navbar(){
  return(
    <nav style={{padding:'10px', background:'#eee'}}>
      <Link to="/" style={{marginRight:10}}>Home</Link>
      <Link to="/properties" style={{marginRight:10}}>Properties</Link>
      <Link to="/add-property" style={{marginRight:10}}>Add Property</Link>
      <Link to="/login" style={{marginRight:10}}>Login</Link>
    </nav>
  );
}
