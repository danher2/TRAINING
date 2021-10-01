import { fetchSinToken, fetchConToken } from '../helpers/fetch';
import { types } from '../types/types';
import Swal from 'sweetalert2';


//estas son las funciones de mis acciones

//empieza el proceso de mi autenticacion, tarea asincrona
export const startLogin = ( email, password ) => { // recibe email y password
   
    return async( dispatch ) => { // dispatch gracias a Thunk, funcion asincrona

        const resp = await fetchSinToken( 'auth', { email, password }, 'POST' ); // llamamos el endpoint, data que queremos enviar, y el tipo del metodo
        const body = await resp.json(); // leemos el body

        if( body.ok ) { // si todo sale bien
            //grabamos en el localStorage  el token y la hora
            localStorage.setItem('token', body.token );
            localStorage.setItem('token-init-date', new Date().getTime() );

            //ESTO ES LO QUE SE MANDA REALMENTE AL REDUCER, los dispatch mandan una accion  al reducer siempre
            dispatch( login({
                //este es el payload ;) 
                uid: body.uid,
                name: body.name
            }) )
        } else {// si algo sale mal, si escribe mal la contrasena
            Swal.fire('Error', body.msg, 'error'); // lanza error
        }
        

    }
}


//proceso de registro
export const startRegister = ( email, password, name ) => {
    return async( dispatch ) => { //disptach gracias athunk

        const resp = await fetchSinToken( 'auth/new', { email, password, name }, 'POST' );
        const body = await resp.json(); // extraemos  el body, lo que mandamos

        if( body.ok ) {  //si todo esta bien
            //guardamos en el local
            localStorage.setItem('token', body.token );
            localStorage.setItem('token-init-date', new Date().getTime() );


            //DISPARAMOS LA ACCION AL REDUCER  CON EL ID Y EL USUARIO
            dispatch( login({
                uid: body.uid,
                name: body.name
            }) )
        } else { //si algo sale mal mande error
            Swal.fire('Error', body.msg, 'error');
        }


    }
}

//cuando empezamos el cheking (funcion que dispara la accion realmente)
export const startChecking = () => {
    return async(dispatch) => {

        const resp = await fetchConToken( 'auth/renew' );
        const body = await resp.json();

        if( body.ok ) {
            localStorage.setItem('token', body.token );
            localStorage.setItem('token-init-date', new Date().getTime() );



            //ESTA ES LA ACCION QUE SE DISPARA
            dispatch( login({
                uid: body.uid,
                name: body.name
            }) )
        } else {
            dispatch( checkingFinish() ); // termina de checar
        }
    }
}


//accion cuando finaliza el chequeo
const checkingFinish = () => ({ type: types.authCheckingFinish });



const login = ( user ) => ({
    type: types.authLogin,
    payload: user
});



export const startLogout = () => {
    return ( dispatch ) => {

        localStorage.clear();//destruimos el token y asi nos saca de la sesion
        dispatch( logout() );  // limpiamos el state del usuario
    }
}

const logout = () => ({ type: types.authLogout })