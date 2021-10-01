import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';

import { LoginScreen } from '../components/auth/LoginScreen';
import { RegisterScreen } from '../components/auth/RegisterScreen';


// esto se muestra cuando el usuario esta autenticado
export const AuthRouter = () => {
    return (
        <div className="auth__main">{/** estilos en _auth.scss */}
            <div className="auth__box-container"> {/** reutilizando contenedos que aplica el estilo tanto al login como al register */}
                {/* rutas hijas a las cuales apunta el authRouter */}
                <Switch> {/* switch busca la ruta exacta y encuanto la encuetra deja de  */}
                    
                    <Route exact  path="/auth/login" component={LoginScreen} />

                    <Route exact path="/auth/register"  component={RegisterScreen}/>

                    <Redirect to="/auth/login" />


                </Switch>
            </div>

        </div>
    )
}
