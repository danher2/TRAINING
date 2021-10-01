import React from 'react';
import PropTypes from 'prop-types';

import { Route, Redirect } from 'react-router-dom';

//componente para redirigir a una ruta publica
//todos los demas argumento que tenga el componente en donde se implemente
// como el path, exact etc los se extreen del el argumento en el 
//primer  arumento es un booleano
//segundo argumento es un componente nota que empieza con mayuscula porque es un Componente
//tercer argumento que es =  ...rest
export const PublicRoute = ({isAuthenticated,component: Component, ...rest}) => {

    //se retorna un route (porque este componente se usara en appRouter)
    return (
        <Route { ...rest }
            component={ (props) => (
                ( !isAuthenticated )// si no esta autenticado
                    ? ( <Component { ...props } /> ) // si no esta autenticado me debe regresar el componente con todos sus arguments
                    : ( <Redirect to="/" /> )
            )}
        
        />
    )
}

PublicRoute.propTypes = {
    isAuthenticated: PropTypes.bool.isRequired,
    component: PropTypes.func.isRequired
}
