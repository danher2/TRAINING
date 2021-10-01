import React from 'react';
import { useDispatch, useSelector } from 'react-redux';

import { Link } from 'react-router-dom';
import { useForm } from '../../hooks/useForm';
import { startLoginEmailPassword, startGoogleLogin } from '../../actions/auth';

export const LoginScreen = () => {

    const dispatch = useDispatch(); // hook de reduxsirve para dar acceso al dispath
    const { loading } = useSelector( state => state.ui );

    // el useForm devuelve un arreglo con tres elementos de los cuales solo desestructuramos formvalues=estado actual y la funcion handleInputChange
    const [ formValues, handleInputChange ] = useForm({
        email: 'nando@gmail.com', // definimos el estado inicial
        password: '123456'
    });

    //formvalues es el estado inicial y lo desestructuramos en sus propiedades
    const { email, password } = formValues;

    const handleLogin = (e) => {
        e.preventDefault(); //para evitar el refresh
        dispatch( startLoginEmailPassword( email, password ) );
    }

    //dispatch para la accion del boton de google
    const handleGoogleLogin = () => {
        dispatch( startGoogleLogin() );
    }


    return (
        <>
            <h3 className="auth__title">Login</h3>

            <form onSubmit={ handleLogin }> {/**onSubmit manda un evento */}

                <input 
                    type="text"
                    placeholder="Email"
                    name="email"
                    className="auth__input"
                    autoComplete="off"
                    value={ email } // se carga por defecto el email del estado inicial 
                    onChange={ handleInputChange } // le damos el comportamiento al input
                />

                <input 
                    type="password"
                    placeholder="Password"
                    name="password"
                    className="auth__input"
                    value={ password } // se carga por defecto el password del estado inicial 
                    onChange={ handleInputChange } // le damos el comportamiento al input
                />


                <button
                    type="submit"
                    className="btn btn-primary btn-block"
                    disabled={ loading }
                >
                    Login
                </button>

                
                <div className="auth__social-networks">
                    <p>Login with social networks</p>

                    <div 
                        className="google-btn"
                        onClick={ handleGoogleLogin } // funcion para el boton de google
                    >
                        <div className="google-icon-wrapper">
                            <img className="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg" alt="google button" />
                        </div>
                        <p className="btn-text">
                            <b>Sign in with google</b>
                        </p>
                    </div>
                </div>

                <Link 
                    to="/auth/register"
                    className="link"
                >
                    Create new account    
                </Link>

            </form>
        </>
    )
}
