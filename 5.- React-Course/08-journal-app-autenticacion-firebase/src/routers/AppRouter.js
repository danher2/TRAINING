import React, { useEffect, useState } from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Redirect
  } from 'react-router-dom';

import { useDispatch } from 'react-redux';

import { firebase } from '../firebase/firebase-config'
import { AuthRouter } from './AuthRouter';
import { PrivateRoute } from './PrivateRoute';

import { JournalScreen } from '../components/journal/JournalScreen';
import { login } from '../actions/auth';
import { PublicRoute } from './PublicRoute';

export const AppRouter = () => {

    const dispatch = useDispatch();

    const [ checking, setChecking ] = useState(true);
    const [ isLoggedIn, setIsLoggedIn ] = useState(false);



    useEffect(() => {
        
        firebase.auth().onAuthStateChanged( (user) => { //user is taken by store uireducer

            if ( user?.uid ) { // ? = si el user tiene algo, tiene usuario, esta loggeado
                dispatch( login( user.uid, user.displayName ) );
                setIsLoggedIn( true ); // si se logea en true
            } else { // si no hay usuario
                setIsLoggedIn( false ); // no esta logeado
            }

            setChecking(false);

        });
        
    }, [ dispatch, setChecking, setIsLoggedIn ]) //cuando cambien estas dependencias


    if ( checking ) { // el checking funciona como una bandera, si esta revisando la autenticacion
        return (
            <h1>Espere...</h1>
        )
    }

    //proteccion de las respectivas rutas
    return (
        <Router>
            <div>
                
                <Switch> {/* para buscar entre las direfentes rutas */} 
                    <PublicRoute 
                        path="/auth"
                        component={ AuthRouter }
                        isAuthenticated={ isLoggedIn }
                    />

                    <PrivateRoute 
                        exact
                        isAuthenticated={ isLoggedIn }
                        path="/"
                        component={ JournalScreen }
                    />

                    <Redirect to="/auth/login" />


                </Switch>
            </div>
        </Router>
    )
}
