import { types } from '../types/types';

// const state = {
//     name: 'Fernando',
//     logged: true
// }


export const authReducer = (state = {}, action ) => {

    // se evalua el action.type
    switch ( action.type ) {
        //string del types
        case types.login:
        //retornamos todo lo que venga en el action.payload    
        return {
                ...action.payload,
                logged: true //si pasa la autenticacion true
            }

        //si no esta autenticado retirna falso
        case types.logout:
            return {
                logged: false
            }
    
    //return del state asi como se encuentre
        default:
            return state;
    }

}