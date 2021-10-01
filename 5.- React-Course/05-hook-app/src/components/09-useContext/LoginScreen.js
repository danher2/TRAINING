import React, { useContext } from 'react'
import { UserContext } from './UserContext'

export const LoginScreen = () => {
   
   //obtener refe al context
    const {setuser} = useContext(UserContext);

   
   
    return (
        <div>
           <h1>LoginScreen</h1>
            <hr/> 
            <button 
            className = "btn btn-primary"
            onClick = { () => setuser({
                id: 123,
                name: 'Daniel'

            })}
            >Login</button>
        </div>
    )
}
