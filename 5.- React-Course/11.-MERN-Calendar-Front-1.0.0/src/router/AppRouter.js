import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Redirect
  } from 'react-router-dom'; // importo el react-router-dom es para trabajar las rutas , antes lo debi instalar con npm 

import { LoginScreen } from '../components/auth/LoginScreen'; // se usa en la ruta login
import { CalendarScreen } from '../components/calendar/CalendarScreen'; // se usa en la ruta home


//Maneja las rutas implementacion de las rutas
export const AppRouter = () => {
    return (
        
        <Router> {/* envuelve al switch ruoter para manejar los Routes */}
            <div>
                <Switch>{/* envuelve al route */}
                    {/* las rutas me llevan al componente respectivo */}
                    <Route exact path="/login" component={ LoginScreen } />      
                    <Route exact path="/" component={ CalendarScreen } />

                    <Redirect to="/" />   {/*redireccion al home, en caso que  no se encuentre la pagina */}
                     
                </Switch>
            </div>
        </Router>
    )
}
