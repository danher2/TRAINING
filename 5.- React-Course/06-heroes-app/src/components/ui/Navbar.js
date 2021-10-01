import React, { useContext } from 'react';
import { Link, NavLink, useHistory } from 'react-router-dom';
import { AuthContext } from '../../auth/AuthContext';
import { types } from '../../types/types';

export const Navbar = () => {

    //extraemos de nuestro  AuthContext por medio del hook useContext
    //las propiedades user y dispatch
    // y del user extraemos el nombre el cual lo ponemos en el span de abajo 
    //para que aparezca el nombre de usuario en la barra top-right
    const { user:{ name }, dispatch } = useContext(AuthContext);
    
    //hook de react Router Dom que regresa un history
    const history = useHistory();

    const handleLogout = () => {

        //redireccionar a la pagina del login utilizando el hook de arriba del history
        history.replace('/login');

        //dispatch de la accion  que llame el logout
        //mandamos la accin que tiene su type
        dispatch({
            type: types.logout
        });
    }


    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
            
            <Link 
                className="navbar-brand" 
                to="/"
            >
                Asociaciones
            </Link>

            <div className="navbar-collapse">
                <div className="navbar-nav">

                    <NavLink 
                        activeClassName="active"
                        className="nav-item nav-link" 
                        exact
                        to="/marvel"
                    >
                        Marvel
                    </NavLink>

                    <NavLink 
                        activeClassName="active"
                        className="nav-item nav-link" 
                        exact
                        to="/dc"
                    >
                        DC
                    </NavLink>
                    
                    <NavLink 
                        activeClassName="active"
                        className="nav-item nav-link" 
                        exact
                        to="/search"
                    >
                        Search
                    </NavLink>
                </div>
            </div>

            <div className="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul className="navbar-nav ml-auto">
                    {/* para que aparezca el nombre de usuarion en la top-right */}
                    <span className="nav-item nav-link text-info"> 
                        { name }
                    </span>


                    <button 
                        className="nav-item nav-link btn"
                        onClick={ handleLogout }
                    >Logout</button>
                </ul>
            </div>
        </nav>
    )
}