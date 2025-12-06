import { useState } from 'react';
import { register } from '../api/api';

export default function Register(){
  const[fullName,setName]=useState('');
  const[email,setEmail]=useState('');
  const[password,setPassword]=useState('');
  const[role,setRole]=useState('TENANT');

  const submit=async()=>{
    await register({fullName,email,password,role});
    alert('Registered successfully');
  };

  return(
    <div style={{padding:20}}>
      <h2>Register</h2>
      <input placeholder="Full Name" onChange={e=>setName(e.target.value)}/><br/>
      <input placeholder="Email" onChange={e=>setEmail(e.target.value)}/><br/>
      <input placeholder="Password" type="password" onChange={e=>setPassword(e.target.value)}/><br/>
      <select onChange={e=>setRole(e.target.value)}>
        <option value="TENANT">Tenant</option>
        <option value="OWNER">Owner</option>
      </select><br/>
      <button onClick={submit}>Register</button>
    </div>
  );
}
