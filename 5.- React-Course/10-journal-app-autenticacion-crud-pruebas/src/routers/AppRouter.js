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
import { startLoadingNotes } from '../actions/notes';

//AppRouter, el componente que  manejas las rutas de la app tanto publicas como privadas

export const AppRouter = () => {

    const dispatch = useDispatch(); //para disparar las acciones a los reducers

    const [ checking, setChecking ] = useState(true);
    const [ isLoggedIn, setIsLoggedIn ] = useState(false);



    useEffect(() => {
        
        firebase.auth().onAuthStateChanged( async(user) => { // en la autenticacion con firebase mandamos el objeto usuario

            if ( user?.uid ) { // si hay uid?
                dispatch( login( user.uid, user.displayName ) ); // disparame la accion del login , con el id y el nombre del usuario
                setIsLoggedIn( true ); // tras la accion el usuario esta logeado: true
                dispatch( startLoadingNotes( user.uid ) );  // se dispara la accion que cargans las notas, peticion get a firebase

            } else {
                setIsLoggedIn( false ); // si nada de lo anterior ocurre, no se loggea
            }

            setChecking(false); //termino de checar, el checking ahora es falso

        });
        
    }, [ dispatch, setChecking, setIsLoggedIn ])// este a la escucha si estas dependencias cambian


    if ( checking ) { // mientras checking es true
        return (
            <h1>Wait...</h1> // esperando
        )
    }

    
    return (
        <Router> {/*  envuelve a los routes se descarga el react route dom*/}
            <div>
                <Switch>{/* siempre emvuelve a los routes */}
                    <PublicRoute  //componente hecho por mi
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
