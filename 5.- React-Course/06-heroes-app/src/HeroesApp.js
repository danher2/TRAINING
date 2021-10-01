import React, { useEffect, useReducer } from 'react'
import { AuthContext } from './auth/AuthContext';
import { authReducer } from './auth/authReducer';
import { AppRouter } from './routers/AppRouter'



const init = () => {
    //leemos el localStorage a ver si se tiene el user
    //como el user es un objeto usamos JSON.parse para evaluarlo
    //si existe lo retorna y si no regresara un objeto que tenga el
    //logged en false
    return JSON.parse(localStorage.getItem('user')) || { logged: false };
}




export const HeroesApp = () => {
   
    //authReducer el reducer que utilizaremos, inicializamos con un objeto vacio, init porque se va a leer el localStorage
   //user es el state, dispatch el disparador de accion
    const [ user, dispatch ] = useReducer(authReducer, {}, init);


    useEffect(() => {
        //si el user cambia me va guardar el user en el localstorage
        //graba en el local storage al usuario si este cambia
        localStorage.setItem( 'user', JSON.stringify(user) );
    }, [user])

   
    return (
        
        //para proveer la informacion  a lo largo de la app
        // proveemo sla info del user y del dispatch
        <AuthContext.Provider value={{ user, dispatch }}>
            <AppRouter />
        </AuthContext.Provider>

    )

}



