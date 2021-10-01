import Swal from 'sweetalert2';

import { firebase, googleAuthProvider } from '../firebase/firebase-config';
import { types } from '../types/types';
import { startLoading, finishLoading } from './ui';

//las acciones no son mas que simple funciones



export const startLoginEmailPassword = (email, password) => {
    //regresa un callback el dispatch por parametro es ofrecido por thunk
    return (dispatch) => {// proporcionado por thunk

        //emppieza a cargar cuando  intenta iniciar sesion
        dispatch( startLoading() );
        
        
        firebase.auth().signInWithEmailAndPassword( email, password )
            .then( ({ user }) => { // userCredencials
                dispatch(login( user.uid, user.displayName ));

                dispatch( finishLoading() );
            })
            .catch( e => {
                console.log(e);
                dispatch( finishLoading() );
                Swal.fire('Error', e.message, 'error');
            })

        
        
    }
}

//graba al usuario en la db de firebase es tarea asincronaa
export const startRegisterWithEmailPasswordName = ( email, password, name ) => {
    return ( dispatch ) => { //dispatch provisto por thunk, return regresa un callback
 
        //para trabajar con autenticacion
        firebase.auth().createUserWithEmailAndPassword( email, password )//metodo provisto por firebase
            .then( async({ user }) => { // user lo obtengo del dispatch

                await user.updateProfile({ displayName: name }); // del usuario obtengo el name

                dispatch(
                    login( user.uid, user.displayName )
                );
            })
            .catch( e => {
                console.log(e);
                Swal.fire('Error', e.message, 'error'); //suit alert
            })

    }
}



export const startGoogleLogin = () => {
    return ( dispatch ) => {

        firebase.auth().signInWithPopup( googleAuthProvider )
            .then( ({ user }) => {
                console.log(user);
                dispatch(
                    login( user.uid, user.displayName )// le mandamos al login el uid y el nombre del user
                )
            });

    }
}

//accion de login
export const login = (uid, displayName) => ({ // es un return
    type: types.login,
    payload: {
        uid,
        displayName
    }
});


// porque asincrono? porque signOut regresa una promesa
export const startLogout = () => {
    return async( dispatch ) => {
        await firebase.auth().signOut(); // await, esperar que esto se ejecute

        dispatch( logout() ); // diparamos la accion logout
    }
}


export const logout = () => ({
    type: types.logout
})


