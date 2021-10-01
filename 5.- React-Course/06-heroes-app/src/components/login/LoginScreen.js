import React, { useContext } from 'react';
import { AuthContext } from '../../auth/AuthContext';
import { types } from '../../types/types';

export const LoginScreen = ({ history }) => {

    //se extrae el dispatch del AuthContext mediante el hook useCOntext
    const { dispatch } = useContext( AuthContext );


    //Manejador del login, metodo que se ejecuta cuanto se presiona Login
    const handleLogin = () => {

        //obtenemos el lastpath que almacenamos en  privateRoute
        // si se purgo el localStorage entonces no existe y si no existe entonces
        // || '/'  que nos redireccione a la ruta principal por defecto
        const lastPath = localStorage.getItem('lastPath') || '/';

        //disparador de la action
        // se hace el dispatch de un objeto que tiene el type
        //se estabelece la action dentro del dispatch
        dispatch({
            type: types.login,
            payload: {
                name: 'Daniel'
            }
        });

        // reemplazamos con el lastpath
        history.replace( lastPath );
        
    }

    return (
        <div className="container mt-5">
            <h1>Login</h1>
            <hr />

            <button
                className="btn btn-primary"
                onClick={ handleLogin }
            >
                Login
            </button>

        </div>
    )
}
