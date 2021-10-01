import React from 'react';
import { Link } from 'react-router-dom';
import { useDispatch, useSelector} from 'react-redux';
import validator from 'validator';

import { useForm } from '../../hooks/useForm';
import { setError, removeError } from '../../actions/ui';
import { startRegisterWithEmailPasswordName } from '../../actions/auth';

export const RegisterScreen = () => {

    //para hacer dispatch para disparar las acciones
    const dispatch = useDispatch();

  
    //hook que recibe un callback en el cual obtengo el state general de mi app, en el store, enla funcion reducers (combine reducers)
   // para seleccionar ciertos reducers que conforman el state general
    const { msgError } = useSelector( state => state.ui );//agarramos el state ui, devuelve un objeto y desestructuramos solo msgError
 

    //codigo en duro para que el form este relleno, seria el estado inicial del useForm
    const [ formValues, handleInputChange ] = useForm({ //use form regresa un arreglo con tres elementos
        name: 'Hernando',
        email: 'nando@gmail.com',
        password: '123456',
        password2: '123456',
    });

    //desestructuramos el estado actual del useForm que que el formValues, asignamos estos campos a los inputs
    const { name ,email ,password ,password2 } = formValues;

    const handleRegister = (e) => {
        e.preventDefault(); //evita el refresh no haga la propagacion del formulario por el url


        if ( isFormValid() ) { // si isFormValid retorna true
            // que lanze esta accion que registra al usuario con la cuenta de google, graba al usuario en firebase
            dispatch( startRegisterWithEmailPasswordName(email, password, name) );
        }

    }

    // validaciones para 
    const isFormValid = () => {
        
        if ( name.trim().length === 0 ) { // si no se llena el nombre 
            dispatch( setError('Name is required') )
            return false;// si no se cumple que el metodo devuelva un false
        } else if ( !validator.isEmail( email ) ) { // si esto no cumple con las caracteristicas de un email (metodo de validator)
            dispatch( setError('Email is not valid') ) // lanse esta accion
            return false; // devuelva false en el metodo
        } else if ( password !== password2 || password.length < 5 ) { // si no es igual a pwd 2 y no es mayor que 5 
            dispatch( setError('Password should be at least 6 characters and match each other') )
            return false
        }
        
        // si todo se cumple que lance esta accion , si el formulario se llena correctamente
        //por si previamente hubo algun error, una vez corregido y dado click , como no hay errr
        //regresara a su estado inicial
        dispatch( removeError() ); 
       return true; //metodo retorna true
    }

    return (
        <>
            <h3 className="auth__title">Register</h3>

            <form onSubmit={ handleRegister }> {/** handleRegister hace las validaciones de los inputs */}

                {
                    msgError && // si el msgErro es true o  no es null entonces
                    (
                        <div className="auth__alert-error">
                            { msgError } 
                        </div>
                    )
                }


                <input 
                    type="text"
                    placeholder="Name"
                    name="name"
                    className="auth__input"
                    autoComplete="off"
                    value={ name }
                    onChange={ handleInputChange } //el estado del input
                />

                <input 
                    type="text"
                    placeholder="Email"
                    name="email"
                    className="auth__input"
                    autoComplete="off"
                    value={ email }
                    onChange={ handleInputChange }
                />

                <input 
                    type="password"
                    placeholder="Password"
                    name="password"
                    className="auth__input"
                    value={ password }
                    onChange={ handleInputChange }
                />

                <input 
                    type="password"
                    placeholder="Confirm password"
                    name="password2"
                    className="auth__input"
                    value={ password2 }
                    onChange={ handleInputChange }
                />


                <button
                    type="submit"
                    className="btn btn-primary btn-block mb-5"
                >
                    Register
                </button>

               

                <Link 
                    to="/auth/login"
                    className="link"
                >
                    Already registered?
                </Link>

            </form>
        </>
    )
}
