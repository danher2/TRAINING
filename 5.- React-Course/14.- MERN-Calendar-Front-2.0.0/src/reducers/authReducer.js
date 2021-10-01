// para manejar el stado de autenticacion de mi usuariooooo

import { types } from '../types/types';

const initialState = {
    checking: true,  //verifica si el usuario esta autenticado o no, uando la app se carga sino esta autenticado se manda a login
    // uid: null,
    // name: null
}

// para cambiar el estado del reducer
export const authReducer = ( state = initialState, action ) => {

    switch ( action.type ) {
        
        case types.authLogin:
            //regresa un nuevo state
            return { 
                ...state, // retorna la compia del state como se encuentre
                ...action.payload, // en el payload se encuentra el usuario  id y el name 
                checking: false // porque ya se autentico el usuario
            }

        case types.authCheckingFinish:
            return {
                ...state,
                checking: false // finalizamos el chequeo
            }

        case types.authLogout:
            return { // no retornamos el state completo solo el cheking
                checking: false // limipiamos el state del usuario
            }


        default:
            return state;
    }

}


