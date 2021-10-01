import React, { useEffect } from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Redirect
  } from 'react-router-dom';
  
import { useDispatch, useSelector } from 'react-redux';

import { LoginScreen } from '../components/auth/LoginScreen';
import { CalendarScreen } from '../components/calendar/CalendarScreen';
import { startChecking } from '../actions/auth';
import { PublicRoute } from './PublicRoute';
import { PrivateRoute } from './PrivateRoute';

export const AppRouter = () => {

    const dispatch = useDispatch();

    //pendiente de los cambion de checking y uid del state de auth
    const { checking, uid } = useSelector( state => state.auth); // estamos a la escucha si el cheking esta en false, si esta en true entonces esta checando

    useEffect(() => {
        
        dispatch( startChecking() );

    }, [dispatch])

    if ( checking ) {// si cheking es true
        return (<h5>Espere...</h5>); // se muestre esto
    }

    return (
        <Router>
            <div>
                <Switch>
                    {/* se muestra si no estoy autenticado */}
                    <PublicRoute 
                        exact 
                        path="/login" 
                        component={ LoginScreen }
                        isAuthenticated={ !!uid } // lo convertimos en boobleano con la doble negacion, si hay usuario, lo obtenco del state del reducer auth
                    />
                    {/*Se muestra si ya estoy autenticado  */}
                    <PrivateRoute 
                        exact 
                        path="/" 
                        component={ CalendarScreen } // que nose lleve a nuestro Calendar Screen
                        isAuthenticated={ !!uid }
                    />

                    <Redirect to="/" />   
                </Switch>
            </div>
        </Router>
    )
}
