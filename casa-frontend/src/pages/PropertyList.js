import { useState, useEffect } from 'react';
import { getProperties } from '../api/api';

export default function PropertyList(){
  const[data,setData]=useState([]);

  useEffect(()=>{
    getProperties().then(res=>setData(res.data));
  },[]);

  return(
    <div style={{padding:20}}>
      <h2>All Properties</h2>
      {data.map(p=>(
        <div key={p.id} style={{border:'1px solid #ccc',margin:10,padding:10}}>
          <h3>{p.title}</h3>
          <p>{p.location}</p>
          <p>Rent: ₹{p.rent}</p>
        </div>
      ))}
    </div>
  );
}
