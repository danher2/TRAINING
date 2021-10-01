import React, { useEffect, useState } from 'react'
import './effects.css'
import { Message } from './Message';

export const SimpleForm = () => {
    
    const [formState, setformState] = useState({
        name: '',
        email: ''
    });

    //desestructurando el formState
    const {name, email} = formState;


    //efecto secundario cuando le suceda algo a nuestros componentes
    useEffect( () => {
        // console.log('hey!');
    }, []);
    
    //cuando el form completo cambia
    useEffect( () => {
        // console.log('FormState cambio!');
    }, [formState]);
    
    
    //cuando solo el email cambia
    useEffect( () => {
        // console.log('email cambioo!');
    }, [email]);

    const handleInputChange = ({target})=>{

        setformState({
            ...formState,
            [target.name]: target.value
        });
    }
    
     return (
        <>
            
        <h1>useEffect</h1>
        <hr/>

        <div className = "form-group">
        <input
            type = "text"
            name = "name"
            className= "form-control"
            placeholder="Tu nombre"
            autoComplete="off"
            value= {name}
            onChange={handleInputChange}
         />
        </div>




        <div className = "form-group">
        <input
            type = "text"
            name = "email"
            className= "form-control"
            placeholder="email@gmail.com"
            autoComplete="off"
            value= {email}
            onChange={handleInputChange}
         />
        </div>


            {(name==='123') && <Message/>}



        </>
    )
}
