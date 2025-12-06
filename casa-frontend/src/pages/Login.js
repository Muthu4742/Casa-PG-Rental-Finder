import { useState } from 'react';
import { login } from '../api/api';

export default function Login(){
  const[email,setEmail]=useState('');
  const[password,setPassword]=useState('');

  const submit=async()=>{
    try{
      await login({email,password});
      alert('Login successful');
    }catch(e){ alert('Invalid credentials'); }
  };

  return(
    <div style={{padding:20}}>
      <h2>Login</h2>
      <input placeholder="Email" onChange={e=>setEmail(e.target.value)}/><br/>
      <input placeholder="Password" type="password" onChange={e=>setPassword(e.target.value)}/><br/>
      <button onClick={submit}>Login</button>
    </div>
  );
}
