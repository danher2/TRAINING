import React from 'react';
import { Link } from 'react-router-dom'

export const LoginScreen = () => {
    
    //no function
    
    return (
        <>
            <h3 className="auth__title">Login</h3>

            <form>

                <input 
                    type="text"
                    placeholder="Email"
                    name="email"
                    className="auth__input"
                    autoComplete="off"/> {/**que el email no tenga ninguna sugerencia con autocompletado */}

                <input 
                    type="password"
                    placeholder="Password"
                    name="password"
                    className="auth__input"
                />


                <button
                    type="submit"
                    className="btn btn-primary btn-block" 
                >Login</button>

                {/**autenticacion con redes sociales */}
                <div className="auth__social-networks"> {/**style de nuestro archivo auth.scss */}
                    <p>Login with social networks</p>

                    <div className="google-btn" >
                        <div className="google-icon-wrapper">
                            <img className="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg" alt="google button" />
                        </div>
                        <p className="btn-text">
                            <b>Sign in with google</b>
                        </p>
                    </div>
                </div>

                {/* Link de mi Router redireccionar a la pag de register */}
                <Link 
                    to="/auth/register"
                    className="link"
                >Create new account </Link>

            </form>
        </>
    )
}
