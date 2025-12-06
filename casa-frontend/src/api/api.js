
import axios from 'axios';
const API='http://localhost:8080';

export const register=(data)=>axios.post(API+'/api/auth/register', data);
export const login=(data)=>axios.post(API+'/api/auth/login', data);
export const addProperty=(data)=>axios.post(API+'/api/properties', data);
export const getProperties=()=>axios.get(API+'/api/properties');
