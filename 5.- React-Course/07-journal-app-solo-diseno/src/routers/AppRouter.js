import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Redirect
  } from 'react-router-dom';

import { AuthRouter } from './AuthRouter';
import { JournalScreen } from '../components/journal/JournalScreen';

export const AppRouter = () => {
    return (
        <Router>
            <div>  {/* div para manejar la agrupacion del dir*/}
                <Switch> {/* switch busca la ruta exacta y encuanto la encuetra deja de  */}
                {/* los disenos estan  en las rutas */}
                    <Route path="/auth" component={ AuthRouter } />

                    <Route exact path="/" component={ JournalScreen }/>

                    <Redirect to="/auth/login" />


                </Switch>
            </div>
        </Router>
    )
}
