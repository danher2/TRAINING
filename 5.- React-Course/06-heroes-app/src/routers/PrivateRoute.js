import React from 'react';
import PropTypes from 'prop-types';

import { Route, Redirect } from 'react-router-dom';

//componente para redirigir a una ruta privada
//todos los demas argumento que tenga el componente en donde se implemente
// como el path, exact etc los se extreen del el argumento en el 
//primer  arumento es un booleano
//segundo argumento es un componente nota que empieza con mayuscula porque es un Componente
//tercer argumento que es =  ...rest
export const PrivateRoute = ({isAuthenticated,component: Component,...rest}) => {
    // guarda las rutas a las que accedimos
    // console.log(rest.location.pathname);

    //almacenamos en el localStorage las path  a las que estamos navegando
    //"lastPath" es la key
    localStorage.setItem('lastPath', rest.location.pathname);

    //se retorna un route (porque este componente se usara en appRouter)
   //
    return (
        //se le manda primero los argumentos ...rest (exact, path, etc
        <Route { ...rest }
        //despues se le manda el componente que es un callback
            component={ (props) => ( // los props vienen siendo todos los argumentos argumento que lleva ese componente (history location y storage etc)
                ( isAuthenticated )// se usan ternarios -> condición ? expr1 : expr2 
                    ? ( <Component { ...props } /> )// si esta autenticado me debe regresar el componente con todos sus arguments
                    : ( <Redirect to="/login" /> ) // si no esta autenticado me debe redirigir a el login
            )}
        
        />
    )
}

PrivateRoute.propTypes = {
    isAuthenticated: PropTypes.bool.isRequired,
    component: PropTypes.func.isRequired
}
