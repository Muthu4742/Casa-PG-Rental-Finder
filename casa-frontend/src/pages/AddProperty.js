import { useState } from 'react';
import { addProperty } from '../api/api';

export default function AddProperty(){
  const [data,setData]=useState({});

  const change=e=>setData({...data,[e.target.name]:e.target.value});

  const submit=async()=>{
    await addProperty(data);
    alert('Property added');
  };

  return(
    <div style={{padding:20}}>
      <h2>Add Property</h2>
      <input name="title" placeholder="Title" onChange={change}/><br/>
      <input name="location" placeholder="Location" onChange={change}/><br/>
      <input name="rent" placeholder="Rent" onChange={change}/><br/>
      <input name="ownerName" placeholder="Owner Name" onChange={change}/><br/>
      <input name="contact" placeholder="Contact" onChange={change}/><br/>
      <textarea name="description" placeholder="Description" onChange={change}/><br/>
      <button onClick={submit}>Submit</button>
    </div>
  );
}
